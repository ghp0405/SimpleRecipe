package com.simplerecipe.reg.vo;

import java.util.Date;

public class UserVO {
	private int userTbNo;
	private String userTbName;
	private String userTbId;
	private String userTbPwd;
	private char userTbGender;
	private Date userTbBirthday;
	private String userTbEmail;
	private String userTbPhone;
	private Date userTbJoinDate;
	private char userTbJoinPath;
	private char userTbState;
	
	@Override
	public String toString() {
		return "UserVO [userTbNo=" + userTbNo + ", userTbName=" + userTbName + ", userTbId=" + userTbId + ", userTbPwd="
				+ userTbPwd + ", userTbGender=" + userTbGender + ", userTbBirthday=" + userTbBirthday + ", userTbEmail="
				+ userTbEmail + ", userTbPhone=" + userTbPhone + ", userTbJoinDate=" + userTbJoinDate
				+ ", userTbJoinPath=" + userTbJoinPath + ", userTbState=" + userTbState + "]";
	}
	public int getUserTbNo() {
		return userTbNo;
	}
	public void setUserTbNo(int userTbNo) {
		this.userTbNo = userTbNo;
	}
	public String getUserTbName() {
		return userTbName;
	}
	public void setUserTbName(String userTbName) {
		this.userTbName = userTbName;
	}
	public String getUserTbId() {
		return userTbId;
	}
	public void setUserTbId(String userTbId) {
		this.userTbId = userTbId;
	}
	public String getUserTbPwd() {
		return userTbPwd;
	}
	public void setUserTbPwd(String userTbPwd) {
		this.userTbPwd = userTbPwd;
	}
	public char getUserTbGender() {
		return userTbGender;
	}
	public void setUserTbGender(char userTbGender) {
		this.userTbGender = userTbGender;
	}
	public Date getUserTbBirthday() {
		return userTbBirthday;
	}
	public void setUserTbBirthday(Date userTbBirthday) {
		this.userTbBirthday = userTbBirthday;
	}
	public String getUserTbEmail() {
		return userTbEmail;
	}
	public void setUserTbEmail(String userTbEmail) {
		this.userTbEmail = userTbEmail;
	}
	public String getUserTbPhone() {
		return userTbPhone;
	}
	public void setUserTbPhone(String userTbPhone) {
		this.userTbPhone = userTbPhone;
	}
	public Date getUserTbJoinDate() {
		return userTbJoinDate;
	}
	public void setUserTbJoinDate(Date userTbJoinDate) {
		this.userTbJoinDate = userTbJoinDate;
	}
	public char getUserTbJoinPath() {
		return userTbJoinPath;
	}
	public void setUserTbJoinPath(char userTbJoinPath) {
		this.userTbJoinPath = userTbJoinPath;
	}
	public char getUserTbState() {
		return userTbState;
	}
	public void setUserTbState(char userTbState) {
		this.userTbState = userTbState;
	}
	
}
