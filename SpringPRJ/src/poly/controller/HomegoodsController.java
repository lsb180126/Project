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

import poly.dto.BeautyDTO;
import poly.dto.EatDTO;
import poly.dto.FileDTO;
import poly.dto.HomegoodsDTO;
import poly.dto.PagingDTO;
import poly.dto.SellDTO;
import poly.dto.TalkDTO;
import poly.service.IBeautyService;
import poly.service.IHomegoodsService;
import poly.service.ITalkService;

import poly.util.CmmUtil;
import poly.util.FileUpload;


@Controller
public class HomegoodsController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "HomegoodsService")
	private IHomegoodsService homegoodsService;
	
	@RequestMapping(value="homegoods")
	public String Homegoods(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome homegoods");
		
		log.info(this.getClass().getName() + ".homegoods start!");
		String keyword = CmmUtil.nvl((String)request.getParameter("keyword"),"");
		
		log.info(keyword);
		log.info("TEST"+keyword +"TEST");
		
		int totalCount = homegoodsService.getHomegoodsListTotalCount(keyword);
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
		
		List<HomegoodsDTO> hList = homegoodsService.getHomegoodsList(paging);
		
		for(HomegoodsDTO h : hList) {
			log.info("homegoodsSeqNo : " +h.getHomegoodsSeqNo());
			log.info("title : " +h.getTitle());
			log.info("userId : " +h.getUserId());
			log.info("chgDt : " +h.getChgDt());
		}
		
		model.addAttribute("hList", hList); 
		
		model.addAttribute("paging", paging);
		
		hList = null;
		
		log.info(this.getClass().getName() + ".homegoods end!");
		
		
		return "/homegoods";
	}
	
	
	@RequestMapping(value="homegoodsregister")
	public String Homegoodsregisterr(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome homegoodsregister");
		
		 
		return "/homegoodsregister";
	}
	
	/*@RequestMapping(value="homegoodssearch")
	public String Eatsearch(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		response.setCharacterEncoding("UTF-8");
		
		log.info("welcome homegoodssearch");
		
		String keyword = URLDecoder.decode(request.getParameter("keyword"),"UTF-8");

		
		
		log.info(keyword);
		
		List<HomegoodsDTO> hList = homegoodsService.getHomegoodsList3(keyword);
		
		for(HomegoodsDTO h : hList) {
			log.info("homegoodsSeqNo : " +h.getHomegoodsSeqNo());
			log.info("title : " +h.getTitle());
			log.info("userId : " +h.getUserId());
			log.info("chgDt : " +h.getChgDt());
		}
		
		model.addAttribute("hList", hList);
		 
		return "/homegoods";
	}*/
	
	@RequestMapping(value="homegoodslist", method=RequestMethod.POST) 
	public String Homegoodslist(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam("file") MultipartFile file,
			MultipartHttpServletRequest mhsr,
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome homegoodslist");
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		String userId= (String)session.getAttribute("id");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		HomegoodsDTO hDTO = new HomegoodsDTO();
		
		hDTO.setTitle(title);
		hDTO.setHomegoodsContents(content);
		hDTO.setUserId(userId);
		
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
		
		int result = homegoodsService.insertMember(hDTO, fDTO);
		log.info(result);
		
		String msg;
		String url;
		if(result==1) {
			model.addAttribute("msg", "등록이 완료되었습니다.");
			model.addAttribute("url", "/homegoods.do");
		} else {
			model.addAttribute("msg", "등록이 되지않았습니다.");
			model.addAttribute("url", "/index.do");
		}
		 
		return "/alert";
	}
	
	@RequestMapping(value="homegoodsdetail")
	public String Homegoodsdetail(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome homegoodsdetail");
		
		HomegoodsDTO hDTO = new HomegoodsDTO();
		
		String homegoodsSeqNo = request.getParameter("homegoodsSeqNo");
		String keyword = CmmUtil.nvl( request.getParameter("keyword"),"");
		
		log.info(keyword);
		
		int totalCount = homegoodsService.getHomegoodsListTotalCount(keyword);
		int pageNum = 1;
		int pageCount = 10;
		
		pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
		pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));
		System.out.println(totalCount +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		hDTO.setHomegoodsSeqNo(homegoodsSeqNo);
		
		hDTO=homegoodsService.getHomegoodsdetail(hDTO);
		
		
		log.info(hDTO.getTitle());
		log.info(hDTO.getHomegoodsContents());
		
		
		model.addAttribute("hDTO",hDTO); 
		
		model.addAttribute("pageCount", pageCount);
		
		model.addAttribute("pageNum", pageNum);
		
		model.addAttribute("keyword", keyword);
		
		return "/homegoodsdetail";
	}
	
	
	
}