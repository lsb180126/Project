package poly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.ComDTO;
import poly.dto.MemDTO;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;
import poly.service.IBeautyService;
import poly.service.IEatService;
import poly.service.IHomegoodsService;
import poly.service.IMemService;
import poly.service.ISellService;
import poly.service.ITalkService;
import poly.service.IUserService;


import poly.service.impl.UserService;

import poly.util.CmmUtil;
import poly.util.MailUtil;


@Controller
public class UserController {
	private Logger log = Logger.getLogger(this.getClass());
	private static String connectIP = "http://192.168.170.123:8111/"; //자기 ip 쓰기 (이메일 보내기 url)
	
	@Resource(name = "UserService")
	private IUserService userService;
	
	@Resource(name = "TalkService")
	private ITalkService talkService;
	
	@Resource(name = "SellService")
	private ISellService sellService;
	
	@Resource(name = "MemberService")
	private IMemService memberService;
	
	@Resource(name = "HomegoodsService")
	private IHomegoodsService homegoodsService;
	
	@Resource(name = "EatService")
	private IEatService eatService;
	
	@Resource(name = "BeautyService")
	private IBeautyService beautyService;
	
	@RequestMapping(value="rc", method=RequestMethod.POST)
	public String RC(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome rc");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email= request.getParameter("email");
		String gender= request.getParameter("gender");
		
		log.info("id : " + id);
		log.info("password : " + password);
		log.info("name : " + name);
		log.info("email : " + email);
		log.info("gender : " + gender);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setUserId(id);
		uDTO.setPassword(password);
		uDTO.setUserName(name);
		uDTO.setEmail(email);
		uDTO.setGender(gender);
		
		int result = userService.insertMember(uDTO);
		
		UserDTO uDTO2 = userService.getUserInfo(uDTO);
		String userNo = uDTO2.getUserSeqNo();
		log.info(userNo);
		
		String url =connectIP+"emailConfirm.do";
		String parameter ="?userNo="+userNo;
		String body ="<a href='"+url+parameter+"'>인증 하기</a>";
		MailUtil.sendMail(email, "pet clinic 인증메일입니다.", body);
		
		
		
		model.addAttribute("msg", "회원가입이 완료되었습니다.");
		model.addAttribute("url", "/register.do");
		
		
		return "/redirect2";
	}
	



	@RequestMapping(value="/emailConfirm", method=RequestMethod.GET)
	public String emailConfirm(HttpServletRequest request, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome emailConfirm");
		
		String userNo = request.getParameter("userNo");
		
		log.info(userNo);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setUserSeqNo(userNo);
		
		
		int uDTO2 = userService.EmailConfirm(uDTO);
		log.info(uDTO2);
		
		
		
		String msg;
		String url;
		if(uDTO == null) {
			model.addAttribute("msg", "이메일 인증되지않았습니다.");
			model.addAttribute("url", "/index.do");
			
		}else{
			model.addAttribute("msg", "이메일 인증되었습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		
		return "/redirect2";
		
	}


	
	@RequestMapping(value="/ajaxTest", method=RequestMethod.POST)
	public @ResponseBody int ajaxTest(
			@RequestParam(value="id")String id
			) throws Exception {
		
		log.info("welcome ajaxTest");
		log.info("id :" + id);
		
		
		int count = userService.checkDuplication(id);
		
		log.info(count);
		
		return count;
		
	}
	
	
	@RequestMapping(value="loginProc", method=RequestMethod.POST)
	public String loginProc(HttpServletRequest request, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome loginProc");
		
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		log.info("id : " + id);
		log.info("password : " + password);
		
		
		UserDTO uDTO = new UserDTO();
		
		
		uDTO.setUserId(id);
		uDTO.setPassword(password);
		
		
		uDTO=userService.getLoginInfo(uDTO);
		
		
		
		if(uDTO == null) {
			model.addAttribute("msg", "로그인이 실패하였습니다.");
			model.addAttribute("msg", "이메일 인증을 해주세요");
			
		} else {
			session.setAttribute("id", uDTO.getUserId());
			session.setAttribute("name", uDTO.getUserName());
			session.setAttribute("gender", uDTO.getGender());
			session.setAttribute("userSeqNo", uDTO.getUserSeqNo());
			model.addAttribute("msg", "로그인 되었습니다.");
		}
		
		model.addAttribute("url", "/index.do");
		
		return "/redirect2" ;
		
		}
		
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome logout");
		
		session.invalidate();
		
		model.addAttribute("msg", "로그아웃 되었습니다.");
		model.addAttribute("url", "/index.do");
		
		
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="/userlist")
	public String userlist(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome userlist");
		
		log.info(this.getClass().getName() + ".userlist start!");
		String keyword = CmmUtil.nvl((String)request.getParameter("keyword"),"");
		
		log.info(keyword);
		log.info("TEST"+keyword +"TEST");
		
		int totalCount = userService.getUserListTotalCount(keyword);
		int pageNum = 1;
		int pageCount = 10;
		
		pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
		pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));
		System.out.println(totalCount +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		// 페이징 Dto 생성
		PagingDTO paging = new PagingDTO();
		paging.setPage_num(pageNum);
		paging.setPage_count(pageCount);
		paging.setTotal_count(totalCount);
		paging.setKeyword(keyword);
		
		
		
		List<UserDTO> uList = userService.getUserList(paging);
		
		for(UserDTO u : uList) {
			log.info("userId : " +u.getUserId());
			log.info("userName : " +u.getUserName());
			log.info("gender : " +u.getGender());
			log.info("email : " +u.getEmail());
		}
		
		//조회된 리스트 결과값 넣어주기
		model.addAttribute("uList", uList);
		
		// 페이징 정보 전달.
		model.addAttribute("paging", paging);
		
		//변수 초기화(메모리 효율화 시키기 위해 사용함)
		uList = null;
		
		//로그 찍기(추후 찍은 로그를 통해 이 함수 호출이 끝났는지 파악하기 용이하다.)
		log.info(this.getClass().getName() + ".userlist end!");
		
		
		
		
		return "/userlist";
		
	}
	
	@RequestMapping(value="userdetail")
	public String userdetail(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome userdetail");
		
		String id = (String)session.getAttribute("id");
		
		UserDTO uDTO = new UserDTO();
		
		String userSeqNo = request.getParameter("userSeqNo");
		String keyword = CmmUtil.nvl( request.getParameter("keyword"),"");
		
		log.info(userSeqNo);
		log.info(keyword);
		
		int totalCount = userService.getUserListTotalCount(keyword);
		int pageNum = 1;
		int pageCount = 10;
		
		pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
		pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));
		System.out.println(totalCount +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		uDTO.setUserId(id);
		uDTO.setUserSeqNo(userSeqNo);
		
		uDTO=userService.getUserdetail(uDTO);
		
		log.info(uDTO.getUserId());
		log.info(uDTO.getEmail());
		log.info(uDTO.getGender());
		log.info(uDTO.getUserName());
		
		
		model.addAttribute("uDTO",uDTO);
		
		model.addAttribute("pageCount", pageCount);
		
		model.addAttribute("pageNum", pageNum);
		
		model.addAttribute("keyword", keyword);
		
		return "/userdetail";
		
	}
	
	@RequestMapping(value="userrevise")
	public String userrevise(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome userrevise");
		
		
		String userSeqNo = request.getParameter("userSeqNo");
		
		log.info(userSeqNo);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setUserSeqNo(userSeqNo);
		
		uDTO=userService.getUserdetail(uDTO);
		log.info(uDTO.getUserId());
		log.info(uDTO.getEmail());
		log.info(uDTO.getGender());
		log.info(uDTO.getUserName());
		
		
		
		model.addAttribute("uDTO",uDTO);
		
		return "/userrevise";
		
	}
	
	@RequestMapping(value="userrevise2")
	public String userrevise2(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome userrevise2");
		
		String email = request.getParameter("email");
		String userSeqNo = request.getParameter("userSeqNo");
		
		
		log.info(email);
		log.info(userSeqNo);
		
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setEmail(email);
		uDTO.setUserSeqNo(userSeqNo);
		
		
		int result = userService.userrevise(uDTO);
		log.info(result);
		
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/userlist.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		model.addAttribute("email", email);
		
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="userdelete")
	public String userdelete(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome userdelete");
		
		
		String userSeqNo = request.getParameter("userSeqNo");
		log.info(userSeqNo);
		
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setUserSeqNo(userSeqNo);
		
		int result = userService.userdelete(uDTO);
		
		
		log.info(result);
		


		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "탈퇴되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/userdetail.do?userSeqNo=" +uDTO.getUserSeqNo());
		}
		
		
		
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="mylist")
	public String mylist(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome mylist");
		
		String id = (String)session.getAttribute("id");
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setUserId(id);
		
		uDTO=userService.getmyList(uDTO);
		
		log.info(uDTO.getUserId());
		log.info(uDTO.getEmail());
		log.info(uDTO.getGender());
		log.info(uDTO.getUserName());
		
		
		model.addAttribute("uDTO",uDTO);
		
		return "/mylist";
		
	}
	
	@RequestMapping(value="mylistrevise")
	public String mylistrevise(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome mylistrevise");
		
		String email = request.getParameter("email");
		log.info(email);
		
	
		model.addAttribute("email", email);
		
		return "/mylistrevise";
		
	}
	
	@RequestMapping(value="mylistrevise2")
	public String mylistrevise2(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome mylistrevise2");
		
		String email = request.getParameter("email");
		String userId = (String)session.getAttribute("id");
		log.info(email);
		log.info(userId);
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setEmail(email);
		uDTO.setUserId(userId);
		
		int result = userService.mylistrevise(uDTO);
		log.info(result);


		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/mylist.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		model.addAttribute("email", email);
		
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="mylistdelete")
	public String mylistdelete(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome mylistdelete");
		
		
		String userId = (String)session.getAttribute("id");
		log.info(userId);
		
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setUserId(userId);
		
		int result = userService.mylistdelete(uDTO);
		int result2 = talkService.mylistdelete(userId);
		int result3 = sellService.mylistdelete(userId);
		int result4 = memberService.mylistdelete(userId);
		int result5 = homegoodsService.mylistdelete(userId);
		int result6 = eatService.mylistdelete(userId);
		int result7 = beautyService.mylistdelete(userId);
		
		log.info(result);
		log.info(result2);
		log.info(result3);
		log.info(result4);
		log.info(result5);
		log.info(result6);
		log.info(result7);


		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "탈퇴되었습니다.");
			model.addAttribute("url", "/index.do");
			session.invalidate();
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/mylist.do?userId=" +uDTO.getUserId());
		}
		
		
		
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="idfind")
	public String idfind(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome idfind");
		
				
		return "/idfind";
		
	}
	
	
	
	@RequestMapping(value="idfind2", method=RequestMethod.POST)
	public String Idfind2(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome idfind2");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		
		log.info("name : " + name);
		log.info("email : " + email);
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setUserName(name);
		uDTO.setEmail(email);
		
		uDTO=userService.getIdfind(uDTO);
		
		
		String msg;
		String url;
		if(uDTO == null) {
			model.addAttribute("msg", "올바른 정보를 입력해 주세요.");
			model.addAttribute("url", "/idfind.do");
			
			return "/alert";
		} 
			
		
		model.addAttribute("uDTO",uDTO);
		
		return "/idfindview";
	}
	
	@RequestMapping(value="pwfind2", method=RequestMethod.POST)
	public String pwfind2(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome pwfind2");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		log.info("name : " + name);
		log.info("id : " + id);
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setUserName(name);
		uDTO.setUserId(id);
		
		uDTO=userService.getPWfind(uDTO);
		
		
		
		String msg;
		String url;
		if(uDTO == null) {
			model.addAttribute("msg", "올바른 정보를 입력해 주세요.");
			model.addAttribute("url", "/pwfind.do");
			
			return "/alert";
		} 
			
		
		model.addAttribute("uDTO",uDTO);
		
		return "/pwfindview";
	}
	
	@RequestMapping(value="pwfind")
	public String PWfind(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome pwfind");
		
		
		 
		return "/pwfind";
	}
	
	@RequestMapping(value="pwrevise")
	public String pwrevise(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome pwrevise");
		
		String pwid = request.getParameter("userId");
		log.info("406" +pwid);
		
		model.addAttribute("pwid",pwid);
		
		return "/pwrevise";
	}
	
	@RequestMapping(value="pwrevise2")
	public String pwrevise2(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome pwrevise2");
		
		String password = request.getParameter("password");
		String userId = request.getParameter("userId");
		
		log.info(password);
		log.info(userId);
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setPassword(password);
		uDTO.setUserId(userId);
		
		int result = userService.pwrevise(uDTO);
		log.info(result);

		
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "변경되었습니다.");
			model.addAttribute("url", "/login.do");
		} else {
			model.addAttribute("msg", "올바르지 않습니다.");
			model.addAttribute("url", "/pwrevise.do");
		}
		
		model.addAttribute("password", password);
		
		
		
		return "/alert";
		
	}
	
	
}