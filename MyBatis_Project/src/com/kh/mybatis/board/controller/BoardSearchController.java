package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;
import com.kh.mybatis.common.template.Pagination;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 전달값 뽑기
		String condition=request.getParameter("condition");	
		//동적 쿼리를 이용한 경우:  "writer"/"title"/"content"
		//정적바인딩을 이용한 경우: "USER_ID"/"BOARD_TITLE"/"BOARD_CONTENT"
		
		String keyword=request.getParameter("keyword");		// 사용자가 입력한 키워드값(String 형태)
		
		//넘겨야할 값이 여러개일 경우
		//마땅히 가공할 VO객체가 없을 때 HashMap으로 가공하면 된다.
		//VO로 가공했을 경우 => 필드명-필드값
		//HashMap으로 가공했을 경우=> 키값-밸류값
		HashMap<String,String> map=new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		BoardService boardService=new BoardServiceImpl();
		
		//페이징 처리를 위한 pi 객체 만들기
		//=>Pagination 클래스에 getPageInfo(listCount, currentPage, pageLimit, boardLimit) 메소드를 호출
		int searchCount=boardService.selectSearchCount(map);	//현재 검색 결과에 맞는 게시글의 총 갯수
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit=10;
		int boardLimit=5;
		
		PageInfo pi=Pagination.getPageInfo(searchCount, currentPage, pageLimit, boardLimit);
		
		//조회 요청
		ArrayList<Board> list=boardService.selectSearchList(pi,map);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		//이슈: 검색이 진행된 후 검색 조건과 검색어가 유지되지 않음
		//		페이징바를 눌러서 이동시 list.bo로 요청이 들어가는 이슈
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
