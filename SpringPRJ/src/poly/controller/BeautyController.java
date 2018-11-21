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

import poly.dto.BeautyDTO;
import poly.dto.FileDTO;
import poly.dto.SellDTO;
import poly.dto.TalkDTO;
import poly.service.IBeautyService;
import poly.service.ISellService;
import poly.service.ITalkService;

import poly.util.CmmUtil;
import poly.util.FileUpload;


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
			@RequestParam("file") MultipartFile file,
			MultipartHttpServletRequest mhsr,
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome beautylist");
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		String userId= (String)session.getAttribute("id");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		BeautyDTO bDTO = new BeautyDTO();
		
		bDTO.setTitle(title);
		bDTO.setBeautyContents(content);
		bDTO.setUserId(userId);
		
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
		
		int result = beautyService.insertMember(bDTO, fDTO);
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