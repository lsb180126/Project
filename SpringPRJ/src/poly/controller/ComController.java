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


import poly.service.IComService;

import poly.util.CmmUtil;


@Controller
public class ComController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "ComService")
	private IComService comService;
	
	
	@RequestMapping(value="index")
	public String Index(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		
		log.info("welcome index");
		
		
		return "/index";
	}
	
	
	@RequestMapping(value="login")
	public String Login(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome login");
		
		 
		return "/login";
	}
	
	@RequestMapping(value="login2")
	public String Login2(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome login2");

		List<ComDTO> rList = comService.getMemberList();
		
		for(ComDTO c : rList) {
			log.info("memberId : " +c.getMemberID());
		}
		
		model.addAttribute("rList", rList);
		

		return "/login2";
	}
	
	@RequestMapping(value="submit", method=RequestMethod.POST)
	public String Submit(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome submit");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String password= request.getParameter("password");
		
		log.info("id : " + id);
		log.info("name : " + name);
		log.info("gender : " + gender);
		log.info("password : " + password);
		
		ComDTO cDTO = new ComDTO();
		cDTO.setId(id);
		cDTO.setMemberName(name);
		cDTO.setGender(gender);
		cDTO.setPassword(password);
		
		comService.insertMember(cDTO);
		
		model.addAttribute("msg", "사용자 등록이 완료되었습니다.");
		model.addAttribute("url", "/login2.do");
		
		return "/redirect";
	}
	
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String Register(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome register");
		
		
		 
		return "/register";
	}
	
	
	
	
	
	
	@RequestMapping(value="talk", method=RequestMethod.GET)
	public String Talk(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome talk");
		
		
		 
		return "/talk";
	}
	
	
	@RequestMapping(value="useful", method=RequestMethod.GET)
	public String Useful(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome useful");
		
		
		 
		return "/useful";
	}
	
	@RequestMapping(value="idfind", method=RequestMethod.GET)
	public String IDfind(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome idfind");
		
		 
		return "/idfind";
	}
	
	@RequestMapping(value="pwfind", method=RequestMethod.GET)
	public String PWfind(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome pwfind");
		
		 
		return "/pwfind";
	}
	
	
	
	
	
	@RequestMapping(value="talkregister", method=RequestMethod.GET)
	public String Talkregister(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome talkregister");
		
		 
		return "/talkregister";
	}
	
	
	
		
}