package com.open.lcp.passport.service.dao.entity;

import com.open.common.enums.Gender;

public class PassportUserAccountEntity {

	private Long userId;

	private String userName;

	private String nickName;

	private String avatar;

	private int gender;

	private int registIp;

	private int updateIp;

	private Long registTime;

	private Long updateTime;

	private String description;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getRegistIp() {
		return registIp;
	}

	public void setRegistIp(int registIp) {
		this.registIp = registIp;
	}

	public int getUpdateIp() {
		return updateIp;
	}

	public void setUpdateIp(int updateIp) {
		this.updateIp = updateIp;
	}

	public Long getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Long registTime) {
		this.registTime = registTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public Gender getSexEnum() {
		return Gender.get(this.gender);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
