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

import poly.dto.AllDTO;
import poly.dto.BeautyDTO;
import poly.dto.EatDTO;
import poly.dto.FileDTO;
import poly.dto.HomegoodsDTO;
import poly.dto.MemDTO;
import poly.dto.PagingDTO;
import poly.dto.SellDTO;
import poly.dto.TalkDTO;
import poly.dto.UserDTO;
import poly.service.IBeautyService;
import poly.service.IEatService;
import poly.service.IHomegoodsService;
import poly.service.IMemService;
import poly.service.ISellService;
import poly.service.ITalkService;

import poly.util.CmmUtil;
import poly.util.FileUpload;


@Controller
public class WriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "MemberService")
	private IMemService memberService;
	
	@Resource(name = "TalkService")
	private ITalkService talkService;
	
	@Resource(name = "EatService")
	private IEatService eatService;
	
	@Resource(name = "SellService")
	private ISellService sellService;
	
	@Resource(name = "BeautyService")
	private IBeautyService beautyService;
	
	@Resource(name = "HomegoodsService")
	private IHomegoodsService homegoodsService;
	
	@RequestMapping(value="writelist")
	public String Writelist(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome writelist");
		String userId = (String)session.getAttribute("id");
		
		
		int totalCount = memberService.getMemberListTotalCount2(userId);
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
		paging.setUserId(userId);
		AllDTO aDTO = new AllDTO();
		
		
		
		
		List<AllDTO> aList = memberService.getAllList(paging);
		
		for(AllDTO a : aList) {
			log.info("boardName : " +a.getBoardName());
			log.info("reviewSeqNo : " +a.getReviewSeqNo());
			log.info("reviewContents : " +a.getReviewContents());
			log.info("title : " +a.getTitle());
			log.info("regDt : " +a.getRegDt());
			log.info("chgDt : " +a.getChgDt());
			log.info("reviewName : " +a.getReviewName());
		}
		
		model.addAttribute("aList", aList);
		model.addAttribute("paging", paging);
		
		return "/writelist";
	}
	
	@RequestMapping(value="writedetail2")
	public String writedetail2(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome writedetail2");
		
		
		AllDTO aDTO = new AllDTO();
		
		String reviewSeqNo = request.getParameter("reviewSeqNo");
		
		
		
		log.info(reviewSeqNo);
		
		
		
		
		
		aDTO.setReviewSeqNo(reviewSeqNo);
		
		
		
		aDTO=memberService.getAlldetail(aDTO);
		
		log.info(aDTO.getBoardName());
		log.info(aDTO.getReviewName());
		log.info(aDTO.getChgDt());
		log.info(aDTO.getTitle());
		log.info(aDTO.getReviewContents());
		log.info(aDTO.getChgName());
		log.info(aDTO.getFileSeq());
		
		
		
		model.addAttribute("aDTO", aDTO);
		
		
		
		return "/writedetail2";
		
		
	}
	
	@RequestMapping(value="talkdetail2")
	public String talkdetail2(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome talkdetail2");
		
		
		TalkDTO tDTO = new TalkDTO();
		
		String talkSeqNo = request.getParameter("talkSeqNo");
		
		tDTO.setTalkSeqNo(talkSeqNo);
		
		tDTO=talkService.getTalkdetail(tDTO);
		
		
		log.info(tDTO.getTitle());
		log.info(tDTO.getTalkContents());
		log.info(tDTO.getChgName());
		log.info(tDTO.getFileSeq());
		
		model.addAttribute("tDTO",tDTO); 
		
		
		
		return "/talkdetail2";
		
		
	}
	
	@RequestMapping(value="eatdetail2")
	public String eatdetail2(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome eatdetail2");
		
		
		EatDTO eDTO = new EatDTO();
		
		String eatSeqNo = request.getParameter("eatSeqNo");
		
		eDTO.setEatSeqNo(eatSeqNo);
		
		eDTO=eatService.getEatdetail(eDTO);
		
		
		log.info(eDTO.getTitle());
		log.info(eDTO.getEatContents());
		log.info(eDTO.getChgName());
		log.info(eDTO.getFileSeq());
		
		model.addAttribute("eDTO",eDTO);
		
		
		
		return "/eatdetail2";
		
		
	}
	
	@RequestMapping(value="selldetail2")
	public String selldetail2(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome selldetail");
		
		SellDTO sDTO = new SellDTO();
		
		String sellSeqNo = request.getParameter("sellSeqNo");
		
		sDTO.setSellSeqNo(sellSeqNo);
		
		sDTO=sellService.getSelldetail(sDTO);
		
		
		log.info(sDTO.getTitle());
		log.info(sDTO.getSellContents());
		log.info(sDTO.getChgName());
		log.info(sDTO.getFileSeq());
		
		
		model.addAttribute("sDTO",sDTO); 
		
		
		
		return "/selldetail2";
		
		
	}
	
	@RequestMapping(value="beautydetail2")
	public String beautydetail2(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome beautydetail2");
		
		BeautyDTO bDTO = new BeautyDTO();
		
		String beautySeqNo = request.getParameter("beautySeqNo");
		
		bDTO.setBeautySeqNo(beautySeqNo);
		
		bDTO=beautyService.getBeautydetail(bDTO);
		
		
		log.info(bDTO.getTitle());
		log.info(bDTO.getBeautyContents());
		log.info(bDTO.getChgName());
		log.info(bDTO.getFileSeq());
		
		
		model.addAttribute("bDTO",bDTO);  
		
		
		
		return "/beautydetail2";
		
		
	}
	
	@RequestMapping(value="homegoodsdetail2")
	public String homegoodsdetail2(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome homegoodsdetail2");
		
		HomegoodsDTO hDTO = new HomegoodsDTO();
		
		String homegoodsSeqNo = request.getParameter("homegoodsSeqNo");
		
		hDTO.setHomegoodsSeqNo(homegoodsSeqNo);
		
		hDTO=homegoodsService.getHomegoodsdetail(hDTO);
		
		
		log.info(hDTO.getTitle());
		log.info(hDTO.getHomegoodsContents());
		log.info(hDTO.getChgName());
		log.info(hDTO.getFileSeq());
		
		
		model.addAttribute("hDTO",hDTO);  
		
		
		
		return "/homegoodsdetail2";
		
		
	}
	
	@RequestMapping(value="writerevise")
	public String writerevise(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome writerevise");
		
		
		MemDTO mDTO = new MemDTO();
		
		String reviewSeqNo = request.getParameter("reviewSeqNo");
		
		
		
		log.info(reviewSeqNo);
		
		
		mDTO.setReviewSeqNo(reviewSeqNo);
		
		
		mDTO=memberService.getMemberdetail(mDTO);
		
		log.info(mDTO.getReviewName());
		log.info(mDTO.getTitle());
		log.info(mDTO.getReviewContents());
		log.info(mDTO.getChgName());
		log.info(mDTO.getFileSeq());
		log.info(mDTO.getFilePath());
		log.info(mDTO.getFileSize());
		log.info(mDTO.getOriName());
		
		
		model.addAttribute("mDTO",mDTO);
		
		
		
		return "/writerevise";
		
		
	}
	
	@RequestMapping(value="talkrevise")
	public String talkrevise(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome talkrevise");
		
		
		TalkDTO tDTO = new TalkDTO();
		
		String talkSeqNo = request.getParameter("talkSeqNo");
		
		
		log.info(talkSeqNo);
		
		
		tDTO.setTalkSeqNo(talkSeqNo);
		
		tDTO=talkService.getTalkdetail(tDTO);
		
		log.info(tDTO.getTitle());
		log.info(tDTO.getTalkContents());
		log.info(tDTO.getChgName());
		log.info(tDTO.getFileSeq());
		log.info(tDTO.getFilePath());
		log.info(tDTO.getFileSize());
		log.info(tDTO.getOriName());
		
		
		
		model.addAttribute("tDTO",tDTO);
		
		
		
		return "/talkrevise";
		
		
	}
	
	@RequestMapping(value="eatrevise")
	public String eatrevise(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome eatrevise");
		
		
		EatDTO eDTO = new EatDTO();
		
		String eatSeqNo = request.getParameter("eatSeqNo");
		
		
		log.info(eatSeqNo);
		
		
		eDTO.setEatSeqNo(eatSeqNo);
		
		eDTO=eatService.getEatdetail(eDTO);
		
		log.info(eDTO.getTitle());
		log.info(eDTO.getEatContents());
		log.info(eDTO.getChgName());
		log.info(eDTO.getFileSeq());
		log.info(eDTO.getFilePath());
		log.info(eDTO.getFileSize());
		log.info(eDTO.getOriName());
		
		
		model.addAttribute("eDTO",eDTO);
		
		
		
		return "/eatrevise";
		
		
	}
	
	@RequestMapping(value="sellrevise")
	public String sellrevise(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome sellrevise");
		
		
		SellDTO sDTO = new SellDTO();
		
		String sellSeqNo = request.getParameter("sellSeqNo");
		
		
		log.info(sellSeqNo);
		
		
		sDTO.setSellSeqNo(sellSeqNo);
		
		sDTO=sellService.getSelldetail(sDTO);
		
		log.info(sDTO.getTitle());
		log.info(sDTO.getSellContents());
		log.info(sDTO.getChgName());
		log.info(sDTO.getFileSeq());
		log.info(sDTO.getFilePath());
		log.info(sDTO.getFileSize());
		log.info(sDTO.getOriName());
		
		
		
		
		model.addAttribute("sDTO",sDTO);
		
		
		
		return "/sellrevise";
		
		
	}
	
	@RequestMapping(value="beautyrevise")
	public String beautyrevise(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome beautyrevise");
		
		
		BeautyDTO bDTO = new BeautyDTO();
		
		String beautySeqNo = request.getParameter("beautySeqNo");
		
		
		log.info(beautySeqNo);
		
		
		bDTO.setBeautySeqNo(beautySeqNo);
		
		bDTO=beautyService.getBeautydetail(bDTO);
		
		log.info(bDTO.getTitle());
		log.info(bDTO.getBeautyContents());
		log.info(bDTO.getChgName());
		log.info(bDTO.getFileSeq());
		log.info(bDTO.getFilePath());
		log.info(bDTO.getFileSize());
		log.info(bDTO.getOriName());
		
		
		
		model.addAttribute("bDTO",bDTO);
		
		
		
		return "/beautyrevise";
		
		
	}
	
	@RequestMapping(value="homegoodsrevise")
	public String homegoodsrevise(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome homegoodsrevise");
		
		
		HomegoodsDTO hDTO = new HomegoodsDTO();
		
		String homegoodsSeqNo = request.getParameter("homegoodsSeqNo");
		
		
		log.info(homegoodsSeqNo);
		
		
		hDTO.setHomegoodsSeqNo(homegoodsSeqNo);
		
		hDTO=homegoodsService.getHomegoodsdetail(hDTO);
		
		log.info(hDTO.getTitle());
		log.info(hDTO.getHomegoodsContents());
		log.info(hDTO.getChgName());
		log.info(hDTO.getFileSeq());
		log.info(hDTO.getFilePath());
		log.info(hDTO.getFileSize());
		log.info(hDTO.getOriName());
		
		
		
		model.addAttribute("hDTO",hDTO);
		
		
		
		return "/homegoodsrevise";
		
		
	}
	
	@RequestMapping(value="writerevise2")
	public String writerevise2(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsr,
			ModelMap model) throws Exception {
		
		log.info("welcome writerevise2");
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String reviewSeqNo = request.getParameter("reviewSeqNo");
		String fileSeq = request.getParameter("fileSeq");
		String chgName = request.getParameter("chgName");
		String oriName = request.getParameter("oriName");
		String fileSize = request.getParameter("fileSize");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		String extension = request.getParameter("extension");
		String path = request.getParameter("path");
		
		
		log.info(name);
		log.info(title);
		log.info(content);
		log.info(reviewSeqNo);
		log.info(chgName);
		log.info(fileSeq);
		log.info(userSeqNo);
		log.info(kind);
		log.info(oriName);
		log.info(fileSize);
		log.info(extension);
		log.info(path);
		
		
		log.info("".equals(file.getOriginalFilename()));
		
		log.info(file);
		
		MemDTO mDTO = new MemDTO();
		
		
		mDTO.setReviewName(name);
		mDTO.setTitle(title);
		mDTO.setReviewContents(content);
		mDTO.setReviewSeqNo(reviewSeqNo);
		FileDTO fDTO = new FileDTO();
		fDTO.setUserNo(userSeqNo);
		fDTO.setFileSeq(fileSeq);
		fDTO.setBrdKind(kind);
		
		if(!"".equals(file.getOriginalFilename())) {
		//
			log.info("welcome to fileUpload");
			
			log.info("------file info------");
			log.info(file);
			
			FileUpload fileUpload = new FileUpload();
			Map<String,Object> fileInfo = fileUpload.fileUpload(mhsr, file);//파일업로드
			
			for( String key : fileInfo.keySet() ){//파일 정보 로그
	            log.info( "key: "+key+"  value: "+ fileInfo.get(key) );
	        }
			
			path = fileInfo.get("path").toString();
			fileSize = fileInfo.get("fileSize").toString();
			
			
			//DTO에 파일 정보 담기
			fDTO.setOriName((String)fileInfo.get("originalFileName"));
			fDTO.setChgName((String)fileInfo.get("fileName"));
			fDTO.setExtension((String)fileInfo.get("extension"));
			fDTO.setFilePath(path);
			fDTO.setFileSize(fileSize);
			
		//
		}else {
			fDTO.setOriName(oriName);
			fDTO.setChgName(chgName);
			fDTO.setExtension(extension);
			fDTO.setFilePath(path);
			fDTO.setFileSize(fileSize);
			
			
		}
		
		
		
		
		int result = memberService.writerevise(mDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		model.addAttribute("name", name);
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="talkrevise2")
	public String talkrevise2(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsr,
			ModelMap model) throws Exception {
		
		log.info("welcome talkrevise2");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String talkSeqNo = request.getParameter("talkSeqNo");
		String fileSeq = request.getParameter("fileSeq");
		String chgName = request.getParameter("chgName");
		String oriName = request.getParameter("oriName");
		String fileSize = request.getParameter("fileSize");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		String extension = request.getParameter("extension");
		String path = request.getParameter("path");
		
		
		
		log.info(title);
		log.info(content);
		log.info(talkSeqNo);
		log.info(chgName);
		log.info(fileSeq);
		log.info(userSeqNo);
		log.info(kind);
		log.info(oriName);
		log.info(fileSize);
		log.info(extension);
		log.info(path);
		
		log.info("".equals(file.getOriginalFilename()));
		
		log.info(file);
		
		TalkDTO tDTO = new TalkDTO();
		tDTO.setTitle(title);
		tDTO.setTalkContents(content);
		tDTO.setTalkSeqNo(talkSeqNo);
		
		FileDTO fDTO = new FileDTO();
		fDTO.setUserNo(userSeqNo);
		fDTO.setFileSeq(fileSeq);
		fDTO.setBrdKind(kind);
		
		
		if(!"".equals(file.getOriginalFilename())) {
			//
				log.info("welcome to fileUpload");
				
				log.info("------file info------");
				log.info(file);
				
				FileUpload fileUpload = new FileUpload();
				Map<String,Object> fileInfo = fileUpload.fileUpload(mhsr, file);//파일업로드
				
				for( String key : fileInfo.keySet() ){//파일 정보 로그
		            log.info( "key: "+key+"  value: "+ fileInfo.get(key) );
		        }
				
				path = fileInfo.get("path").toString();
				fileSize = fileInfo.get("fileSize").toString();
				
				
				//DTO에 파일 정보 담기
				fDTO.setOriName((String)fileInfo.get("originalFileName"));
				fDTO.setChgName((String)fileInfo.get("fileName"));
				fDTO.setExtension((String)fileInfo.get("extension"));
				fDTO.setFilePath(path);
				fDTO.setFileSize(fileSize);
				
			//
			}else {
				fDTO.setOriName(oriName);
				fDTO.setChgName(chgName);
				fDTO.setExtension(extension);
				fDTO.setFilePath(path);
				fDTO.setFileSize(fileSize);
				
				
			}
		
		int result = talkService.talkrevise(tDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="eatrevise2")
	public String eatrevise2(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsr,
			ModelMap model) throws Exception {
		
		log.info("welcome eatrevise2");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String eatSeqNo = request.getParameter("eatSeqNo");
		String fileSeq = request.getParameter("fileSeq");
		String chgName = request.getParameter("chgName");
		String oriName = request.getParameter("oriName");
		String fileSize = request.getParameter("fileSize");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		String extension = request.getParameter("extension");
		String path = request.getParameter("path");
		
		log.info(title);
		log.info(content);
		log.info(eatSeqNo);
		log.info(fileSeq);
		log.info(chgName);
		log.info(userSeqNo);
		log.info(kind);
		log.info(oriName);
		log.info(fileSize);
		log.info(extension);
		log.info(path);
		
		log.info("".equals(file.getOriginalFilename()));
		
		log.info(file);
		
		EatDTO eDTO = new EatDTO();
		eDTO.setTitle(title);
		eDTO.setEatContents(content);
		eDTO.setEatSeqNo(eatSeqNo);
		
		FileDTO fDTO = new FileDTO();
		fDTO.setUserNo(userSeqNo);
		fDTO.setFileSeq(fileSeq);
		fDTO.setBrdKind(kind);
		
		if(!"".equals(file.getOriginalFilename())) {
			//
				log.info("welcome to fileUpload");
				
				log.info("------file info------");
				log.info(file);
				
				FileUpload fileUpload = new FileUpload();
				Map<String,Object> fileInfo = fileUpload.fileUpload(mhsr, file);//파일업로드
				
				for( String key : fileInfo.keySet() ){//파일 정보 로그
		            log.info( "key: "+key+"  value: "+ fileInfo.get(key) );
		        }
				
				path = fileInfo.get("path").toString();
				fileSize = fileInfo.get("fileSize").toString();
				
				
				//DTO에 파일 정보 담기
				fDTO.setOriName((String)fileInfo.get("originalFileName"));
				fDTO.setChgName((String)fileInfo.get("fileName"));
				fDTO.setExtension((String)fileInfo.get("extension"));
				fDTO.setFilePath(path);
				fDTO.setFileSize(fileSize);
				
			//
			}else {
				fDTO.setOriName(oriName);
				fDTO.setChgName(chgName);
				fDTO.setExtension(extension);
				fDTO.setFilePath(path);
				fDTO.setFileSize(fileSize);
				
				
			}
		
		int result = eatService.eatrevise(eDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="sellrevise2")
	public String sellrevise2(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsr,
			ModelMap model) throws Exception {
		
		log.info("welcome sellrevise2");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String sellSeqNo = request.getParameter("sellSeqNo");
		String fileSeq = request.getParameter("fileSeq");
		String chgName = request.getParameter("chgName");
		String oriName = request.getParameter("oriName");
		String fileSize = request.getParameter("fileSize");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		String extension = request.getParameter("extension");
		String path = request.getParameter("path");
		
		log.info(title);
		log.info(content);
		log.info(sellSeqNo);
		log.info(fileSeq);
		log.info(chgName);
		log.info(userSeqNo);
		log.info(kind);
		log.info(oriName);
		log.info(fileSize);
		log.info(extension);
		log.info(path);
		
		log.info("".equals(file.getOriginalFilename()));
		
		log.info(file);
		
		SellDTO sDTO = new SellDTO();
		sDTO.setTitle(title);
		sDTO.setSellContents(content);
		sDTO.setSellSeqNo(sellSeqNo);
		
		FileDTO fDTO = new FileDTO();
		fDTO.setUserNo(userSeqNo);
		fDTO.setFileSeq(fileSeq);
		fDTO.setBrdKind(kind);
		
		if(!"".equals(file.getOriginalFilename())) {
			//
				log.info("welcome to fileUpload");
				
				log.info("------file info------");
				log.info(file);
				
				FileUpload fileUpload = new FileUpload();
				Map<String,Object> fileInfo = fileUpload.fileUpload(mhsr, file);//파일업로드
				
				for( String key : fileInfo.keySet() ){//파일 정보 로그
		            log.info( "key: "+key+"  value: "+ fileInfo.get(key) );
		        }
				
				path = fileInfo.get("path").toString();
				fileSize = fileInfo.get("fileSize").toString();
				
				
				//DTO에 파일 정보 담기
				fDTO.setOriName((String)fileInfo.get("originalFileName"));
				fDTO.setChgName((String)fileInfo.get("fileName"));
				fDTO.setExtension((String)fileInfo.get("extension"));
				fDTO.setFilePath(path);
				fDTO.setFileSize(fileSize);
				
			//
			}else {
				fDTO.setOriName(oriName);
				fDTO.setChgName(chgName);
				fDTO.setExtension(extension);
				fDTO.setFilePath(path);
				fDTO.setFileSize(fileSize);
				
				
			}
		
		int result = sellService.sellrevise(sDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="beautyrevise2")
	public String beautyrevise2(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsr,
			ModelMap model) throws Exception {
		
		log.info("welcome beautyrevise2");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String beautySeqNo = request.getParameter("beautySeqNo");
		String fileSeq = request.getParameter("fileSeq");
		String chgName = request.getParameter("chgName");
		String oriName = request.getParameter("oriName");
		String fileSize = request.getParameter("fileSize");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		String extension = request.getParameter("extension");
		String path = request.getParameter("path");
		
		log.info(title);
		log.info(content);
		log.info(beautySeqNo);
		log.info(fileSeq);
		log.info(chgName);
		log.info(userSeqNo);
		log.info(kind);
		log.info(oriName);
		log.info(fileSize);
		log.info(extension);
		log.info(path);
		
		log.info("".equals(file.getOriginalFilename()));
		
		log.info(file);
		
		BeautyDTO bDTO = new BeautyDTO();
		bDTO.setTitle(title);
		bDTO.setBeautyContents(content);
		bDTO.setBeautySeqNo(beautySeqNo);
		
		FileDTO fDTO = new FileDTO();
		fDTO.setUserNo(userSeqNo);
		fDTO.setFileSeq(fileSeq);
		fDTO.setBrdKind(kind);
		
		if(!"".equals(file.getOriginalFilename())) {
			//
				log.info("welcome to fileUpload");
				
				log.info("------file info------");
				log.info(file);
				
				FileUpload fileUpload = new FileUpload();
				Map<String,Object> fileInfo = fileUpload.fileUpload(mhsr, file);//파일업로드
				
				for( String key : fileInfo.keySet() ){//파일 정보 로그
		            log.info( "key: "+key+"  value: "+ fileInfo.get(key) );
		        }
				
				path = fileInfo.get("path").toString();
				fileSize = fileInfo.get("fileSize").toString();
				
				
				//DTO에 파일 정보 담기
				fDTO.setOriName((String)fileInfo.get("originalFileName"));
				fDTO.setChgName((String)fileInfo.get("fileName"));
				fDTO.setExtension((String)fileInfo.get("extension"));
				fDTO.setFilePath(path);
				fDTO.setFileSize(fileSize);
				
			//
			}else {
				fDTO.setOriName(oriName);
				fDTO.setChgName(chgName);
				fDTO.setExtension(extension);
				fDTO.setFilePath(path);
				fDTO.setFileSize(fileSize);
				
				
			}
		
		int result = beautyService.beautyrevise(bDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="homegoodsrevise2")
	public String homegoodsrevise2(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsr,
			ModelMap model) throws Exception {
		
		log.info("welcome homegoodsrevise2");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String homegoodsSeqNo = request.getParameter("homegoodsSeqNo");
		String fileSeq = request.getParameter("fileSeq");
		String chgName = request.getParameter("chgName");
		String oriName = request.getParameter("oriName");
		String fileSize = request.getParameter("fileSize");
		String userSeqNo = (String)session.getAttribute("userSeqNo");
		String kind = request.getParameter("kind");
		String extension = request.getParameter("extension");
		String path = request.getParameter("path");
		
		log.info(title);
		log.info(content);
		log.info(homegoodsSeqNo);
		log.info(fileSeq);
		log.info(chgName);
		log.info(userSeqNo);
		log.info(kind);
		log.info(oriName);
		log.info(fileSize);
		log.info(extension);
		log.info(path);
		
		log.info("".equals(file.getOriginalFilename()));
		
		log.info(file);
		
		HomegoodsDTO hDTO = new HomegoodsDTO();
		hDTO.setTitle(title);
		hDTO.setHomegoodsContents(content);
		hDTO.setHomegoodsSeqNo(homegoodsSeqNo);
		
		FileDTO fDTO = new FileDTO();
		fDTO.setUserNo(userSeqNo);
		fDTO.setFileSeq(fileSeq);
		fDTO.setBrdKind(kind);
		
		if(!"".equals(file.getOriginalFilename())) {
			//
				log.info("welcome to fileUpload");
				
				log.info("------file info------");
				log.info(file);
				
				FileUpload fileUpload = new FileUpload();
				Map<String,Object> fileInfo = fileUpload.fileUpload(mhsr, file);//파일업로드
				
				for( String key : fileInfo.keySet() ){//파일 정보 로그
		            log.info( "key: "+key+"  value: "+ fileInfo.get(key) );
		        }
				
				path = fileInfo.get("path").toString();
				fileSize = fileInfo.get("fileSize").toString();
				
				
				//DTO에 파일 정보 담기
				fDTO.setOriName((String)fileInfo.get("originalFileName"));
				fDTO.setChgName((String)fileInfo.get("fileName"));
				fDTO.setExtension((String)fileInfo.get("extension"));
				fDTO.setFilePath(path);
				fDTO.setFileSize(fileSize);
				
			//
			}else {
				fDTO.setOriName(oriName);
				fDTO.setChgName(chgName);
				fDTO.setExtension(extension);
				fDTO.setFilePath(path);
				fDTO.setFileSize(fileSize);
				
				
			}
		
		int result = homegoodsService.homegoodsrevise(hDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "수정되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/index.do");
		}
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
	
	//게시판 삭제
	@RequestMapping(value="writedelete")
	public String writedelete(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome writedelete");
		
		
		String reviewSeqNo = request.getParameter("reviewSeqNo");
		String fileSeq = request.getParameter("fileSeq");
		
		log.info("reviewSeqNo :"+reviewSeqNo);
		log.info("fileSeq :"+fileSeq);
		
		
		MemDTO mDTO = new MemDTO();
		mDTO.setReviewSeqNo(reviewSeqNo);
		
		
		FileDTO fDTO = new FileDTO();
		fDTO.setFileSeq(fileSeq);
		
		int result = memberService.writedelete(mDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "삭제되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/writelist.do");
		}
		
		
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="talkdelete")
	public String talkdelete(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome talkdelete");
		
		
		String talkSeqNo = request.getParameter("talkSeqNo");
		String fileSeq = request.getParameter("fileSeq");
		
		log.info("talkSeqNo :" + talkSeqNo);
		log.info("fileSeq :"+fileSeq);
		
		TalkDTO tDTO = new TalkDTO();
		
		tDTO.setTalkSeqNo(talkSeqNo);
		
		FileDTO fDTO = new FileDTO();
		fDTO.setFileSeq(fileSeq);
		
		int result = talkService.talkdelete(tDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "삭제되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/writelist.do");
		}
		
		
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="eatdelete")
	public String eatdelete(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome eatdelete");
		
		
		String eatSeqNo = request.getParameter("eatSeqNo");
		String fileSeq = request.getParameter("fileSeq");
		
		log.info("eatSeqNo :" +eatSeqNo);
		log.info("fileSeq :"+fileSeq);
		
		EatDTO eDTO = new EatDTO();
		
		eDTO.setEatSeqNo(eatSeqNo);
		
		FileDTO fDTO = new FileDTO();
		fDTO.setFileSeq(fileSeq);
		
		int result = eatService.eatdelete(eDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "삭제되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/writelist.do");
		}
		
		
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="selldelete")
	public String selldelete(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome selldelete");
		
		
		String sellSeqNo = request.getParameter("sellSeqNo");
		String fileSeq = request.getParameter("fileSeq");
		
		log.info("sellSeqNo :" +sellSeqNo);
		log.info("fileSeq :"+fileSeq);
		
		SellDTO sDTO = new SellDTO();
		
		sDTO.setSellSeqNo(sellSeqNo);
		
		FileDTO fDTO = new FileDTO();
		fDTO.setFileSeq(fileSeq);
		
		int result = sellService.selldelete(sDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "삭제되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/writelist.do");
		}
		
		
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="beautydelete")
	public String beautydelete(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome beautydelete");
		
		
		String beautySeqNo = request.getParameter("beautySeqNo");
		String fileSeq = request.getParameter("fileSeq");
		
		log.info("beautySeqNo :" +beautySeqNo);
		log.info("fileSeq :"+fileSeq);
		
		
		BeautyDTO bDTO = new BeautyDTO();
		
		bDTO.setBeautySeqNo(beautySeqNo);
		
		FileDTO fDTO = new FileDTO();
		fDTO.setFileSeq(fileSeq);
		
		int result = beautyService.beautydelete(bDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "삭제되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/writelist.do");
		}
		
		
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="homegoodsdelete")
	public String homegoodsdelete(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome homegoodsdelete");
		
		
		String homegoodsSeqNo = request.getParameter("homegoodsSeqNo");
		String fileSeq = request.getParameter("fileSeq");
		
		log.info("homegoodsSeqNo :" +homegoodsSeqNo);
		log.info("fileSeq :"+fileSeq);
		
		HomegoodsDTO hDTO = new HomegoodsDTO();
		
		hDTO.setHomegoodsSeqNo(homegoodsSeqNo);
		
		FileDTO fDTO = new FileDTO();
		fDTO.setFileSeq(fileSeq);
		
		int result = homegoodsService.homegoodsdelete(hDTO, fDTO);
		log.info(result);
		
		String url;
		String msg;
		if(result == 1) {
			model.addAttribute("msg", "삭제되었습니다.");
			model.addAttribute("url", "/index.do");
		} else {
			model.addAttribute("msg", "실패하였습니다.");
			model.addAttribute("url", "/writelist.do");
		}
		
		
		
		
		return "/alert";
		
	}
	
}