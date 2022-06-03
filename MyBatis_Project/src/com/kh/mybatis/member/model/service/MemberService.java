package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

//인터페이스: 상수필드(public static final)+ 추상메소드(public abstract)
public interface MemberService {
	//회원가입용 메소드
	/*public abstract*/ int insertMember(Member m);
	
	//로그인용 메소드
	Member loginMember(Member m);
	
	//회원정보수정용 메소드
	int updateMember(Member m);
	
	//회원탈퇴용 메소드
	int deleteMember(Member m);
}
