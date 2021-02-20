package com.simplerecipe.notice.vo;

import java.util.Date;

public class NoticeVO {
	private int noticeTbNo;
	private String noticeTbTitle;
	private String adminTbId;
	private String noticeTbContent;
	private Date noticeTbRegDate;
	
	@Override
	public String toString() {
		return "NoticeVO [noticeTbNo=" + noticeTbNo + ", noticeTbTitle=" + noticeTbTitle + ", adminTbId=" + adminTbId
				+ ", noticeTbContent=" + noticeTbContent + ", noticeTbRegDate=" + noticeTbRegDate + "]";
	}
	public int getNoticeTbNo() {
		return noticeTbNo;
	}
	public void setNoticeTbNo(int noticeTbNo) {
		this.noticeTbNo = noticeTbNo;
	}
	public String getNoticeTbTitle() {
		return noticeTbTitle;
	}
	public void setNoticeTbTitle(String noticeTbTitle) {
		this.noticeTbTitle = noticeTbTitle;
	}
	public String getAdminTbId() {
		return adminTbId;
	}
	public void setAdminTbId(String adminTbId) {
		this.adminTbId = adminTbId;
	}
	public String getNoticeTbContent() {
		return noticeTbContent;
	}
	public void setNoticeTbContent(String noticeTbContent) {
		this.noticeTbContent = noticeTbContent;
	}
	public Date getNoticeTbRegDate() {
		return noticeTbRegDate;
	}
	public void setNoticeTbRegDate(Date noticeTbRegDate) {
		this.noticeTbRegDate = noticeTbRegDate;
	}
	
}
