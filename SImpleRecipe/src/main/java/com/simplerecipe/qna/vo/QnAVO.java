package com.simplerecipe.qna.vo;

import java.util.Date;

public class QnAVO {
	private int qnaTbNo;
	private String qnaTbTitle;
	private String userTbId;
	private String qnaTbContent;
	private Date qnaTbRegDate;
	
	@Override
	public String toString() {
		return "QnAVO [qnaTbNo=" + qnaTbNo + ", qnaTbTitle=" + qnaTbTitle + ", userTbId=" + userTbId + ", qnaTbContent="
				+ qnaTbContent + ", qnaTbRegDate=" + qnaTbRegDate + "]";
	}
	public int getQnaTbNo() {
		return qnaTbNo;
	}
	public void setQnaTbNo(int qnaTbNo) {
		this.qnaTbNo = qnaTbNo;
	}
	public String getQnaTbTitle() {
		return qnaTbTitle;
	}
	public void setQnaTbTitle(String qnaTbTitle) {
		this.qnaTbTitle = qnaTbTitle;
	}
	public String getUserTbId() {
		return userTbId;
	}
	public void setUserTbId(String userTbId) {
		this.userTbId = userTbId;
	}
	public String getQnaTbContent() {
		return qnaTbContent;
	}
	public void setQnaTbContent(String qnaTbContent) {
		this.qnaTbContent = qnaTbContent;
	}
	public Date getQnaTbRegDate() {
		return qnaTbRegDate;
	}
	public void setQnaTbRegDate(Date qnaTbRegDate) {
		this.qnaTbRegDate = qnaTbRegDate;
	}
	
}
