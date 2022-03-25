package com.bitc.java404.dto;

import lombok.Data;

@Data
public class DibDto {
	
	private int seq;
	private int productSeq;
	private String userId;
	private String productName;
	private String productSale;
	private String productCount;
	private char deletedYn;
	
}
