package com.bitc.java404.dto;

import lombok.Data;

@Data
public class ProductDto {
	
	private int productSeq;         //번호
	private String productBrand;    //브랜드
	private String productName;     //상품명
	private String productPrice;    //가격
	private String productSale;     //할인가
	private String productOrigin;   //원산지
	private String productDate;     //유통기한
	private String productDeliver;  //배송비
	private String productCate;     //소분류
	private String productState;    //대분류(신상품, 추천, 기본상품)
	private String productImg;	    //상품 이미지
	

}
