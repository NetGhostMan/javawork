package com.edison.buyer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edison.buyer.service.BuyerService;
import com.edison.meta.Buy;
import com.edison.uitl.MapUtil;

@Controller
public class BuyerController {
	@Autowired
	MapUtil mapUtil;
	@Autowired
	BuyerService buyerServiceImpl;
	
	@RequestMapping("/account")
	public String toAccount(ModelMap map, HttpServletRequest request) {
		List<Buy> buyList = buyerServiceImpl.getBuyList();
		

		map.addAttribute("buyList", buyList);
		
		return "account";
	}
}
