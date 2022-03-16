package com.bitc.java404.service;

import com.bitc.java404.dto.MemberDto;

public interface CatShopMemberService {

	int selectIsIdPwMember(String id, String pw) throws Exception;
	
	int selectIsUseMember(String userId) throws Exception;

	MemberDto selectMember(String id, String pw) throws Exception;
	
	void joinMember(MemberDto member) throws Exception;

	

}
