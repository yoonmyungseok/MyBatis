package com.kh.mybatis.common.template;

import com.kh.mybatis.common.model.vo.PageInfo;

public class Pagination {
	public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {

		//위의 변수들을 이용해서 계산해서 구해야 하는 변수들
		int maxPage=(int)(Math.ceil((double)listCount/boardLimit)); //가장 마지막 페이지가 몇번 페이지인지(총 페이지수)
		int startPage=(currentPage-1)/pageLimit*pageLimit+1; //페이지 하단에 보여질 페이징바의 시작수
		int endPage=startPage+pageLimit-1; //페이지 하단에 보여질 페이징바의 끝수			
						
		if(endPage>maxPage) {
			endPage=maxPage;
		}

		PageInfo pi=new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		return pi;
	}
}
