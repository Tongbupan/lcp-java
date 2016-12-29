package com.open.lcp.core.api.command;

import java.util.Map;

import com.open.lcp.core.api.info.AppInfo;
import com.open.lcp.core.api.info.AppInitInfo;
import com.open.lcp.core.api.info.UserInfo;

/**
 * �ӿ�ִ��ʱ����������Ϣ
 * 
 * @author hepengyuan
 */
public interface ApiCommandContext {

	public long getBeginTime();

	public String getMethodName();

	/** ��¼��userId */
	public long getUserId();

	public UserInfo getUserInfo();

	public AppInfo getAppInfo();

	public String getDeviceId();

	public String getSecretKey();

	public String getTicket();

	public byte[] getAesKey();

	public String getAB();

	public String getV();

	public void addStatExt(String extKey, Object extValue);

	public Map<String, String> getStringParams();

	/**
	 * �ϴ����ļ��б������Value���������� org.springframework.web.multipart.MultipartFile
	 * 
	 * @return
	 */
	public Map<String, Object> getBinaryParams();

	public int getIntParamValue(String paramName);

	public int getIntParamValue(String paramName, int defValue);

	public long getLongParamValue(String paramName);

	public long getLongParamValue(String paramName, long defValue);

	public String getParamValue(String paramName);

	public String getSig();

	public String getXForwardedFor();

	public String getClientIp();

	public int getClientPort();

	public String getUserAgent();

	public String getLanguage();

	public String getHttpHead(String name);

	/** ����LcpMethodע���е�loadAppInitData=trueʱ���ż��� */
	public AppInitInfo getAppInitInfoBean();
}
