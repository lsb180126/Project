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

import poly.dto.FileDTO;
import poly.dto.MemDTO;
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
			@RequestParam("file") MultipartFile file,
			MultipartHttpServletRequest mhsr,
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome talklist");
		
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		String userId= (String)session.getAttribute("id");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		TalkDTO tDTO = new TalkDTO();
		
		tDTO.setTitle(title);
		tDTO.setTalkContents(content);
		tDTO.setUserId(userId);
		
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
		
		FileDTO fDTO = new FileDTO();
		
		fDTO.setOriName((String)fileInfo.get("originalFileName"));
		fDTO.setChgName((String)fileInfo.get("fileName"));
		fDTO.setExtension((String)fileInfo.get("extension"));
		fDTO.setFilePath(path);
		fDTO.setFileSize(fileSize);
		fDTO.setUserNo(userSeqNo);
		fDTO.setBrdKind(kind);
		
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