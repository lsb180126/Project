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

import poly.dto.FileDTO;
import poly.dto.MemDTO;
import poly.dto.PagingDTO;
import poly.dto.TalkDTO;


import poly.service.ITalkService;

import poly.util.CmmUtil;
import poly.util.FileUpload;


@Controller
public class TalkController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name = "TalkService")
	private ITalkService talkService;
	
	
	@RequestMapping(value="talk")
	public String Talk(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome talk");
		
		log.info(this.getClass().getName() + ".talk start!");
		String keyword = CmmUtil.nvl((String)request.getParameter("keyword"),"");
		
		log.info(keyword);
		log.info("TEST"+keyword +"TEST");
		
		int totalCount = talkService.getTalkListTotalCount(keyword);
		int pageNum = 1;
		int pageCount = 10;
		
		pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
		pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));
		System.out.println(totalCount +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		// 페이징 Dto 생성
		PagingDTO paging = new PagingDTO();
		paging.setPage_num(pageNum);
		paging.setPage_count(pageCount);
		paging.setTotal_count(totalCount);
		paging.setKeyword(keyword);
		
		List<TalkDTO> tList = talkService.getTalkList(paging);
		
		for(TalkDTO t : tList) {
			log.info("talkSeqNo : " +t.getTalkSeqNo());
			log.info("title : " +t.getTitle());
			log.info("userId : " +t.getUserId());
			log.info("chgDt : " +t.getChgDt());
		}
		
		model.addAttribute("tList", tList);
		
		model.addAttribute("paging", paging);
		
		tList = null;
		
		log.info(this.getClass().getName() + ".talk end!");
		 
		return "/talk";
	}
	
	/*@RequestMapping(value="talksearch")
	public String Talksearch(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		response.setCharacterEncoding("UTF-8");
		
		log.info("welcome talksearch");
		
		String keyword = URLDecoder.decode(request.getParameter("keyword"),"UTF-8");

		
		
		log.info(keyword);
		
		List<TalkDTO> tList = talkService.getTalkList3(keyword);
		
		for(TalkDTO t : tList) {
			log.info("talkSeqNo : " +t.getTalkSeqNo());
			log.info("title : " +t.getTitle());
			log.info("userId : " +t.getUserId());
			log.info("chgDt : " +t.getChgDt());
		}
		
		model.addAttribute("tList", tList);
		 
		return "/talk";
	}*/
	
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
		String keyword = CmmUtil.nvl( request.getParameter("keyword"),"");
		
		log.info(keyword);
		
		int totalCount = talkService.getTalkListTotalCount(keyword);
		int pageNum = 1;
		int pageCount = 10;
		
		pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
		pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));
		System.out.println(totalCount +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		tDTO.setTalkSeqNo(talkSeqNo);
		
		tDTO=talkService.getTalkdetail(tDTO);
		
		
		log.info(tDTO.getTitle());
		log.info(tDTO.getTalkContents());
		
		model.addAttribute("tDTO",tDTO); 
		
		model.addAttribute("pageCount", pageCount);
		
		model.addAttribute("pageNum", pageNum);
		
		model.addAttribute("keyword", keyword);
		
		return "/talkdetail";
	}
	
	
	@RequestMapping(value="/talklist", method=RequestMethod.POST)
	public String Talklist(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file,
			MultipartHttpServletRequest mhsr,
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome talklist");
		
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		content = content.replace("\r\n", "<br>");
		String userId= (String)session.getAttribute("id");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		
		
		log.info("title : " + title);
		log.info("content : " + content);
		log.info(userId);
		log.info(userSeqNo);
		log.info(kind);
		
		TalkDTO tDTO = new TalkDTO();
		
		tDTO.setTitle(title);
		tDTO.setTalkContents(content);
		tDTO.setUserId(userId);
		
		FileDTO fDTO = new FileDTO();
		
		if(!"".equals(CmmUtil.nvl(file.getOriginalFilename()))) {
			log.info("welcome to fileUpload");
			
			log.info("------file info------");
			log.info(file);
			
			FileUpload fileUpload = new FileUpload();
			Map<String,Object> fileInfo = fileUpload.fileUpload(mhsr, file);
			
			for( String key : fileInfo.keySet() ){
	            log.info( "key: "+key+"  value: "+ fileInfo.get(key) );
	        }
			
			String path = fileInfo.get("path").toString();
			String fileSize = fileInfo.get("fileSize").toString();
			
			
			
			fDTO.setOriName((String)fileInfo.get("originalFileName"));
			fDTO.setChgName((String)fileInfo.get("fileName"));
			fDTO.setExtension((String)fileInfo.get("extension"));
			fDTO.setFilePath(path);
			fDTO.setFileSize(fileSize);
			fDTO.setUserNo(userSeqNo);
			fDTO.setBrdKind(kind);
			
		} else {
			fDTO = null;
			tDTO.setTitle(title);
			tDTO.setTalkContents(content);
			
		}
		
		int result = talkService.insertMember(tDTO, fDTO);
		
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