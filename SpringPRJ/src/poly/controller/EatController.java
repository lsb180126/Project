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

import poly.dto.EatDTO;
import poly.dto.TalkDTO;
import poly.service.IEatService;
import poly.service.ITalkService;

import poly.util.CmmUtil;


@Controller
public class EatController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "EatService")
	private IEatService eatService;

	@RequestMapping(value="eat")
	public String Eat(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome eat");
		
		 
		return "/eat";
	}
	
	
	@RequestMapping(value="eatregister", method=RequestMethod.GET)
	public String Eatregister(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome eatregister");
		
		 
		return "/eatregister";
	}
	
	@RequestMapping(value="eatlist")
	public String Eatlist(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome eatlist");
		
		
		
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		
		
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		EatDTO eDTO = new EatDTO();
		
		eDTO.setTitle(title);
		eDTO.setEatContents(content);
		
		
		int result = eatService.insertMember(eDTO);
		
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		model.addAttribute("url", "/eat.do");
		 
		return "/redirect2";
	}
		
}