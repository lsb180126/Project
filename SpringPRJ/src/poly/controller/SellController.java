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

import poly.dto.EatDTO;
import poly.dto.FileDTO;
import poly.dto.SellDTO;
import poly.dto.TalkDTO;
import poly.service.IEatService;
import poly.service.ISellService;
import poly.service.ITalkService;

import poly.util.CmmUtil;
import poly.util.FileUpload;


@Controller
public class SellController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "SellService")
	private ISellService sellService;
	
	@RequestMapping(value="sell")
	public String Sell(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome sell");
		
		List<SellDTO> sList = sellService.getSellList();
		
		for(SellDTO s : sList) {
			log.info("sellSeqNo : " +s.getSellSeqNo());
			log.info("title : " +s.getTitle());
			log.info("userId : " +s.getUserId());
			log.info("chgDt : " +s.getChgDt());
		}
		
		model.addAttribute("sList", sList);
		
		return "/sell";
	}
	
	
	@RequestMapping(value="sellregister")
	public String Sellregister(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome sellregister");
		
		 
		return "/sellregister";
	}
	
	@RequestMapping(value="selllist", method=RequestMethod.POST) 
	public String Selllist(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam("file") MultipartFile file,
			MultipartHttpServletRequest mhsr,
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome selllist");
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		String userId= (String)session.getAttribute("id");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		SellDTO sDTO = new SellDTO();
		
		sDTO.setTitle(title);
		sDTO.setSellContents(content);
		sDTO.setUserId(userId);
		
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
		
		int result = sellService.insertMember(sDTO, fDTO);
		log.info(result);
		
		String msg;
		String url;
		if(result==1) {
			model.addAttribute("msg", "등록이 완료되었습니다.");
			model.addAttribute("url", "/sell.do");
		} else {
			model.addAttribute("msg", "등록이 되지않았습니다.");
			model.addAttribute("url", "/index.do");
		}
		 
		return "/alert";
	}
	
	@RequestMapping(value="selldetail")
	public String Talkdetail(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome selldetail");
		
		SellDTO sDTO = new SellDTO();
		
		String sellSeqNo = request.getParameter("sellSeqNo");
		
		sDTO.setSellSeqNo(sellSeqNo);
		
		sDTO=sellService.getSelldetail(sDTO);
		
		
		log.info(sDTO.getTitle());
		log.info(sDTO.getSellContents());
		
		
		model.addAttribute("sDTO",sDTO); 
		
		return "/selldetail";
	}
		
}