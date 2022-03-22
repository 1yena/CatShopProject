package com.bitc.java404.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.java404.dto.ProductDto;
import com.bitc.java404.mapper.CatShopProductMapper;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	CatShopProductMapper catmapper;

	//메인 추천, 신상품 조회////////////////////////////////
	@Override
	public List<ProductDto> selectHotList() throws Exception {
		return catmapper.selectHotList();
	}
	@Override
	public List<ProductDto> selectNewList() throws Exception {
		return catmapper.selectNewList();
	}
	
	//상품 등록////////////////////////////////////////////
	@Override
	public void proinsert(ProductDto product) throws Exception {
		catmapper.proinsert(product);
	}
	
	//상품 상세 조회////////////////////////////////////////////
	@Override
	public ProductDto productDetailList(int productSeq) throws Exception {
		return catmapper.productDetailList(productSeq);
	}
	//상품 수정////////////////////////////////////////////
	@Override
	public void catUpdateBoard(ProductDto catupdate) throws Exception {
		catmapper.catUpdateBoard(catupdate);
		
	}
	//상품 삭제////////////////////////////////////////////
	@Override
	public void deleteProduct(int productSeq) throws Exception {
		catmapper.deleteProduct(productSeq);
	}
	
	
	//사료 조회////////////////////////////////////////////
	@Override
	public List<ProductDto> selectAllList() throws Exception {
		return catmapper.selectAllList();
	}
	@Override
	public List<ProductDto> selectKittenList() throws Exception {
		return catmapper.selectKittenList();
	}
	@Override
	public List<ProductDto> selectAdultList() throws Exception {
		return catmapper.selectAdultList();
	}
	
	//간식 조회////////////////////////////////////////////
	@Override
	public List<ProductDto> selectStapletList() throws Exception {
		return catmapper.selectStapletList();
	}
	@Override
	public List<ProductDto> selectChurList() throws Exception {
		return catmapper.selectChurList();
	}
	@Override
	public List<ProductDto> selectDryList() throws Exception {
		return catmapper.selectDryList();
	}
	
	//모래 조회////////////////////////////////////////////
	@Override
	public List<ProductDto> selectClotbentoList() throws Exception {
		return catmapper.selectClotbentoList();
	}
	@Override
	public List<ProductDto> selectClotnatureList() throws Exception {
		return catmapper.selectClotnatureList();
	}
	@Override
	public List<ProductDto> selectAbsorbnatureList() throws Exception {
		return catmapper.selectAbsorbnatureList();
	}
	
	//장난감 조회////////////////////////////////////////////
	@Override
	public List<ProductDto> selectFishingList() throws Exception {
		return catmapper.selectFishingList();
	}
	@Override
	public List<ProductDto> selectDollList() throws Exception {
		return catmapper.selectDollList();
	}
	@Override
	public List<ProductDto> selectHouseList() throws Exception {
		return catmapper.selectHouseList();
	}
	
	//캣타워 조회////////////////////////////////////////////
	@Override
	public List<ProductDto> selectSmallList() throws Exception {
		return catmapper.selectSmallList();
	}
	@Override
	public List<ProductDto> selectMiddleList() throws Exception {
		return catmapper.selectMiddleList();
	}
	@Override
	public List<ProductDto> selectLargeList() throws Exception {
		return catmapper.selectLargeList();
	}
	
	
	
	
	
	

}
