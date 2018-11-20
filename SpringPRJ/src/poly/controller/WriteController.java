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

import poly.dto.BeautyDTO;
import poly.dto.EatDTO;
import poly.dto.HomegoodsDTO;
import poly.dto.MemDTO;
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
		
		MemDTO mDTO = new MemDTO();
		TalkDTO tDTO = new TalkDTO();
		EatDTO eDTO = new EatDTO();
		SellDTO sDTO = new SellDTO();
		BeautyDTO bDTO = new BeautyDTO();
		HomegoodsDTO hDTO = new HomegoodsDTO();
		
		String userId = (String)session.getAttribute("id");
		mDTO.setUserId(userId);
		tDTO.setUserId(userId);
		eDTO.setUserId(userId);
		sDTO.setUserId(userId);
		bDTO.setUserId(userId);
		hDTO.setUserId(userId);
		
		List<MemDTO> mList = memberService.getMemberList(mDTO);
		List<TalkDTO> tList = talkService.getTalkList2(tDTO);
		List<EatDTO> eList = eatService.getEatList2(eDTO);
		List<SellDTO> sList = sellService.getSellList2(sDTO);
		List<BeautyDTO> bList = beautyService.getBeautyList2(bDTO);
		List<HomegoodsDTO> hList = homegoodsService.getHomegoodsList2(hDTO);
		
		for(MemDTO m : mList) {
			log.info("reviewSeqNo : " +m.getReviewSeqNo());
			log.info("reviewName : " +m.getReviewName());
			log.info("title : " +m.getTitle());
			log.info("userId : " +m.getUserId());
		}
		
		for(TalkDTO t : tList) {
			log.info("talkSeqNo : " +t.getTalkSeqNo());
			log.info("title : " +t.getTitle());
			log.info("userId : " +t.getUserId());
			log.info("chgDt : " +t.getChgDt());
		}
		
		for(EatDTO e : eList) {
			log.info("eatSeqNo : " +e.getEatSeqNo());
			log.info("title : " +e.getTitle());
			log.info("userId : " +e.getUserId());
			log.info("chgDt : " +e.getChgDt());
		}
		
		for(SellDTO s : sList) {
			log.info("sellSeqNo : " +s.getSellSeqNo());
			log.info("title : " +s.getTitle());
			log.info("userId : " +s.getUserId());
			log.info("chgDt : " +s.getChgDt());
		}
		
		for(BeautyDTO b : bList) {
			log.info("beautySeqNo : " +b.getBeautySeqNo());
			log.info("title : " +b.getTitle());
			log.info("userId : " +b.getUserId());
			log.info("chgDt : " +b.getChgDt());
		}
		
		for(HomegoodsDTO h : hList) {
			log.info("homegoodsSeqNo : " +h.getHomegoodsSeqNo());
			log.info("title : " +h.getTitle());
			log.info("userId : " +h.getUserId());
			log.info("chgDt : " +h.getChgDt());
		}
		
		model.addAttribute("mList", mList);
		model.addAttribute("tList", tList);
		model.addAttribute("eList", eList);
		model.addAttribute("sList", sList); 
		model.addAttribute("bList", bList);
		model.addAttribute("hList", hList);
		
		return "/writelist";
	}
	
	@RequestMapping(value="writedetail")
	public String writedetail(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("welcome writedetail");
		
		
		MemDTO mDTO = new MemDTO();
		
		String reviewSeqNo = request.getParameter("reviewSeqNo");

		mDTO.setReviewSeqNo(reviewSeqNo);
		
		
		mDTO=memberService.getWritedetail(mDTO);
		
		log.info(mDTO.getReviewName());
		log.info(mDTO.getTitle());
		log.info(mDTO.getReviewContents());
		
		
		
		model.addAttribute("mDTO",mDTO);
		
		
		
		return "/writedetail";
		
		
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
		
		mDTO=memberService.getWritedetail(mDTO);
		
		log.info(mDTO.getReviewName());
		log.info(mDTO.getTitle());
		log.info(mDTO.getReviewContents());
		
		
		
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
		
		
		
		model.addAttribute("hDTO",hDTO);
		
		
		
		return "/homegoodsrevise";
		
		
	}
	
	@RequestMapping(value="writerevise2")
	public String writerevise2(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome writerevise2");
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String reviewSeqNo = request.getParameter("reviewSeqNo");
		
		log.info(name);
		log.info(title);
		log.info(content);
		log.info(reviewSeqNo);
		
		MemDTO mDTO = new MemDTO();
		mDTO.setReviewName(name);
		mDTO.setTitle(title);
		mDTO.setReviewContents(content);
		mDTO.setReviewSeqNo(reviewSeqNo);
		
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
	
	@RequestMapping(value="talkrevise2")
	public String talkrevise2(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome talkrevise2");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String talkSeqNo = request.getParameter("talkSeqNo");
		
		log.info(title);
		log.info(content);
		log.info(talkSeqNo);
		
		TalkDTO tDTO = new TalkDTO();
		tDTO.setTitle(title);
		tDTO.setTalkContents(content);
		tDTO.setTalkSeqNo(talkSeqNo);
		
		int result = talkService.talkrevise(tDTO);
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
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="eatrevise2")
	public String eatrevise2(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome eatrevise2");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String eatSeqNo = request.getParameter("eatSeqNo");
		
		log.info(title);
		log.info(content);
		log.info(eatSeqNo);
		
		EatDTO eDTO = new EatDTO();
		eDTO.setTitle(title);
		eDTO.setEatContents(content);
		eDTO.setEatSeqNo(eatSeqNo);
		
		int result = eatService.eatrevise(eDTO);
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
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="sellrevise2")
	public String sellrevise2(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome sellrevise2");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String sellSeqNo = request.getParameter("sellSeqNo");
		
		log.info(title);
		log.info(content);
		log.info(sellSeqNo);
		
		SellDTO sDTO = new SellDTO();
		sDTO.setTitle(title);
		sDTO.setSellContents(content);
		sDTO.setSellSeqNo(sellSeqNo);
		
		int result = sellService.sellrevise(sDTO);
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
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="beautyrevise2")
	public String beautyrevise2(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome beautyrevise2");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String beautySeqNo = request.getParameter("beautySeqNo");
		
		log.info(title);
		log.info(content);
		log.info(beautySeqNo);
		
		BeautyDTO bDTO = new BeautyDTO();
		bDTO.setTitle(title);
		bDTO.setBeautyContents(content);
		bDTO.setBeautySeqNo(beautySeqNo);
		
		int result = beautyService.beautyrevise(bDTO);
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
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="homegoodsrevise2")
	public String homegoodsrevise2(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome homegoodsrevise2");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String homegoodsSeqNo = request.getParameter("homegoodsSeqNo");
		
		log.info(title);
		log.info(content);
		log.info(homegoodsSeqNo);
		
		HomegoodsDTO hDTO = new HomegoodsDTO();
		hDTO.setTitle(title);
		hDTO.setHomegoodsContents(content);
		hDTO.setHomegoodsSeqNo(homegoodsSeqNo);
		
		int result = homegoodsService.homegoodsrevise(hDTO);
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
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		
		return "/alert";
		
	}
	
	@RequestMapping(value="writedelete")
	public String writedelete(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info("welcome writedelete");
		
		
		String reviewSeqNo = request.getParameter("reviewSeqNo");
		log.info(reviewSeqNo);
		
		MemDTO mDTO = new MemDTO();
		
		mDTO.setReviewSeqNo(reviewSeqNo);
		
		int result = memberService.writedelete(mDTO);
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
		log.info(talkSeqNo);
		
		TalkDTO tDTO = new TalkDTO();
		
		tDTO.setTalkSeqNo(talkSeqNo);
		
		int result = talkService.talkdelete(tDTO);
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
		log.info(eatSeqNo);
		
		EatDTO eDTO = new EatDTO();
		
		eDTO.setEatSeqNo(eatSeqNo);
		
		int result = eatService.eatdelete(eDTO);
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
		log.info(sellSeqNo);
		
		SellDTO sDTO = new SellDTO();
		
		sDTO.setSellSeqNo(sellSeqNo);
		
		int result = sellService.selldelete(sDTO);
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
		log.info(beautySeqNo);
		
		BeautyDTO bDTO = new BeautyDTO();
		
		bDTO.setBeautySeqNo(beautySeqNo);
		
		int result = beautyService.beautydelete(bDTO);
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
		log.info(homegoodsSeqNo);
		
		HomegoodsDTO hDTO = new HomegoodsDTO();
		
		hDTO.setHomegoodsSeqNo(homegoodsSeqNo);
		
		int result = homegoodsService.homegoodsdelete(hDTO);
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