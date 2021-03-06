package com.bitc.java404.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.java404.dto.MemberDto;
import com.bitc.java404.mapper.CatShopMemberMapper;

@Service
public class CatShopMemberServiceImpl implements CatShopMemberService {
	
	@Autowired
	CatShopMemberMapper catmapper;

	@Override
	public int selectIsIdPwMember(String id, String pw) throws Exception {
		
		return catmapper.selectIsIdPwMember(id, pw);
	}
	
	@Override
	public int selectIsUseMember(String userId) throws Exception {
		
		return catmapper.selectIsUseMember(userId);
	}
	
	// 회원 정보 수정
	@Override
	public void userUpdateBoard(MemberDto userupdate) throws Exception {
		catmapper.userUpdateBoard(userupdate);
	}
	
	// 회원 정보 삭제
	@Override
	public void deleteUser(String userId) throws Exception {
		catmapper.deleteUser(userId);
		
	}
	
	

	@Override
	public MemberDto selectMember(String id, String pw) throws Exception {
	
		return catmapper.selectMember(id, pw);
	}

	@Override
	public void joinMember(MemberDto member) throws Exception {
		catmapper.joinMember(member);
	}

	@Override
	public MemberDto userDetailList(String userId) throws Exception {
		return catmapper.userDetailList(userId);
	}

	

	
	

}
