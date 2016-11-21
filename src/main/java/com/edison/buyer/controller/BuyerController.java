package com.edison.buyer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edison.demonstration.service.DemonstrationService;
import com.edison.meta.Buy;

@Controller
public class BuyerController {
	
	
	@Autowired
	DemonstrationService demonstrationServiceImpl;
	
	@RequestMapping("/account")
	public String toAccount(ModelMap map, HttpServletRequest request) {
		List<Buy> buyList = demonstrationServiceImpl.getBuyList();
		

		map.addAttribute("buyList", buyList);
		
		return "account";
	}
}
