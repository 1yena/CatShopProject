package com.bitc.java404.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.java404.dto.MemberDto;

@Mapper
public interface CatShopMemberMapper {

	int selectIsUseMember(String userId) throws Exception;

	
	// @Param : mapper는 데이터 하나만 받을 땐 문제 없지만 두 개 이상의 데이터는 인식을 잘 못 해서 @Param을 붙여줘야 함 !
	int selectIsIdPwMember(@Param("userId") String id, @Param("userPw") String pw) throws Exception;

	void joinMember(MemberDto member) throws Exception;

	// @Param : mapper는 데이터 하나만 받을 땐 문제 없지만 두 개 이상의 데이터는 인식을 잘 못 해서 @Param을 붙여줘야 함 !
	MemberDto selectMember(@Param("userId") String id, @Param("userPw") String pw) throws Exception;

	MemberDto userDetailList(String userId) throws Exception;
	
	// 회원 정보 수정
	void userUpdateBoard(MemberDto userupdate) throws Exception;
	
	// 회원 정보 삭제
	void deleteUser(String userId) throws Exception;
	

	
	

}
