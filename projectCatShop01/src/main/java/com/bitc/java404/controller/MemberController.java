package com.bitc.java404.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.java404.dto.DibDto;
import com.bitc.java404.dto.MemberDto;
import com.bitc.java404.service.CatShopMemberService;
import com.bitc.java404.service.DibService;

@Controller
public class MemberController {
	
	@Autowired
	private CatShopMemberService catmember;
	
	@Autowired
	private DibService dibService;
	
	@RequestMapping(value="/catshop/login") //로그인(뷰)
	public String login() throws Exception {
		return "/login/login";
	}
	
	
	@RequestMapping(value="/catshop/login/loginChk") //로그인확인(db연결, 세션필요)
	public String loginChk(@RequestParam("userId") String id, @RequestParam("userPw") String pw, HttpServletRequest request) throws Exception {
		
		int user = catmember.selectIsIdPwMember(id, pw);
		
		if(user == 1) {
			MemberDto member = catmember.selectMember(id, pw);
			HttpSession session = request.getSession();
			
			session.setAttribute("userId", member.getUserId());
			session.setAttribute("userName", member.getUserName());
			session.setAttribute("userEmail", member.getUserEmail());
			session.setAttribute("userPhone", member.getUserPhone());
			session.setAttribute("userBirth", member.getUserBirth());
			//session.setMaxInactiveInterval(600); //5분 이내에 안 돌아오면 자동으로 세션 삭제(로그아웃)
			
			return "redirect:/catshop/login/loginOk";
			
		} else {
			
			return "redirect:/catshop/login/loginFail";
			
		}
	}
	
	
	@RequestMapping(value="/catshop/login/loginOk") //로그인 완료(뷰, 세션필요)
	public ModelAndView loginOk(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		String userId = (String)session.getAttribute("userId");
		
		ModelAndView mv = new ModelAndView("/login/loginOk");
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/catshop/login/loginFail") //로그인 실패(뷰)
	public String loginFail() throws Exception {
		return "/login/loginFail";
	}
	
	
	@RequestMapping(value="/catshop/login/logout") //로그아웃(뷰, 세션필요)
	public String loginOut(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		// removeAttribute : 세션 정보를 삭제함
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		session.removeAttribute("userEmail");
		session.removeAttribute("userPhone");
		session.removeAttribute("userBirth");
		
		// invalidate : 모든 세션 정보를 삭제함. 보통 얘만 단독으로 사용하진 않음
		// 남겨야 하는 세션이 있을 경우 사용하면 안 됨. 확인용
		session.invalidate();
		
		return "/login/logOut";
	}
	
	/////////////////////////////////////회원가입////////////////////////////
	@RequestMapping(value="/catshop/join") //회원가입 메인(뷰)
	public String join() throws Exception {
		
		return "/join/joinMain";
	}
	
	
	@RequestMapping(value="/catshop/join/joinChk") //회원가입 완료(db연결)
	public String joinok(MemberDto member) throws Exception {
		catmember.joinMember(member);
		return "redirect:/catshop/join/joinOk";
	}
	
	@RequestMapping(value="/catshop/join/joinOk") //회원가입 완료 페이지
	public String joinok() throws Exception {
		return "/join/joinOk";
	}
	
	
	// ajax 연동
	@ResponseBody
	@RequestMapping(value="/catshop/join/idChk") //아이디 중복체크(db연결)
	public String joinchk(@RequestParam("userId") String userId) throws Exception {
		String result = "error";
		
		// db연동하여 입력한 사용자가 존재하는지 확인
		int user = catmember.selectIsUseMember(userId);
		
		if (user == 0) {
			result = "success";
		}
		
		return result;
	}
	
	///////////////////////////마이페이지////////////////////////////
	@RequestMapping(value="/login/myPage/{userId}", method=RequestMethod.GET)
	public ModelAndView myPage(@PathVariable("userId") String userId, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/login/myPage");
		
		MemberDto userDetail = catmember.userDetailList(userId);
		
		List<DibDto> dibList = dibService.dibList(userId);
		
		mv.addObject("userDetail", userDetail);
		mv.addObject("dibList", dibList);
		
		return mv;
		
	}

	
	///////////////****************회원 정보 수정*****************///////////////////
	@RequestMapping(value="/login/userUPdate/{userId}")
	public ModelAndView userupdate(@PathVariable("userId") String userId) throws Exception {
		ModelAndView mv = new ModelAndView("/login/userupdate");
		
		MemberDto userup = catmember.userDetailList(userId);
		mv.addObject("userup", userup);
		
		return mv;
	}
	
	@RequestMapping(value="/login/userUPdate/{userId}", method=RequestMethod.PUT)
		public String userUpdateBoard(MemberDto userupdate) throws Exception{
		catmember.userUpdateBoard(userupdate);
		
//		return "redirect:/login/myPage/{userId}";
		return "redirect:/login/myPage/" + userupdate.getUserId();
	}
	
	///////////////****************회원 삭제*****************///////////////////
	@RequestMapping(value="/login/deleteUser/{userId}", method=RequestMethod.DELETE)
		public String productDelete(@PathVariable("userId") String userId, HttpServletRequest request) throws Exception{
		catmember.deleteUser(userId);
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		session.removeAttribute("userEmail");
		session.removeAttribute("userPhone");
		session.removeAttribute("userBirth");
		
		session.invalidate();
		
		
		return "redirect:/catshop/menu";
	
	}
	
	

}
