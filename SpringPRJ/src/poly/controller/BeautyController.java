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

import poly.dto.BeautyDTO;
import poly.dto.SellDTO;
import poly.dto.TalkDTO;
import poly.service.IBeautyService;
import poly.service.ISellService;
import poly.service.ITalkService;

import poly.util.CmmUtil;


@Controller
public class BeautyController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "BeautyService")
	private IBeautyService beautyService;
	
	@RequestMapping(value="beauty")
	public String Beauty(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome beauty");
		
		 
		return "/beauty";
	}
	
	
	@RequestMapping(value="beautyregister", method=RequestMethod.GET)
	public String Beautyregister(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome beautyregister");
		
		 
		return "/beautyregister";
	}
	
	@RequestMapping(value="beautylist") 
	public String Beautylist(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome beautylist");
		
		
		
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		
		
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		BeautyDTO bDTO = new BeautyDTO();
		
		bDTO .setTitle(title);
		bDTO .setBeautyContents(content);
		
		
		int result = beautyService.insertMember(bDTO);
		
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		model.addAttribute("url", "/beauty.do");
		 
		return "/redirect2";
	}
		
}