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
		
		userService.insertMember(uDTO);
		
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
	
	@RequestMapping(value="mylist", method=RequestMethod.GET)
	public String mylist(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome mylist");
		
		String id = (String)session.getAttribute("id");
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setUserId(id);
		
		uDTO=userService.getmyList(uDTO);
		
		model.addAttribute("uDTO",uDTO);
		
		return "/mylist";
		
	}
	
	
}	
	
	
	
		
