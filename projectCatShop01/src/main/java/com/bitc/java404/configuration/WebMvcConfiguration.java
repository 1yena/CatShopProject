package com.bitc.java404.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

//	@Bean
//	public CommonsMultipartResolver multipartResolver() {
////		apache의 Commons-io 및 Commons-fileupload를 사용하기 때문에 CommonsMultipartResolver를 통해서 MultipartResolver를 구현하고 스프링 프레임워크에 등록
//		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//		commonsMultipartResolver.setDefaultEncoding("UTF-8");
////		최대 업로드 가능 파일크기 설정
////		기본 단위가 byte임, 5 * 1024 * 1024 = 5MB
//		commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024);
//		
//		return commonsMultipartResolver;
//	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("file:///C:/images/");
	}
	
	/*
	 * 문제 1) 스프링부트에서 외부 폴더의 이미지를 사용할 수 있도록 설정하세요 ps) c:\image, c:\web\images
	 * 
	 * 문제 2) 상세 보기 클릭 시 첨부 이미지 파일이 있을 경우 이미지 파일을 보기 좋게 출력할 수 있도록 UI를 수정하세요 ps) 이미지가
	 * 일정 크기 이상 되지 않도록 설정 ps) card나 grid system(옵션: 한 라인에 최대 5개까지 출력) 사용
	 *** 
	 * 가능한 경우에만 풀기 *** 문제3) 출력된 이미지를 클릭하면 모달창이 열리면서 지정한 이미지를 화면에 출력시키세요
	 * 
	 * 내일 xml 파일 파싱, ajax 통신, restful 방식
	 */
}









