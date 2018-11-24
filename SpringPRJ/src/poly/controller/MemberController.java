package poly.controller;

import java.net.URLDecoder;
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
import poly.dto.FileDTO;
import poly.dto.MemDTO;
import poly.dto.UserDTO;
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
		
		List<MemDTO> mList = memberService.getReviewList();
		
		for(MemDTO m : mList) {
			log.info("reviewSeqNo : " +m.getReviewSeqNo());
			log.info("reviewName : " +m.getReviewName());
			log.info("title : " +m.getTitle());
			log.info("userId : " +m.getUserId());
			log.info("chgDt : " +m.getChgDt());
		}
		
		model.addAttribute("mList", mList);
		 
		return "/review";
	}
	
	@RequestMapping(value="reviewsearch")
	public String Reviewsearch(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		response.setCharacterEncoding("UTF-8");
		
		log.info("welcome reviewsearch");
		
		String keyword = URLDecoder.decode(request.getParameter("keyword"),"UTF-8");
		
		
		log.info(keyword);
		
		List<MemDTO> mList = memberService.getReviewList2(keyword);
		
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
	
	@RequestMapping(value="reviewdetail")
	public String Reviewdetail(HttpServletRequest request, HttpServletResponse response, 
			
			ModelMap model) throws Exception {
		
		log.info("welcome reviewdetail");
		
		
		
		MemDTO mDTO = new MemDTO();
		
		String reviewSeqNo = request.getParameter("reviewSeqNo");
		
		
		
		mDTO.setReviewSeqNo(reviewSeqNo);
		
		mDTO=memberService.getMemberdetail(mDTO);
		
		log.info(mDTO.getReviewName());
		log.info(mDTO.getTitle());
		log.info(mDTO.getReviewContents());
		
		
		model.addAttribute("mDTO",mDTO);
		
		
		return "/reviewdetail";
	}
	
	@RequestMapping(value="/reviewlist", method=RequestMethod.POST)
	public String Reviewlist(HttpServletRequest request, HttpServletResponse response, ModelMap model, HttpSession session
			, @RequestParam("file") MultipartFile file,
			MultipartHttpServletRequest mhsr
			) throws Exception {
		
		log.info("welcome reviewlist");
		
		
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		String userId= (String)session.getAttribute("id");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		
		log.info("name : " + name);
		log.info("title : " + title);
		log.info("content : " + content);
		
		MemDTO mDTO = new MemDTO();
		
		mDTO.setReviewName(name);
		mDTO.setTitle(title);
		mDTO.setReviewContents(content);
		mDTO.setUserId(userId);
		
		
		
		log.info("welcome to fileUpload");
		
		log.info("------file info------");
		log.info(file);
		
		FileUpload fileUpload = new FileUpload();
		Map<String,Object> fileInfo = fileUpload.fileUpload(mhsr, file);//파일업로드
		
		for( String key : fileInfo.keySet() ){//파일 정보 로그
            log.info( "key: "+key+"  value: "+ fileInfo.get(key) );
        }
		
		String path = fileInfo.get("path").toString();
		String fileSize = fileInfo.get("fileSize").toString();
		
		FileDTO fDTO = new FileDTO();//DTO에 파일 정보 담기
		fDTO.setOriName((String)fileInfo.get("originalFileName"));
		fDTO.setChgName((String)fileInfo.get("fileName"));
		fDTO.setExtension((String)fileInfo.get("extension"));
		fDTO.setFilePath(path);
		fDTO.setFileSize(fileSize);
		fDTO.setUserNo(userSeqNo);
		fDTO.setBrdKind(kind);
		
		int result = memberService.insertMember(mDTO, fDTO);//파일 등서비스
		
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
		
		
		
	
		return "/alert";
	}
	

	
	
	
	
	
	
	
	
	
		
}