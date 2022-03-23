package com.bitc.java404.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.java404.dto.DibDto;


@Mapper
public interface DibMapper {

	// 찜 추가
	void addDib(DibDto dib) throws Exception;

	// 찜 목록
	List<DibDto> getDib(String userId) throws Exception;

	// 찜 삭제
	void deleteDib(int seq) throws Exception;

	
}
