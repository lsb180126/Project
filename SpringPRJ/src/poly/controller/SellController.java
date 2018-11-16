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
import poly.dto.SellDTO;
import poly.dto.TalkDTO;
import poly.service.IEatService;
import poly.service.ISellService;
import poly.service.ITalkService;

import poly.util.CmmUtil;


@Controller
public class SellController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "SellService")
	private ISellService sellService;
	
	@RequestMapping(value="sell")
	public String Sell(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome sell");
		
		 
		return "/sell";
	}
	
	
	@RequestMapping(value="sellregister", method=RequestMethod.GET)
	public String Sellregister(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome sellregister");
		
		 
		return "/sellregister";
	}
	
	@RequestMapping(value="selllist") 
	public String Selllist(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome selllist");
		
		
		
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		
		
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		SellDTO sDTO = new SellDTO();
		
		sDTO .setTitle(title);
		sDTO .setSellContents(content);
		
		
		int result = sellService.insertMember(sDTO);
		
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		model.addAttribute("url", "/sell.do");
		 
		return "/redirect2";
	}
	
		
}