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
import poly.dto.TalkDTO;


import poly.service.ITalkService;

import poly.util.CmmUtil;


@Controller
public class TalkController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name = "TalkService")
	private ITalkService talkService;
	
	
	@RequestMapping(value="talk")
	public String Talk(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome talk");
		
		List<TalkDTO> tList = talkService.getTalkList();
		
		for(TalkDTO t : tList) {
			log.info("talkSeqNo : " +t.getTalkSeqNo());
			log.info("title : " +t.getTitle());
			log.info("userId : " +t.getUserId());
			log.info("chgDt : " +t.getChgDt());
		}
		
		model.addAttribute("tList", tList);
		 
		return "/talk";
	}
	
	@RequestMapping(value="talkregister")
	public String Talkregister(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome talkregister");
		
		 
		return "/talkregister";
	}
	
	@RequestMapping(value="talkdetail")
	public String Talkdetail(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome talkdetail");
		
		TalkDTO tDTO = new TalkDTO();
		
		String talkSeqNo = request.getParameter("talkSeqNo");
		
		tDTO.setTalkSeqNo(talkSeqNo);
		
		tDTO=talkService.getTalkdetail(tDTO);
		
		
		log.info(tDTO.getTitle());
		log.info(tDTO.getTalkContents());
		
		
		model.addAttribute("tDTO",tDTO); 
		
		return "/talkdetail";
	}
	
	
	@RequestMapping(value="/talklist", method=RequestMethod.POST)
	public String Talklist(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome talklist");
		
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		String userId= (String)session.getAttribute("id");
		
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		TalkDTO tDTO = new TalkDTO();
		
		tDTO.setTitle(title);
		tDTO.setTalkContents(content);
		tDTO.setUserId(userId);
		
		int result = talkService.insertMember(tDTO);
		
		log.info(result);
		
		String msg;
		String url;
		if(result==1) {
			model.addAttribute("msg", "등록이 완료되었습니다.");
			model.addAttribute("url", "/talk.do");
		} else {
			model.addAttribute("msg", "등록이 되지않았습니다.");
			model.addAttribute("url", "/index.do");
		}
		 
		return "/alert";
	}
	
		
}