package com.bitc.java404.service;

import com.bitc.java404.dto.MemberDto;

public interface CatShopMemberService {

	int selectIsIdPwMember(String id, String pw) throws Exception;
	
	int selectIsUseMember(String userId) throws Exception;
	
	// 회원 정보 수정
	void userUpdateBoard(MemberDto userupdate) throws Exception;
	
	
	// 회원 조회
	MemberDto selectMember(String id, String pw) throws Exception;
	
	// 회원가입
	void joinMember(MemberDto member) throws Exception;

	// 회원 정보 상세 조회
	MemberDto userDetailList(String userId) throws Exception;

	

	

	

	

}
