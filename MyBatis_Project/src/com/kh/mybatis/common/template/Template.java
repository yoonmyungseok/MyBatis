package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	/*
	 * 기존 JDBC
	 * public static Connection getConneciton(){
	 * }
	 * 
	 * public static void close(JDBC용 객체){
	 * }
	 * 
	 * public static void commit/rollback(Connection객체){
	 * }
	 * 
	 * 
	 */
	//마이바티스
	public static SqlSession getSqlSession() {
		//SqlSession: DB 연결에서 부터, 쿼리문 실행, 트랜잭션 처리까지 다 해주는 mybatis용 객체
		
		//mybatis-config.xml 파일을 읽어들여서
		//해당 DB와 접속된 SqlSession 객체를 생성해서 반환
		SqlSession sqlSession=null;
		
		
		
		String resource="/mybatis-config.xml";
		
		try {
			InputStream stream=Resources.getResourceAsStream(resource);
			//자원으로부터 통로를 얻어내겠다
			
			//SqlSession 객체를 만들기 위해서는 SqlSessionFactory 객체가 필요
			//SqlSessionFactory 객체를 만들기 위해서는 SqlSessionFactoryBuilder 객체가 필요
			sqlSession=new SqlSessionFactoryBuilder().build(stream).openSession(false);
			//openSession 메소드 호출시 true/false 값을 넣을 수 있음
			//=>true 설정 시에는 자동 commit
			//=>false 설정 시에는 수동 commit(기본값)
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
		
	}
}
