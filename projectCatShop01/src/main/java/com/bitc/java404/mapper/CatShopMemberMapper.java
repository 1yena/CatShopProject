package com.bitc.java404.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.java404.dto.MemberDto;

@Mapper
public interface CatShopMemberMapper {

	int selectIsUseMember(String userId) throws Exception;

	int selectIsIdPwMember(@Param("userId") String id, @Param("userPw") String pw) throws Exception;

	void joinMember(MemberDto member) throws Exception;

	MemberDto selectMember(@Param("userId") String id, @Param("userPw") String pw) throws Exception;
	
	

}
