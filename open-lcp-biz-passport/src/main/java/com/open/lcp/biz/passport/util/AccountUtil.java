package com.open.lcp.biz.passport.util;

import com.open.lcp.biz.passport.dto.PassportOAuthAccountDTO;
import com.open.lcp.biz.passport.dto.PassportUserAccountDTO;
import com.open.lcp.biz.passport.service.dao.entity.PassportOAuthAccountEntity;
import com.open.lcp.biz.passport.service.dao.entity.PassportUserAccountEntity;
import com.open.lcp.core.common.enums.Gender;

public class AccountUtil {

	public static PassportUserAccountDTO convertPassportUserAccoutEntity(PassportUserAccountEntity entity) {
		PassportUserAccountDTO dto = new PassportUserAccountDTO();
		dto.setAvatar(entity.getAvatar());
		dto.setDescription(entity.getDescription());
		dto.setGender(Gender.get(entity.getGender()));
		// dto.setMobile();
		dto.setNickName(entity.getNickName());
		dto.setRegistIp(entity.getRegistIp());
		dto.setRegistTime(entity.getRegistTime());
		dto.setUpdateIp(entity.getUpdateIp());
		dto.setUpdateTime(entity.getUpdateTime());
		dto.setUserId(entity.getUserId());
		dto.setUserName(entity.getUserName());
		return dto;
	}

	public static PassportOAuthAccountDTO convertPassportUserAccoutEntity(PassportOAuthAccountEntity entity) {
		PassportOAuthAccountDTO dto = new PassportOAuthAccountDTO();
		dto.setBindIp(entity.getBindIp());
		dto.setBindTime(entity.getBindTime());
		dto.setGender(Gender.get(entity.getGender()));
		dto.setAvatar(entity.getAvatar());
		dto.setNickName(entity.getNickName());
		dto.setOpenId(entity.getOpenId());
		dto.setType(entity.getUserAccountType());
		dto.setUpdateIp(entity.getUpdateIp());
		dto.setUpdateTime(entity.getUpdateTime());
		dto.setUserId(entity.getUserId());
		dto.setUserName(entity.getUserName());
		return dto;
	}
}
