package com.open.lcp.biz.passport.service;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.open.lcp.biz.passport.PassportException;
import com.open.lcp.biz.passport.UserAccountType;
import com.open.lcp.biz.passport.dto.BindAccountResultDTO;
import com.open.lcp.biz.passport.service.cache.PassportCache;
import com.open.lcp.biz.passport.service.dao.PassportOAuthAccountDAO;
import com.open.lcp.biz.passport.service.dao.PassportUserAccountDAO;
import com.open.lcp.biz.passport.service.dao.entity.PassportOAuthAccountEntity;
import com.open.lcp.biz.passport.service.dao.entity.PassportUserAccountEntity;
import com.open.lcp.biz.passport.service.sdk.ThirdAccountSDK;
import com.open.lcp.biz.passport.service.sdk.ThirdAccountSDKPortrait;
import com.open.lcp.biz.passport.storage.AccountAvatarStorage;
import com.open.lcp.biz.passport.ticket.Ticket;
import com.open.lcp.biz.passport.ticket.TicketManager;
import com.open.lcp.biz.passport.util.PlaceholderAvatarUtil;
import com.open.lcp.core.common.enums.Gender;
import com.open.lcp.core.common.util.IPUtil;

public abstract class AbstractAccountService {

	private final Log logger = LogFactory.getLog(AbstractAccountService.class);

	@Resource(name = "weichatThirdAccountSDK")
	protected ThirdAccountSDK weichatUserSDK;

	@Resource(name = "xiaomiThirdAccountSDK")
	protected ThirdAccountSDK xiaomiUserSDK;

	@Resource(name = "mobileThirdAccountSDK")
	protected ThirdAccountSDK mobilAccountSDK;

	@Resource(name = "weiboThirdAccountSDK")
	private ThirdAccountSDK weiboUserSDK;

	@Resource(name = "qqThirdAccountSDK")
	protected ThirdAccountSDK qqUserSDK;

	@Autowired
	protected TicketManager ticketManager;

	@Autowired
	protected PassportCache passportCache;

	@Autowired
	protected AccountAvatarStorage accountAvatarStorage;

	@Autowired
	protected PassportUserAccountDAO passportUserAccountDAO;

	@Autowired
	protected PassportOAuthAccountDAO passportOAuthAccountDAO;

	protected Ticket checkTicket(String t) throws PassportException {
		Ticket ticketFromClient = ticketManager.decodeTicket(t);
		ticketFromClient.setT(t);

		Ticket ticketInSSDB = null;
		try {
			ticketInSSDB = passportCache.getTicket(t);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return ticketFromClient;
		}
		if (ticketInSSDB == null) {
			throw new PassportException(PassportException.EXCEPTION_TICKET_INVALID, "EXCEPTION_TICKET_INVALID", null);
		} else if (ticketInSSDB.equals(ticketFromClient)) {
			return ticketInSSDB;
		} else {
			throw new PassportException(PassportException.EXCEPTION_TICKET_INVALID, "EXCEPTION_TICKET_INVALID", null);
		}
	}

	protected Long getUserId(String openId, UserAccountType accountType) throws PassportException {
		return passportOAuthAccountDAO.getUserId(openId, accountType.type());
	}

	protected PassportUserAccountEntity obtainPassportUserAccount(Long userId) {
		if (userId == null || userId <= 0) {
			return null;
		}

		PassportUserAccountEntity userAccount = passportCache.getUserInfoByUserId(userId);
		if (userAccount == null) {
			userAccount = passportUserAccountDAO.getUserInfoByUserId(userId);

			if (userAccount != null) {
				passportCache.setUserInfoByUserId(userId, userAccount);
			}
		}
		return userAccount;
	}

	protected void multiDeviceProcess(long xlUserId, String deviceId) {
		// TODO
	}

	// insert new record into mysql.
	protected BindAccountResultDTO bindAccount(ThirdAccountSDKPortrait userPortrait, String openId, Long userId,
			String ip, UserAccountType accountType) throws PassportException {

		// store head icon
		String headIconUrl = userPortrait.getAvatar();
		String[] urls = storeHeadIcon(userId, headIconUrl, accountType);
		userPortrait.setAvatar(urls[0]);

		long now = System.currentTimeMillis();
		PassportOAuthAccountEntity passportOAuthAccountEntity = newOAuthAccountInstance(userPortrait, openId, userId,
				ip, now, accountType);

		this.bindAccount(passportOAuthAccountEntity);

		BindAccountResultDTO dto = new BindAccountResultDTO();
		dto.setBindSuccess(true);

		PassportUserAccountEntity userAccount = passportUserAccountDAO.getUserInfoByUserId(userId);

		dto.setAvatar(userAccount.getAvatar());
		dto.setGender(Gender.get(userAccount.getGender()));
		dto.setUserName(passportOAuthAccountEntity.getNickName());

		return dto;
	}

	// create new record, or update if exists.
	protected Long createAccount(ThirdAccountSDKPortrait userPortrait, String openId, Long userId, String ip,
			UserAccountType accountType, String avatar) throws PassportException {
		long now = System.currentTimeMillis();
		PassportOAuthAccountEntity passportOAuthAccountEntity = newOAuthAccountInstance(userPortrait, openId, userId,
				ip, now, accountType);
		PassportUserAccountEntity passportUserAccountEntity = newPassportUserAccountInstance(userPortrait, userId, ip,
				now, accountType);

		this.createAccount(passportUserAccountEntity, passportOAuthAccountEntity);

		if (!StringUtils.isEmpty(avatar)) {
			userId = passportUserAccountEntity.getUserId();
			String[] urls = storeHeadIcon(userId, avatar, accountType);
			userPortrait.setAvatar(urls[0]);
		}
		return passportUserAccountEntity.getUserId();
	}

	protected void login(ThirdAccountSDKPortrait userPortrait, String openId, Long userId, String ip,
			UserAccountType accountType) throws PassportException {
		long now = System.currentTimeMillis();
		PassportOAuthAccountEntity passportOAuthAccountEntity = newOAuthAccountInstance(userPortrait, openId, userId,
				ip, now, accountType);
		PassportUserAccountEntity passportUserAccountEntity = newPassportUserAccountInstance(userPortrait, userId, ip,
				now, accountType);

		recoredLoginData(passportUserAccountEntity, passportOAuthAccountEntity);
	}

	/**
	 * @return
	 */
	protected ThirdAccountSDKPortrait obtainThirdAccountSDK(String appId, String openId, String accessToken,
			UserAccountType accountType) throws PassportException {
		if (accountType.name().equalsIgnoreCase(UserAccountType.weichat.toString())) {
			return weichatUserSDK.validateAndObtainUserPortrait(appId, openId, accessToken);
		} else if (accountType.name().equalsIgnoreCase(UserAccountType.xiaomi.toString())) {
			return xiaomiUserSDK.validateAndObtainUserPortrait(appId, openId, accessToken);
		} else if (accountType.name().equalsIgnoreCase(UserAccountType.mobile.toString())) {
			return mobilAccountSDK.validateAndObtainUserPortrait(appId, openId, accessToken);
		} else if (accountType.name().equals(UserAccountType.weibo.name())) {
			return weiboUserSDK.validateAndObtainUserPortrait(appId, openId, accessToken);
		} else if (accountType.name().equals(UserAccountType.qq.name())) {
			return qqUserSDK.validateAndObtainUserPortrait(appId, openId, accessToken);
		} else {
			throw new PassportException(PassportException.EXCEPTION_INVALID_ACCOUNT_TYPE,
					"EXCEPTION_INVALID_ACCOUNT_TYPE", null);
		}
	}
	
	protected byte[] obtainHeadIconImg(String url, String appId, String openId, String accessToken,
			UserAccountType accountType) throws PassportException {
		if (accountType.name().equalsIgnoreCase(UserAccountType.weichat.toString())) {
			return weichatUserSDK.obtainAvatar(url, appId, openId, accessToken);
		} else if (accountType.name().equalsIgnoreCase(UserAccountType.xiaomi.toString())) {
			return xiaomiUserSDK.obtainAvatar(url, appId, openId, accessToken);
		} else if (accountType.name().equalsIgnoreCase(UserAccountType.mobile.toString())) {
			return mobilAccountSDK.obtainAvatar(url, appId, openId, accessToken);
		} else if (accountType.name().equals(UserAccountType.weibo.name())) {
			return weiboUserSDK.obtainAvatar(url, appId, openId, accessToken);
		} else if (accountType.name().equals(UserAccountType.qq.name())) {
			return qqUserSDK.obtainAvatar(url, appId, openId, accessToken);
		}
		return null;
	}

	private void recoredLoginData(PassportUserAccountEntity passportUserAccountEntity,
			PassportOAuthAccountEntity passportOAuthAccountEntity) {
		if (passportUserAccountEntity == null || passportUserAccountEntity.getUserId() == null
				|| passportUserAccountEntity.getUserId() <= 0) {
			throw new PassportException(PassportException.EXCEPTION_LOGIN_FAILED, "EXCEPTION_LOGIN_FAILED", null);
		}
		passportUserAccountDAO.resetLastLoginTime(passportUserAccountEntity);
		passportOAuthAccountDAO.resetLastLoginTime(passportOAuthAccountEntity);
	}

	// index0:userHeadIconUrl, index1:oauthHeadIconUrl
	private String[] storeHeadIcon(long userId, String headIconUrl, UserAccountType accountType) {
		if (StringUtils.isEmpty(headIconUrl)) {
			String url = PlaceholderAvatarUtil.getPlaceholderAvatarByMod(userId);
			return new String[] { url, url };
		} else {
			String oauthKey = accountAvatarStorage.getOAuthAvatarKey(userId, accountType);
			String oauthUrl = "";
			try {
				// byte[] image = obtainHeadIconImg(headIconUrl, oauthAppId,
				// openId, accessToken, accountType);
				oauthUrl = accountAvatarStorage.fetchResouce(headIconUrl, oauthKey);
				if (oauthUrl == null) {
					oauthUrl = PlaceholderAvatarUtil.getPlaceholderAvatarByMod(userId);
				}
			} catch (Exception e) {
				logger.warn(e.getMessage(), e);
			}

			return new String[] { headIconUrl, oauthUrl };
		}
	}

	private void createAccount(PassportUserAccountEntity passportUserAccountEntity,
			PassportOAuthAccountEntity passportOAuthAccountEntity) {

		if (StringUtils.isEmpty(passportUserAccountEntity.getAvatar())) {
			passportUserAccountEntity.setAvatar(PlaceholderAvatarUtil.getPlaceholderAvatar());
		}

		if (StringUtils.isEmpty(passportOAuthAccountEntity.getAvatar())) {
			passportOAuthAccountEntity.setAvatar(passportUserAccountEntity.getAvatar());
		}

		if (StringUtils.isEmpty(passportUserAccountEntity.getNickName())
				|| StringUtils.isEmpty(passportUserAccountEntity.getUserName())
				|| StringUtils.isEmpty(passportUserAccountEntity.getAvatar())
				|| StringUtils.isEmpty(passportOAuthAccountEntity.getNickName())
				|| StringUtils.isEmpty(passportOAuthAccountEntity.getUserName())
				|| StringUtils.isEmpty(passportOAuthAccountEntity.getAvatar())) {
			throw new PassportException(PassportException.EXCEPTION_OBTAIN_PORTRAIT_FAILED,
					"EXCEPTION_OBTAIN_PORTRAIT_FAILED", null);
		}

		long ts = System.currentTimeMillis();
		passportUserAccountEntity.setLastLoginTime(ts);
		passportOAuthAccountEntity.setLastLoginTime(ts);

		passportUserAccountEntity
				.setUserCategory(UserAccountType.valueOf(passportOAuthAccountEntity.getType()).category());

		Long createResult = passportUserAccountDAO.create(passportUserAccountEntity);
		if (createResult != null && createResult > 0) {
			passportUserAccountEntity.setUserId(createResult);
			passportOAuthAccountEntity.setUserId(createResult);
			passportOAuthAccountDAO.create(passportOAuthAccountEntity);
			// passportCache.delOAuthAccountInfoByUserIdAndType(userId, type);
			// passportCache.delUserInfoByUserId(userId);
			// passportCache.delUserId(openId, type);
		}
	}

	private PassportUserAccountEntity newPassportUserAccountInstance(ThirdAccountSDKPortrait userPortrait, Long userId,
			String ip, long time, UserAccountType nickNameType) {
		PassportUserAccountEntity userAccount = new PassportUserAccountEntity();
		userAccount.setAvatar(userPortrait.getAvatar());
		userAccount.setNickName(userPortrait.getNickname());
		userAccount.setRegistIp(IPUtil.Ip2Int(ip));
		userAccount.setRegistTime(time);
		userAccount.setGender(userPortrait.getGender().gender());
		userAccount.setUpdateIp(IPUtil.Ip2Int(ip));
		userAccount.setUpdateTime(time);
		userAccount.setUserName(userPortrait.getUsername());
		userAccount.setUserId(userId);
		return userAccount;
	}

	private PassportOAuthAccountEntity newOAuthAccountInstance(ThirdAccountSDKPortrait userPortrait, String openId,
			Long userId, String ip, long time, UserAccountType accountType) {
		PassportOAuthAccountEntity ssoAccount = new PassportOAuthAccountEntity();
		ssoAccount.setBindIp(IPUtil.Ip2Int(ip));
		ssoAccount.setBindTime(time);
		ssoAccount.setAvatar(userPortrait.getAvatar());
		ssoAccount.setNickName(userPortrait.getNickname());
		ssoAccount.setOpenId(openId);
		ssoAccount.setGender(userPortrait.getGender().gender());
		ssoAccount.setType(accountType.type());
		ssoAccount.setUpdateIp(IPUtil.Ip2Int(ip));
		ssoAccount.setUpdateTime(time);
		ssoAccount.setUserName(userPortrait.getUsername());
		ssoAccount.setUserId(userId);
		return ssoAccount;
	}

	private void bindAccount(PassportOAuthAccountEntity passportOAuthAccountEntity) {
		passportOAuthAccountDAO.create(passportOAuthAccountEntity);
	}
	
}
