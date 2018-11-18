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
import poly.dto.UserDTO;
import poly.service.IMemService;
import poly.service.ITalkService;

import poly.util.CmmUtil;


@Controller
public class WriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "MemberService")
	private IMemService memberService;
	
	
	@RequestMapping(value="writelist")
	public String Writelist(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome writelist");
		
		String id = (String)session.getAttribute("id");
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setUserId(id);
		
		
		
		List<MemDTO> mList = memberService.getMemberList();
		
		for(MemDTO m : mList) {
			log.info("reviewSeqNo : " +m.getReviewSeqNo());
			log.info("reviewName : " +m.getReviewName());
			log.info("title : " +m.getTitle());
			log.info("userId : " +m.getUserId());
		}
		
		model.addAttribute("mList", mList);
		
		
		 
		return "/writelist";
	}
	
	@RequestMapping(value="writerevise")
	public String writerevise(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome writerevise");
		
		String id = (String)session.getAttribute("id");
		
		MemDTO mDTO = new MemDTO();
		
		mDTO.setUserId(id);
		
		mDTO=memberService.getMemberList(mDTO);
		
		log.info(mDTO.getReviewName());
		log.info(mDTO.getTitle());
		log.info(mDTO.getReviewContents());
		log.info(mDTO.getUserName());
		
		
		model.addAttribute("mDTO",mDTO);
		
		
		
		return "/mylistrevise";
		
	}
	
	@RequestMapping(value="writerevise2")
	public String writerevise2(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome writerevise2");
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userId = (String)session.getAttribute("id");
		
		log.info(name);
		log.info(title);
		log.info(content);
		
		UserDTO uDTO = new UserDTO();
		MemDTO mDTO = new MemDTO();
		mDTO.setReviewName(name);
		mDTO.setTitle(title);
		mDTO.setReviewContents(content);
		uDTO.setUserId(userId);
		
		int result = memberService.writerevise(mDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/writelist.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		model.addAttribute("name", name);
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
		
}