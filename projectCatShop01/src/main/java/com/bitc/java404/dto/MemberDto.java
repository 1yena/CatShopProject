package com.bitc.java404.dto;

import lombok.Data;

@Data
public class MemberDto {
	
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userBirth;
	private String userAddr1;
	private String userAddr2;
	private String deletedYn;

}
