package com.simplerecipe.main.vo;

public class IngredientListVO {
	private int recipeTbNo;
	private int ingredientTbNo;
	private String ingredientListTbAmt;
	
	@Override
	public String toString() {
		return "IngredientListVO [recipeTbNo=" + recipeTbNo + ", ingredientTbNo=" + ingredientTbNo
				+ ", ingredientListTbAmt=" + ingredientListTbAmt + "]";
	}
	public int getRecipeTbNo() {
		return recipeTbNo;
	}
	public void setRecipeTbNo(int recipeTbNo) {
		this.recipeTbNo = recipeTbNo;
	}
	public int getIngredientTbNo() {
		return ingredientTbNo;
	}
	public void setIngredientTbNo(int ingredientTbNo) {
		this.ingredientTbNo = ingredientTbNo;
	}
	public String getIngredientListTbAmt() {
		return ingredientListTbAmt;
	}
	public void setIngredientListTbAmt(String ingredientListTbAmt) {
		this.ingredientListTbAmt = ingredientListTbAmt;
	}
	
}
