package com.open.lcp.core.api.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class BlockChecker {

	/** ���һ�ξ�����־ʱ�� */
	private long lastWarnTime = System.currentTimeMillis();

	/** ���һ�ε�ǰ������־ʱ�� */
	private long lastBlockTime = System.currentTimeMillis();

	private final AtomicInteger blocked = new AtomicInteger(0);

	public long getLastWarnTime() {
		return lastWarnTime;
	}

	public long afterLastWarnTime() {
		return System.currentTimeMillis() - lastWarnTime;
	}

	public void setLastWarnTime() {
		this.lastWarnTime = System.currentTimeMillis();
	}

	public long getLastBlockTime() {
		return lastBlockTime;
	}

	public long afterLastBlockTime() {
		return System.currentTimeMillis() - lastBlockTime;
	}

	public void setLastBlockTime() {
		this.lastBlockTime = System.currentTimeMillis();
	}

	public AtomicInteger blockCounter() {
		return blocked;
	}

}
