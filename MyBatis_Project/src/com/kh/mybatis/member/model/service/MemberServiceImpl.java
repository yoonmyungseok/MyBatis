package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService{
	
	//MemberDao에 공통적으로 수행할 코드가 딱히 없으므로
	//매번 객체를 생성할 필요가없음=>MemberDao 객체를 전역변수로 빼줄것
	private MemberDao memberDao=new MemberDao();

	@Override
	public int insertMember(Member m) {
		/*
		 * 기존 JDBC
		 * Connection conn=JDBCTemplate.getConnection();
		 * int result=new MemberDao().insertMember(conn,m);
		 * 
		 * if(result>0){
		 * 	JDBCTemplate.commit();
		 * }else{
		 * 	JDBCTemplate.rollback();
		 * }
		 * 
		 * JDBCTemplate.close(conn);
		 * return result;
		 */
		SqlSession sqlSession=Template.getSqlSession();
		//Template 클래스에서 SqlSession 객체를만들 때
		//mybatis-config.xml 파일을 읽으면서 만들어줌
		//=>설정파일 자체에서 오류가 발생하면 실행이 안됨
		
		int result=memberDao.insertMember(sqlSession,m);
		if(result>0) {
			sqlSession.commit();
		}
		//이 시점에서 result가 0보다 작거나 같다면: insert된 행의 갯수가 0이라는 뜻
		//=>트랜잭션 1개에 쿼리문 1개만 들어있는 상황==단일 프로세스
		//=>이 경우에만 else블럭(rollback처리)을 생략해도 됨
		//=>단, 한 트랜잭션안에 쿼리문이 여러개 들어있을 경우에는 쿼리문 1개당 롤백처리 해야함
		sqlSession.close();
		
		return result;
	}

	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession=Template.getSqlSession();
		Member loginUser=memberDao.loginMember(sqlSession,m);
		sqlSession.close();
		return loginUser;
	}

	@Override
	public int updateMember(Member m) {
		return 0;
	}

	@Override
	public int deleteMember(Member m) {
		return 0;
	}

}
