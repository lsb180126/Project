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

import poly.dto.ComDTO;
import poly.dto.HospitalDTO;
import poly.dto.MemDTO;
import poly.dto.PagingDTO;
import poly.dto.UserDTO;
import poly.service.IBeautyService;
import poly.service.IEatService;
import poly.service.IHomegoodsService;
import poly.service.IHospitalService;
import poly.service.IMemService;
import poly.service.ISellService;
import poly.service.ITalkService;
import poly.service.IUserService;


import poly.service.impl.UserService;

import poly.util.CmmUtil;
import poly.util.MailUtil;


@Controller
public class HospitalController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name = "HospitalService")
	private IHospitalService hospitalService;
	
	@RequestMapping(value="hospitalfind")
	public String hospitalfind(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		
		log.info("welcome hospitalfind");
		
		
		return "/hospitalfind";
	}
	
	@RequestMapping(value="hospitalSearch")
	public String hospitalSearch(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		log.info("welcome hospitalfind");
		String address = CmmUtil.nvl((String)request.getParameter("address"));
		
		log.info("address : " +address);
		
		
		
		List<HospitalDTO> hList = hospitalService.getHospitalList(address);
		
		log.info(hList.get(0).getHospitalAllAddress());
		log.info(hList.get(0).getHospitalRodAddress());
		
		
		model.addAttribute("hList",hList);
		
		
		return "/hospitalfind";
	}
	

}