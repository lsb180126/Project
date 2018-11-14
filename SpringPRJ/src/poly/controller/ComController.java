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
import poly.dto.TalkDTO;
import poly.dto.UserDTO;
import poly.service.IComService;
import poly.service.IUserService;
import poly.service.IMemService;
import poly.service.ITalkService;
import poly.service.impl.UserService;
import poly.service.impl.MemberService;
import poly.util.CmmUtil;


@Controller
public class ComController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "ComService")
	private IComService comService;
	
	@Resource(name = "UserService")
	private IUserService userService;
	
	@Resource(name = "MemberService")
	private IMemService memberService;
	
	@Resource(name = "TalkService")
	private ITalkService talkService;
	
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
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String Register(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome register");
		
		
		 
		return "/register";
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
	
	
	@RequestMapping(value="review", method=RequestMethod.GET)
	public String Review(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome review");
		
		 
		return "/review";
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
	
	
	
	@RequestMapping(value="reviewregister", method=RequestMethod.GET)
	public String Reviewregister(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome reviewregister");
		
		 
		return "/reviewregister";
	}
	
	@RequestMapping(value="talkregister", method=RequestMethod.GET)
	public String Talkregister(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome talkregister");
		
		 
		return "/talkregister";
	}
	
	
	
	@RequestMapping(value="reviewlist")
	public String Reviewlist(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome reviewlist");
		
		
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String star = request.getParameter("star");
		String content= request.getParameter("content");
		
		
		log.info("name : " + name);
		log.info("title : " + title);
		log.info("star : " + star);
		log.info("content : " + content);
		
		MemDTO mDTO = new MemDTO();
		
		mDTO.setReviewName(name);
		mDTO.setTitle(title);
		mDTO.setReviewStar(star);
		mDTO.setReviewContents(content);
		
		
		int result = memberService.insertMember(mDTO);
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		model.addAttribute("url", "/review.do");
		 
		return "/redirect2";
	}
	
	@RequestMapping(value="talklist")
	public String Talklist(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome talklist");
		
		
		
		
		String title = request.getParameter("title");
		
		String content= request.getParameter("content");
		
		
		
		log.info("title : " + title);
		
		log.info("content : " + content);
		
		TalkDTO tDTO = new TalkDTO();
		
		tDTO.setTitle(title);
		tDTO.setTalkContents(content);
		
		
		int result = talkService.insertMember(tDTO);
		
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		model.addAttribute("url", "/talk.do");
		 
		return "/redirect2";
	}
	
		
}