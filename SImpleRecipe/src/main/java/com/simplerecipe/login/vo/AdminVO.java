package com.simplerecipe.login.vo;

public class AdminVO {
	private int adminTbNo;
	private String adminTbId;
	private String adminTbPwd;
	private String adminTbPosition; // 관리자 직책
	
	@Override
	public String toString() {
		return "AdminVO [adminTbNo=" + adminTbNo + ", adminTbId=" + adminTbId + ", adminTbPwd=" + adminTbPwd
				+ ", adminTbPosition=" + adminTbPosition + "]";
	}
	public int getAdminTbNo() {
		return adminTbNo;
	}
	public void setAdminTbNo(int adminTbNo) {
		this.adminTbNo = adminTbNo;
	}
	public String getAdminTbId() {
		return adminTbId;
	}
	public void setAdminTbId(String adminTbId) {
		this.adminTbId = adminTbId;
	}
	public String getAdminTbPwd() {
		return adminTbPwd;
	}
	public void setAdminTbPwd(String adminTbPwd) {
		this.adminTbPwd = adminTbPwd;
	}
	public String getAdminTbPosition() {
		return adminTbPosition;
	}
	public void setAdminTbPosition(String adminTbPosition) {
		this.adminTbPosition = adminTbPosition;
	}
	
}
