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
import poly.dto.HomegoodsDTO;
import poly.dto.SellDTO;
import poly.dto.TalkDTO;
import poly.service.IBeautyService;
import poly.service.IHomegoodsService;
import poly.service.ITalkService;

import poly.util.CmmUtil;


@Controller
public class HomegoodsController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "HomegoodsService")
	private IHomegoodsService homegoodsService;
	
	@RequestMapping(value="homegoods")
	public String Homegoods(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome homegoods");
		
		List<HomegoodsDTO> hList = homegoodsService.getHomegoodsList();
		
		for(HomegoodsDTO h : hList) {
			log.info("homegoodsSeqNo : " +h.getHomegoodsSeqNo());
			log.info("title : " +h.getTitle());
			log.info("userId : " +h.getUserId());
			log.info("chgDt : " +h.getChgDt());
		}
		
		model.addAttribute("hList", hList); 
		
		
		return "/homegoods";
	}
	
	
	@RequestMapping(value="homegoodsregister")
	public String Homegoodsregisterr(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome homegoodsregister");
		
		 
		return "/homegoodsregister";
	}
	
	@RequestMapping(value="homegoodslist", method=RequestMethod.POST) 
	public String Homegoodslist(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome homegoodslist");
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		String userId= (String)session.getAttribute("id");
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		HomegoodsDTO hDTO = new HomegoodsDTO();
		
		hDTO.setTitle(title);
		hDTO.setHomegoodsContents(content);
		hDTO.setUserId(userId);
		
		int result = homegoodsService.insertMember(hDTO);
		log.info(result);
		
		String msg;
		String url;
		if(result==1) {
			model.addAttribute("msg", "등록이 완료되었습니다.");
			model.addAttribute("url", "/homegoods.do");
		} else {
			model.addAttribute("msg", "등록이 되지않았습니다.");
			model.addAttribute("url", "/index.do");
		}
		 
		return "/alert";
	}
	
	@RequestMapping(value="homegoodsdetail")
	public String Homegoodsdetail(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome homegoodsdetail");
		
		HomegoodsDTO hDTO = new HomegoodsDTO();
		
		String homegoodsSeqNo = request.getParameter("homegoodsSeqNo");
		
		hDTO.setHomegoodsSeqNo(homegoodsSeqNo);
		
		hDTO=homegoodsService.getHomegoodsdetail(hDTO);
		
		
		log.info(hDTO.getTitle());
		log.info(hDTO.getHomegoodsContents());
		
		
		model.addAttribute("hDTO",hDTO); 
		
		return "/homegoodsdetail";
	}
	
	
	
}