package com.open.lcp.core.api.entity;

import com.open.lcp.core.annotation.LcpRequired;

public class LcpTimeSwitcher {

	@LcpRequired(value = true, min = 0, desc = "���ر��")
	private int tsid;
	@LcpRequired(value = false, desc = "��������")
	private String tsname;
	@LcpRequired(value = false, desc = "���ؿ�ʼ")
	private long tsbegin;
	@LcpRequired(value = false, desc = "���ؽ���")
	private long tsend;
	@LcpRequired(value = false, desc = "������������")
	private String tsext;

	public int getTsid() {
		return tsid;
	}

	public void setTsid(int tsid) {
		this.tsid = tsid;
	}

	public String getTsname() {
		return tsname;
	}

	public void setTsname(String tsname) {
		this.tsname = tsname;
	}

	public long getTsbegin() {
		return tsbegin;
	}

	public void setTsbegin(long tsbegin) {
		this.tsbegin = tsbegin;
	}

	public long getTsend() {
		return tsend;
	}

	public void setTsend(long tsend) {
		this.tsend = tsend;
	}

	public String getTsext() {
		return tsext;
	}

	public void setTsext(String tsext) {
		this.tsext = tsext;
	}

}
