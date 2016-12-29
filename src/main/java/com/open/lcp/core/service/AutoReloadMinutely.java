package com.open.lcp.core.service;

public interface AutoReloadMinutely {

	/**
	 * �Ƿ���Ҫ��ʼload
	 * 
	 * @return
	 */
	public boolean initLoad();

	/**
	 * ÿ���Ƿ��������ȣ�����true�����reload������
	 * 
	 * @param hour
	 *            ��ǰСʱ��0-23
	 * @param minute
	 *            ��ǰ���ӣ�0-59
	 * @param minuteOfAll
	 *            ��ǰ�ܷ�������1970�꿪ʼ���ܷ�����
	 * @return
	 */
	public boolean reloadable(int hour, int minute, long minuteOfAll);

	/**
	 * ����װ�ء�
	 * 
	 * @return ��Ҫ�����info��־��null������־��
	 */
	public String reload();

}
