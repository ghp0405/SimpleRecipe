package com.simplerecipe.main.vo;

public class IngredientListVO {
	private int recipeTbNo;
	private int ingredientTbNo;
	
	@Override
	public String toString() {
		return "IngredientListVO [recipeTbNo=" + recipeTbNo + ", ingredientTbNo=" + ingredientTbNo + "]";
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
}
