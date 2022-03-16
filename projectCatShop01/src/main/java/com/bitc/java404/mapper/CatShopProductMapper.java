package com.bitc.java404.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.java404.dto.ProductDto;

@Mapper
public interface CatShopProductMapper {

	//메인 추천, 신상품 조회////////////////////////////////
	List<ProductDto> selectHotList() throws Exception;
	List<ProductDto> selectNewList() throws Exception;
	
	//상품 등록////////////////////////////////////////////
	void proinsert(ProductDto product) throws Exception;
	
	//상품 상세 조회 페이지////////////////////////////////////////////
	ProductDto productDetailList(int productSeq) throws Exception;
	
	//상품 수정////////////////////////////////////////////
	void catUpdateBoard(ProductDto catupdate) throws Exception;
	
	//사료 조회////////////////////////////////////////////
	List<ProductDto> selectAllList() throws Exception;
	List<ProductDto> selectKittenList() throws Exception;
	List<ProductDto> selectAdultList() throws Exception;
	
	//간식 조회////////////////////////////////////////////
	List<ProductDto> selectStapletList() throws Exception;
	List<ProductDto> selectChurList() throws Exception;
	List<ProductDto> selectDryList() throws Exception;
	
	//모래 조회////////////////////////////////////////////
	List<ProductDto> selectClotbentoList() throws Exception;
	List<ProductDto> selectClotnatureList() throws Exception;
	List<ProductDto> selectAbsorbnatureList() throws Exception;
	
	//장난감 조회////////////////////////////////////////////
	List<ProductDto> selectFishingList() throws Exception;
	List<ProductDto> selectDollList() throws Exception;
	List<ProductDto> selectHouseList() throws Exception;
	
	//캣타워 조회////////////////////////////////////////////
	List<ProductDto> selectSmallList() throws Exception;
	List<ProductDto> selectMiddleList() throws Exception;
	List<ProductDto> selectLargeList() throws Exception;
	
	
	
	

}
