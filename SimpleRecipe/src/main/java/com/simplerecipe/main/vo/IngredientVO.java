package com.simplerecipe.main.vo;

public class IngredientVO {
	private int ingredientTbNo;
	private String ingredientTbName;
	
	@Override
	public String toString() {
		return "RecipeVO [ingredientTbNo=" + ingredientTbNo + ", ingredientTbName=" + ingredientTbName + "]";
	}
	public int getIngredientTbNo() {
		return ingredientTbNo;
	}
	public void setIngredientTbNo(int ingredientTbNo) {
		this.ingredientTbNo = ingredientTbNo;
	}
	public String getIngredientTbName() {
		return ingredientTbName;
	}
	public void setIngredientTbName(String ingredientTbName) {
		this.ingredientTbName = ingredientTbName;
	}
}
