package com.open.lcp.biz.comment.facade.resp;

import com.open.lcp.core.api.annotation.LcpParamRequired;

public class CommentUserSilencedLogResp {

	@LcpParamRequired(desc = "禁言日志编号")
	private long commentUserSilencedLogId;

	@LcpParamRequired(desc = "禁言用户编号")
	private long userId;

	@LcpParamRequired(desc = "禁言天数 -1是永久")
	private int silencedDays;

	@LcpParamRequired(value = false, desc = "禁言原因")
	private String reason;

	@LcpParamRequired(desc = "禁言开始时间")
	private long start;

	@LcpParamRequired(desc = "禁言结束时间")
	private long end;

	@LcpParamRequired(desc = "操作人")
	private String operator;

	@LcpParamRequired(desc = "创建时间")
	private long ctime;

	public long getCommentUserSilencedLogId() {
		return commentUserSilencedLogId;
	}

	public void setCommentUserSilencedLogId(long commentUserSilencedLogId) {
		this.commentUserSilencedLogId = commentUserSilencedLogId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getSilencedDays() {
		return silencedDays;
	}

	public void setSilencedDays(int silencedDays) {
		this.silencedDays = silencedDays;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public long getCtime() {
		return ctime;
	}

	public void setCtime(long ctime) {
		this.ctime = ctime;
	}
}
