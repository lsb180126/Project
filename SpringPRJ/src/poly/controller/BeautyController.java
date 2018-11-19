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
		
		List<BeautyDTO> bList = beautyService.getBeautyList();
		
		for(BeautyDTO b : bList) {
			log.info("beautySeqNo : " +b.getBeautySeqNo());
			log.info("title : " +b.getTitle());
			log.info("userId : " +b.getUserId());
			log.info("chgDt : " +b.getChgDt());
		}
		
		model.addAttribute("bList", bList);
		
		return "/beauty";
	}
	
	
	@RequestMapping(value="beautyregister")
	public String Beautyregister(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome beautyregister");
		
		 
		return "/beautyregister";
	}
	
	@RequestMapping(value="beautylist", method=RequestMethod.POST) 
	public String Beautylist(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome beautylist");
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		String userId= (String)session.getAttribute("id");
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		BeautyDTO bDTO = new BeautyDTO();
		
		bDTO.setTitle(title);
		bDTO.setBeautyContents(content);
		bDTO.setUserId(userId);
		
		int result = beautyService.insertMember(bDTO);
		log.info(result);
		
		String msg;
		String url;
		if(result==1) {
			model.addAttribute("msg", "등록이 완료되었습니다.");
			model.addAttribute("url", "/beauty.do");
		} else {
			model.addAttribute("msg", "등록이 되지않았습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		 
		return "/alert";
	}
	
	@RequestMapping(value="beautydetail")
	public String Beautydetail(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome beautydetail");
		
		BeautyDTO bDTO = new BeautyDTO();
		
		String beautySeqNo = request.getParameter("beautySeqNo");
		
		bDTO.setBeautySeqNo(beautySeqNo);
		
		bDTO=beautyService.getBeautydetail(bDTO);
		
		
		log.info(bDTO.getTitle());
		log.info(bDTO.getBeautyContents());
		
		
		model.addAttribute("bDTO",bDTO); 
		
		return "/beautydetail";
	}
	
}