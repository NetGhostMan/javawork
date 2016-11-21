package com.edison.demonstration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edison.demonstration.service.DemonstrationService;
import com.edison.meta.Product;
import com.edison.uitl.MapUtil;

@Controller
public class DemonstrationController {
	
	@Autowired
	MapUtil mapUtil;
	
	@Autowired
	DemonstrationService demonstrationServiceImpl;
	
	//展示页面
	@RequestMapping("/")
	public String toIndex(ModelMap map, HttpServletRequest request) {
		map = mapUtil.AfterAddUserMap(request, map);
		List<Product> productList = demonstrationServiceImpl.getProductList();
		map.addAttribute("productList", productList);
		return "index";
	}
	//查看页面
	@RequestMapping("/show")
	public String toShow(ModelMap map, HttpServletRequest request) {
		map = mapUtil.AfterAddUserMap(request, map);
		Product product = demonstrationServiceImpl.getProductAll(request);
		
		map.addAttribute("product", product);
		return "show";
	}
}
