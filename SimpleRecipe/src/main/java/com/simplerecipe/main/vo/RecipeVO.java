package com.simplerecipe.main.vo;

public class RecipeVO {
	private int recipeTbNo;
	private int userTbNo;
	private String recipeTbTitle;
	private String recipeTbContentLink;
	private String recipeTbImageLink;
	
	@Override
	public String toString() {
		return "RecipeVO [recipeTbNo=" + recipeTbNo + ", userTbNo=" + userTbNo + ", recipeTbTitle=" + recipeTbTitle
				+ ", recipeTbContent=" + recipeTbContentLink + ", recipeTbImageLink=" + recipeTbImageLink + "]";
	}
	public int getRecipeTbNo() {
		return recipeTbNo;
	}
	public void setRecipeTbNo(int recipeTbNo) {
		this.recipeTbNo = recipeTbNo;
	}
	public int getUserTbNo() {
		return userTbNo;
	}
	public void setUserTbNo(int userTbNo) {
		this.userTbNo = userTbNo;
	}
	public String getRecipeTbTitle() {
		return recipeTbTitle;
	}
	public void setRecipeTbTitle(String recipeTbTitle) {
		this.recipeTbTitle = recipeTbTitle;
	}
	public String getRecipeTbContentLink() {
		return recipeTbContentLink;
	}
	public void setRecipeTbContentLink(String recipeTbContentLink) {
		this.recipeTbContentLink = recipeTbContentLink;
	}
	public String getRecipeTbImageLink() {
		return recipeTbImageLink;
	}
	public void setRecipeTbImageLink(String recipeTbImageLink) {
		this.recipeTbImageLink = recipeTbImageLink;
	}
	
}
