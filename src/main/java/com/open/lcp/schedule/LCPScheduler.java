package com.open.lcp.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @EnableScheduling : ��ע������ʱ����������ǰ���Ƕ�ʱ����������.
 * @Scheduled(fixedRate = 1000 * 30) : ����ĳ����ʱ����
 */
@EnableScheduling
public class LCPScheduler {

	// ÿ1����ִ��һ��
	@Scheduled(cron = "0 */1 *  * * * ")
	public void ping() {
		// TODO
	}
}
