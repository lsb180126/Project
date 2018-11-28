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

import poly.dto.EatDTO;
import poly.dto.FileDTO;
import poly.dto.PagingDTO;
import poly.dto.TalkDTO;
import poly.service.IEatService;
import poly.service.ITalkService;

import poly.util.CmmUtil;
import poly.util.FileUpload;


@Controller
public class EatController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "EatService")
	private IEatService eatService;

	@RequestMapping(value="eat")
	public String Eat(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome eat");
		
		log.info(this.getClass().getName() + ".eat start!");
		String keyword = CmmUtil.nvl((String)request.getParameter("keyword"),"");
		
		log.info(keyword);
		log.info("TEST"+keyword +"TEST");
		
		int totalCount = eatService.getEatListTotalCount(keyword);
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
		
		
		List<EatDTO> eList = eatService.getEatList(paging);
		
		for(EatDTO e : eList) {
			log.info("eatSeqNo : " +e.getEatSeqNo());
			log.info("title : " +e.getTitle());
			log.info("userId : " +e.getUserId());
			log.info("chgDt : " +e.getChgDt());
		}
		
		model.addAttribute("eList", eList);
		
		model.addAttribute("paging", paging);
		
		eList = null;
		
		log.info(this.getClass().getName() + ".eat end!");
		 
		return "/eat";
	}
	
	
	@RequestMapping(value="eatregister", method=RequestMethod.GET)
	public String Eatregister(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome eatregister");
		
		 
		return "/eatregister";
	}
	
	/*@RequestMapping(value="eatsearch")
	public String Eatsearch(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		response.setCharacterEncoding("UTF-8");
		
		log.info("welcome eatsearch");
		
		String keyword = URLDecoder.decode(request.getParameter("keyword"),"UTF-8");

		
		
		log.info(keyword);
		
		List<EatDTO> eList = eatService.getEatList3(keyword);
		
		for(EatDTO e : eList) {
			log.info("eatSeqNo : " +e.getEatSeqNo());
			log.info("title : " +e.getTitle());
			log.info("userId : " +e.getUserId());
			log.info("chgDt : " +e.getChgDt());
		}
		
		model.addAttribute("eList", eList);
		 
		return "/eat";
	}*/
	
	@RequestMapping(value="eatdetail")
	public String Eatdetail(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome eatdetail");
		
		EatDTO eDTO = new EatDTO();
		
		String eatSeqNo = request.getParameter("eatSeqNo");
		String keyword = CmmUtil.nvl( request.getParameter("keyword"),"");
		
		log.info(keyword);
		
		int totalCount = eatService.getEatListTotalCount(keyword);
		int pageNum = 1;
		int pageCount = 10;
		
		pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
		pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));
		System.out.println(totalCount +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		eDTO.setEatSeqNo(eatSeqNo);
		
		eDTO=eatService.getEatdetail(eDTO);
		
		
		log.info(eDTO.getTitle());
		log.info(eDTO.getEatContents());
		
		
		model.addAttribute("eDTO",eDTO); 
		
		model.addAttribute("pageCount", pageCount);
		
		model.addAttribute("pageNum", pageNum);
		
		model.addAttribute("keyword", keyword);
		
		return "/eatdetail";
	}
	
	@RequestMapping(value="/eatlist", method=RequestMethod.POST)
	public String Eatlist(HttpServletRequest request, HttpServletResponse response,
			 @RequestParam("file") MultipartFile file,
			MultipartHttpServletRequest mhsr,
			ModelMap model, HttpSession session) throws Exception {
		
		log.info("welcome eatlist");
		
		
		
		
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		content = content.replace("\r\n", "<br>");
		String userId= (String)session.getAttribute("id");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		
		
		log.info("title : " + title);
		log.info("content : " + content);
		
		EatDTO eDTO = new EatDTO();
		
		eDTO.setTitle(title);
		eDTO.setEatContents(content);
		eDTO.setUserId(userId);
		
		FileDTO fDTO = new FileDTO();//DTO에 파일 정보 담기
		
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
			eDTO.setTitle(title);
			eDTO.setEatContents(content);
		}
		
		int result = eatService.insertMember(eDTO, fDTO);
		
		log.info(result);
		
		String msg;
		String url;
		if(result==1) {
			model.addAttribute("msg", "등록이 완료되었습니다.");
			model.addAttribute("url", "/eat.do");
		} else {
			model.addAttribute("msg", "등록이 되지않았습니다.");
			model.addAttribute("url", "/index.do");
		}
		 
		return "/alert";
	}
		
}