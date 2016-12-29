package com.open.lcp.core.service;

import java.util.List;
import java.util.Map;

import com.open.lcp.core.api.command.ApiCommand;

public interface ApiFacadeLookupService {

	/**
	 * lookup api command from methodValue
	 * 
	 * @param methodValue
	 * @return
	 */
	public ApiCommand lookupApiCommand(String methodValue, String version);

	/**
	 * �ӿ��Ƿ�����Ȩ��ֱ�ӿ��š�
	 * 
	 * @param methodValue
	 * @param version
	 * @return
	 */
	public boolean isOpen(String methodValue, String version);

	/**
	 * �Ƿ���Ҫ��¼
	 * 
	 * @param methodvalue
	 * @return
	 */
	public boolean isNeedLogin(String methodValue, String version);

	/**
	 * ȡ���еĽӿ������б�
	 * 
	 * @return
	 */
	public Map<String, List<String>> getCommands();

	/**
	 * ȡ��ǰ֧�ֵķ������汾�б�
	 * 
	 * @return
	 */
	String[] getApiAndVerList();

	/**
	 * ȡ��ǰ�汾�����ĵ��ô����ϼ�
	 * 
	 * @param apiAndVer
	 * @return
	 */
	long getApiAndVerPv(String apiAndVer);

}
