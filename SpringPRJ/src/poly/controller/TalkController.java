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


import poly.dto.TalkDTO;


import poly.service.ITalkService;

import poly.util.CmmUtil;


@Controller
public class TalkController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name = "TalkService")
	private ITalkService talkService;
	
	
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