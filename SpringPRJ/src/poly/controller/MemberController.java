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


import poly.dto.MemDTO;


import poly.service.IMemService;

import poly.service.impl.MemberService;
import poly.util.CmmUtil;


@Controller
public class MemberController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name = "MemberService")
	private IMemService memberService;
	
	
	
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
	
	
		
}