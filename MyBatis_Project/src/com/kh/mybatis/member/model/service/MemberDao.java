package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession, Member m) {
		/*
		 * 기존 JDBC
		 * 
		 * int result=0;
		 * PreparedStatement pstmt=null;
		 * String sql=prop.getProperty("insertMember");
		 * 
		 * try{
		 * 	pstmt=conn.prepareStatement(sql);
		 * 	pstmt.setString(1, m.getUserId());
		 * 	
		 * 	result=pstmt.executUpdate();
		 * } catch(){
		 * 	
		 * }finally{
		 * 	close(pstmt);
		 * }
		 * return result;
		 */
		
		/*
		 * sqlSession 객체에서 제공하는 메소드를 통해서 sql 문을 찾아서 실행하고
		 * 결과도 바로 받아볼 수 있다
		 * 
		 * [표현법]
		 * sqlSession.sql문종류에맞는메소드("매퍼파일의식별자.해당쿼리문의식별자",sql문을완성시킬값);
		 * 
		 * =>만약에 쿼리문이 완성된 상태라면 sql문을 완성시킬값은 생략 가능
		 * 
		 * INSERT=>insert 메소드
		 * SELECT=>selectOne(단일행조회), selectList(여러행조회) 메소드
		 */
		return sqlSession.insert("memberMapper.insertMember", m);
	}

	public Member loginMember(SqlSession sqlSession, Member m) {
		//selectOne 메소드: 해당 쿼리문 실행 후 어떤 타입으로 결과를 내보낼껀지 설정값에 따른 형태로 리턴
		//					만약 조회 결과가 없다면 null반환
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}

}
