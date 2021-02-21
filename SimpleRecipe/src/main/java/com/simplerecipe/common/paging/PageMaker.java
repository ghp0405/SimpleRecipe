package com.simplerecipe.common.paging;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	// 목록 페이지 하단의 << 1 ~ displayPageNum(10번까지) >> 페이지 클릭 부분
	private int displayPageNum = 10; 
	private Criteria cri;
	
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	// 페이징 처리에 필요한 데이터를 가공해주는 함수
	private void calcData() {
		// 마지막 페이지 번호 : (정수변환)(현재 페이지 / 하단의 페이지 갯수) + 하단의 페이지 갯수
		endPage = (int)(Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true; // 1보다 작은 페이지 번호는 존재하지 않는다.
		// 만약 전체 페이지 번호 중에서 맨 마지막 번호를 열람할 경우, 해당 번호보다 더 큰 번호는 없으므로
		// next가 false가 된다.
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
		
		this.cri.getStartNum();
		this.cri.getEndNum();
		
	}
	
	public String makeQuery(int page) {
		// 구글검색시 UriComponentsBuilder 사용법을 검색할 것!
		// -> 동적으로 페이지에 필요한 URI를 만드는 로직이다.
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance().queryParam("page", page
						).queryParam("perPageNum", cri.getPerPageNum()).build();
		return uriComponents.toUriString();
	}
	
}
