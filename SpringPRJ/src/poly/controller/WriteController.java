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


import poly.dto.TalkDTO;


import poly.service.ITalkService;

import poly.util.CmmUtil;


@Controller
public class WriteController {
	private Logger log = Logger.getLogger(this.getClass());
	

	
	
	@RequestMapping(value="writelist")
	public String Writelist(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info("welcome writelist");
		
		
		
		
		 
		return "/writelist";
	}
	
		
}