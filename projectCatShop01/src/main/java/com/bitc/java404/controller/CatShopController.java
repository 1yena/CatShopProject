package com.bitc.java404.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.java404.dto.ProductDto;
import com.bitc.java404.service.ProductService;


@Controller
public class CatShopController {
	
	//////////////////////////////메인//////////////////////////////////////////////////////////
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/catshop")
	public ModelAndView catshop() throws Exception {
		ModelAndView mv = new ModelAndView("/main/main");
		
		//서비스를 이용해서 mapper를 통해 데이터 가져오기
		
		// mv에 addObject()
		
		List<ProductDto> hotList = productService.selectHotList();
		List<ProductDto> newList = productService.selectNewList();
		
		mv.addObject("hotList", hotList);
		mv.addObject("newList", newList);
		
		return mv;
	}
	//////////////////////////////상품 디테일 페이지//////////////////////////////////////////////////////////
	@RequestMapping(value="/catshop/productDetail/{productSeq}", method=RequestMethod.GET)
	public ModelAndView productDetail(@PathVariable("productSeq") int productSeq) throws Exception {
		ModelAndView mv = new ModelAndView("/product/detail");
		
		ProductDto productDetail = productService.productDetailList(productSeq);
		mv.addObject("productDetail", productDetail);
		
		return mv;
	}
	
	
	///////////////****************상품 수정 페이지*****************///////////////////
	@RequestMapping(value="/catshop/catupdate/{productSeq}")
		public ModelAndView catupdate(@PathVariable("productSeq") int productSeq) throws Exception {
		ModelAndView mv = new ModelAndView("/product/catupdate");
		
		ProductDto catup = productService.productDetailList(productSeq);
		mv.addObject("catup", catup);
		
		return mv;
	}
	
	@RequestMapping(value="/cat/catupdate/{productSeq}", method=RequestMethod.PUT)
		public String catUpdateBoard(ProductDto catupdate) throws Exception{
		productService.catUpdateBoard(catupdate);
		
		return "redirect:/catshop/menu";
	}
	
	
	//////////////////////*****************메뉴*******************/////////////////////////
	@RequestMapping(value="/catshop/menu")
	public String catshopMenu() throws Exception {
		return "/main/menu";
	}
	
	@RequestMapping(value="/catshop/fodder")
	public String catshopfodder() throws Exception {
		
		return "/main/menu-fodder";
	}
	
	@RequestMapping(value="/catshop/snack")
	public String catshopsnack() throws Exception {
		
		return "/main/menu-snack";
	}
	
	@RequestMapping(value="/catshop/sand")
	public String catshopsand() throws Exception {
		
		return "/main/menu-sand";
	}
	
	@RequestMapping(value="/catshop/toy")
	public String catshoptoy() throws Exception {
		
		return "/main/menu-toy";
	}
	
	@RequestMapping(value="/catshop/towel")
	public String catshoptowel() throws Exception {
		
		return "/main/menu-towel";
	}
	
	/////////////////////////////상품/////////////////////////////////////////////
	//상품등록 페이지
	@RequestMapping(value="/catshop/proinsert")
	public String proinsert() throws Exception {
	
	return "/product/insertpro";
	}
	
	//상품 정보 입력
	@RequestMapping(value="/catshop/proRegister")
	public String proregister(ProductDto product) throws Exception {
		productService.proinsert(product);
	
		return "redirect:/catshop/menu";
	}
	
	
	
	
	
	
	////////////////////*************************************************************///////////////////////////////////////////////////////////////
	
	/////////////////////////////사료/////////////////////////////////////////////
	  //전연령층	  
	  @RequestMapping(value="/catshop/foodallages") 
	  public ModelAndView foodallages() throws Exception { 
		  
		  ModelAndView mv = new ModelAndView("/catfodder/allages");
	  
		  List<ProductDto> allList = productService.selectAllList();
	  
		  mv.addObject("allList", allList);
	  
		  return mv;
	  } 
	  
	  //자묘용
	  @RequestMapping(value="/catshop/foodkitten") 
	  public ModelAndView foodkitten() throws Exception { 
		  
		  ModelAndView mv = new ModelAndView("/catfodder/kitten");
	  
		  List<ProductDto> kittenList = productService.selectKittenList();
	  
		  mv.addObject("kittenList", kittenList);
	  
		  return mv; 
	  } 
	  
	  //성묘용
	  @RequestMapping(value="/catshop/foodadult") 
	  public ModelAndView foodadult() throws Exception { 
		  ModelAndView mv = new ModelAndView("/catfodder/adult");
	  
		  List<ProductDto> adultList = productService.selectAdultList();
	  
		  mv.addObject("adultList", adultList);
	  
		  return mv;
	  }
	  
	  
	/////////////////////////////간식/////////////////////////////////////////////
	//주식파우치
		@RequestMapping(value="/catshop/snackstaple")
		public ModelAndView snackstaple() throws Exception {
			ModelAndView mv = new ModelAndView("/snack/staple");
			
			List<ProductDto> stapleList = productService.selectStapletList();
			
			mv.addObject("stapleList", stapleList);
			
			return mv;
		}
		//간식파우치
		@RequestMapping(value="/catshop/snackchur")
		public ModelAndView snackchur() throws Exception {
			ModelAndView mv = new ModelAndView("/snack/chur");
			
			List<ProductDto> churList = productService.selectChurList();
			
			mv.addObject("churList", churList);
			
			return mv;
		}
		//건조파우치
		@RequestMapping(value="/catshop/snackdry")
		public ModelAndView snackdry() throws Exception {
			ModelAndView mv = new ModelAndView("/snack/dry");
			
			List<ProductDto> dryList = productService.selectDryList();
			
			mv.addObject("dryList", dryList);
			
			return mv;
		}
		
	/////////////////////////////모래/////////////////////////////////////////////
	//응고형벤토
	@RequestMapping(value="/catshop/sandclotbento")
	public ModelAndView sandclotbento() throws Exception {
	ModelAndView mv = new ModelAndView("/sand/clot-bento");
	
		List<ProductDto> clotbentoList = productService.selectClotbentoList();
		
		mv.addObject("clotbentoList", clotbentoList);
		
		return mv;
	}
	//응고형천연
	@RequestMapping(value="/catshop/sandclotnature")
	public ModelAndView sandclotnature() throws Exception {
	ModelAndView mv = new ModelAndView("/sand/clot-nature");
	
		List<ProductDto> clotnatureList = productService.selectClotnatureList();
		
		mv.addObject("clotnatureList", clotnatureList);
		
		return mv;
	}
	//흡수형천연
	@RequestMapping(value="/catshop/sandabsorbnature")
	public ModelAndView sandabsorbnature() throws Exception {
	ModelAndView mv = new ModelAndView("/sand/absorb-nature");
	
		List<ProductDto> absorbnatureList = productService.selectAbsorbnatureList();
		
		mv.addObject("absorbnatureList", absorbnatureList);
		
		return mv;
	}
	
	/////////////////////////////장난감/////////////////////////////////////////////
	//낚시대
	@RequestMapping(value="/catshop/toyfishing")
	public ModelAndView toyfishing() throws Exception {
	ModelAndView mv = new ModelAndView("/toy/fishing");
	
		List<ProductDto> fishingList = productService.selectFishingList();
		
		mv.addObject("fishingList", fishingList);
		
		return mv;
	}
	//인형/쿠션
	@RequestMapping(value="/catshop/toydoll")
	public ModelAndView toydoll() throws Exception {
	ModelAndView mv = new ModelAndView("/toy/doll");
	
		List<ProductDto> dollList = productService.selectDollList();
		
		mv.addObject("dollList", dollList);
		
		return mv;
	}
	//움집
	@RequestMapping(value="/catshop/toyhouse")
	public ModelAndView toyhouse() throws Exception {
	ModelAndView mv = new ModelAndView("/toy/house");
	
		List<ProductDto> houseList = productService.selectHouseList();
		
		mv.addObject("houseList", houseList);
		
		return mv;
	}
	
	/////////////////////////////캣타워/////////////////////////////////////////////
	//소형
	@RequestMapping(value="/catshop/towersmall")
	public ModelAndView towersmall() throws Exception {
	ModelAndView mv = new ModelAndView("/tower/small");
	
		List<ProductDto> smallList = productService.selectSmallList();
		
		mv.addObject("smallList", smallList);
		
		return mv;
	}
	//중형
	@RequestMapping(value="/catshop/towermiddle")
	public ModelAndView towermiddle() throws Exception {
		ModelAndView mv = new ModelAndView("/tower/middle");
		
		List<ProductDto> middleList = productService.selectMiddleList();
		
		mv.addObject("middleList", middleList);
		
		return mv;
	}
	//대형
	@RequestMapping(value="/catshop/towerlarge")
	public ModelAndView towerlarge() throws Exception {
	ModelAndView mv = new ModelAndView("/tower/large");
	
		List<ProductDto> largeList = productService.selectLargeList();
		
		mv.addObject("largeList", largeList);
		
		return mv;
	}


		
	
}
