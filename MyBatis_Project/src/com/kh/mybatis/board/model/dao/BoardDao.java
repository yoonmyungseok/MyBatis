package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
		//마이바티스에서는 페이징 처리를 위해 RowBounds 라는 객체를 제공한다.
		
		//RowBounds 객체 생성 시 2개의 매개변수가 필요함
		
		/*
		 * offset: 몇 개의 게시글을 건너 뛰고 조회할건지에 대한 값
		 * limit: 한번에 몇개의 게시글을 보여줄건지에 대한 값
		 * 
		 * ex)boardLimit가 5인 경우
		 * 							offset		limit
		 * currentPage: 1=>1~5		0			5
		 * currentPage: 2=>6~10		5			5
		 * currentPage: 3=>11~15	10			5
		 */
		
		int limit=pi.getBoardLimit();
		int offset=(pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
		//selectList: 여러행 조회용 메소드
		//selectList 메소드 호출 시 RowBounds 객체를 같이 넘겨야 할 경우
		//selectList 메소드의 오버로딩 된 형태 중 매개변수가 3개인 메소드를 호출해야만 하기 때문에
		//만약 메꿔야할 값이 없다면 두번째 매개변수에는 null 값을 넘겨준다
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount",boardNo);
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo){
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList",boardNo);
	}
}
