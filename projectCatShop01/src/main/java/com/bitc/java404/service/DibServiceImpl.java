package com.bitc.java404.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.java404.dto.DibDto;
import com.bitc.java404.mapper.DibMapper;


@Service
public class DibServiceImpl implements DibService {
	
	@Autowired
	private DibMapper dibMapper;

	// 찜하기 추가
	@Override
	public void addDib(DibDto dib) throws Exception {
		dibMapper.addDib(dib);
	}

	// 찜 목록
	@Override
	public List<DibDto> dibList(String userId) throws Exception {
		List<DibDto> dib = dibMapper.getDib(userId); 
		return dib;
	}

	// 찜 삭제
	@Override
	public void deleteDib(int seq) throws Exception {
		dibMapper.deleteDib(seq);
	}
	
	

	
}
