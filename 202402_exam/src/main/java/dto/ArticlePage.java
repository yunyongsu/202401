package dto;

import java.util.List;

public class ArticlePage {
	
	private int total;	//전체 게시물 수
	private int currentPage;	//현재 페이지
	private List<Board> content;	//게시물 내용
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public ArticlePage(int total, int currentPage, int size, List<Board> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		//total이 0이면 페이지가 없으므로, 모두 0으로 설정
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			//전체 페이지 수 =  전체 게시물 수 / 페이지당 게시물 수
			totalPages = total / size;
			
			//나머지가 있으면 페이지 수 ++
			if(total % size > 0) {
				totalPages++;
			}
			/* 시작 페이지 = 현재 페이지 / 5로 나눈 몫에 5를 곱한 값에 1을 더한 것
			   5의 배수로 그룹을 만들어서 1~5 , 6~10까지가 화면에 표시되게 설정
			   1~5까지는 /5 * 5 + 1을 해도 값은 1이나옴.
			   ex)만약 현재 페이지(currentPage)가 6이라고 가정하면 두번째 그룹 '시작페이지'로 설정돼야함.
			      6/5 = 1 * 5 = 5 + 1 = 6 
			*/
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;
			if (modVal == 0) startPage -= 5;
			
			//끝 페이지 = 시작 페이지 + 4
			endPage = startPage + 4;
			//만약 끝 페이지가 전체페이지를 넘어갈 경우, 전체 페이지와 같게 설정
			if (endPage > totalPages) endPage = totalPages;
		}
	}
	
	public boolean hasNoArticles() {
		return total == 0;
	}
	public boolean hasArticles() {
		return total > 0;
	}
	
	public int getTotal() {
		return total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public List<Board> getContent() {
		return content;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}

}
