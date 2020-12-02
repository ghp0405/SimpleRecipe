package com.simplerecipe.common.paging;

public class Criteria {
	
	// sql 작성에 필요한 변수들
	private int page; // 현재 페이지 번호(레시피 번호가 아님)
	private int perPageNum; // 한 페이지에 들어갈 레시피 갯수
	// 한 페이지에 들어있는 레시피 번호의 범위 : startNum ~ endNum
	private int startNum; 
	private int endNum;
	
	// 초기값 설정
	public Criteria() {
		this.page = 1;
		this.perPageNum = 20;
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page < 1) { // 1미만의 숫자가 페이지 번호가 되지 못하도록 방지
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum < 1) {
			this.perPageNum = 20;
			return;
		}
		this.perPageNum = perPageNum;
	}

	public int getStartNum() {
		// 한 페이지에 들어있는 레시피들의 첫 번째 번호 = (현재 페이지 - 1) * 한 페이지에 있는 레시피 갯수 + 1
		startNum = (page - 1) * perPageNum + 1;
		return startNum;
	}

	public int getEndNum() {
		// 한 페이지에 들어있는 레시피들의 끝 번호 = 첫 번째 레시피 번호 + 한 페이지에 있는 레시피 갯수 - 1
		endNum = startNum + perPageNum - 1;
		return endNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", startNum=" + startNum + ", endNum=" + endNum
				+ "]";
	}
	
}
