package poly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import poly.dto.ComDTO;
import poly.dto.MemDTO;


import poly.service.IMemService;

import poly.service.impl.MemberService;
import poly.util.CmmUtil;
import poly.util.FileUpload;


@Controller
public class MemberController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name = "MemberService")
	private IMemService memberService;
	
	
	@RequestMapping(value="review")
	public String Review(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome review");
		
		List<MemDTO> mList = memberService.getMemberList();
		
		for(MemDTO m : mList) {
			log.info("reviewSeqNo : " +m.getReviewSeqNo());
			log.info("reviewName : " +m.getReviewName());
			log.info("title : " +m.getTitle());
			log.info("userId : " +m.getUserId());
		}
		
		model.addAttribute("mList", mList);
		 
		return "/review";
	}
	
	@RequestMapping(value="reviewregister")
	public String Reviewregister(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome reviewregister");
		
		 
		return "/reviewregister";
	}
	
	@RequestMapping(value="/reviewlist", method=RequestMethod.POST)
	public String Reviewlist(HttpServletRequest request, HttpServletResponse response, ModelMap model
//			, @RequestParam("file") MultipartFile file,
//			MultipartHttpServletRequest mhsr
			) throws Exception {
		
		log.info("welcome reviewlist");
		
		
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		
		
		log.info("name : " + name);
		log.info("title : " + title);
		log.info("content : " + content);
		
		MemDTO mDTO = new MemDTO();
		
		mDTO.setReviewName(name);
		mDTO.setTitle(title);
		mDTO.setReviewContents(content);
		
		
		int result = memberService.insertMember(mDTO);
		
		log.info(result);
		
		String msg;
		String url;
		if(result==1) {
			model.addAttribute("msg", "등록이 완료되었습니다.");
			model.addAttribute("url", "/review.do");
		} else {
			model.addAttribute("msg", "등록이 되지않았습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		
		
		
//		log.info("welcome to fileUpload");
//		
//		log.info("------file info------");
//		log.info(file);
//		
//		FileUpload fileUpload = new FileUpload();
//		Map<String,Object> fileInfo = fileUpload.fileUpload(mhsr, file);
//		
//		for( String key : fileInfo.keySet() ){
//            log.info( "key: "+key+"  value: "+ fileInfo.get(key) );
//        }
//		
//		model.addAttribute("msg", "등록이 완료되었습니다.");
//		model.addAttribute("url", "/review.do");
//		
		return "/alert";
	}
	
//	@RequestMapping(value="/Memberlist", method=RequestMethod.POST)
//	public String memberlist(HttpServletRequest request, HttpServletResponse response, 
//			ModelMap model) throws Exception {
//		
//		log.info("welcome memberlist");
//		
//		List<MemDTO> mList = memberService.getMemberList();
//		
//		for(MemDTO m : mList) {
//			log.info("reviewSeqNo : " +m.getReviewSeqNo());
//			log.info("reviewName : " +m.getReviewName());
//			log.info("title : " +m.getTitle());
//			log.info("userId : " +m.getUserId());
//		}
//		
//		model.addAttribute("mList", mList);
//		
//		
//		 
//		return "/Memberlist";
//	}
	
	
	
	
	
	
	
	
	
		
}