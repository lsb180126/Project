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
import poly.dto.UserDTO;

import poly.service.IUserService;


import poly.service.impl.UserService;

import poly.util.CmmUtil;


@Controller
public class UserController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "UserService")
	private IUserService userService;
	
	
	
	@RequestMapping(value="rc")
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
		
		model.addAttribute("msg", "회원가입이 완료되었습니다.");
		model.addAttribute("url", "/register.do");
		

		return "/redirect";
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
			
		} else {
			session.setAttribute("id", uDTO.getUserId());
			session.setAttribute("name", uDTO.getUserName());
			session.setAttribute("gender", uDTO.getGender());
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
		log.info(result);


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
	public String IDfind2(HttpServletRequest request, HttpServletResponse response, 
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
		
		
		String url;
		String msg;
		if(uDTO.getUserName() == name && uDTO.getEmail() == email) {
			/*model.addAttribute("msg", "로그인 되었습니다.");*/
			model.addAttribute("url", "/idfindview.do");
			
		} else {
			model.addAttribute("msg", "올바른 정보를 입력해 주세요.");
			model.addAttribute("url", "/idfind.do");
		}
		
		
		
		return "/alert";
	}
	
	@RequestMapping(value="pwfind", method=RequestMethod.GET)
	public String PWfind(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome pwfind");
		
		 
		return "/pwfind";
	}
	
	@RequestMapping(value="idfindview", method=RequestMethod.POST)
	public String idfindview(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome idfindview");
		
		String id = (String)session.getAttribute("id");
		String name = request.getParameter("name");
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setUserId(id);
		uDTO.setUserName(name);
		
		uDTO=userService.getmylist2(uDTO);
		
		log.info(uDTO.getUserId());
		log.info(uDTO.getUserName());
		
		
		model.addAttribute("uDTO",uDTO); 
		
		
		return "/idfindview";
	}
	
}	
	
	
	
		
