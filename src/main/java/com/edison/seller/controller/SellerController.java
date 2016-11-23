package com.edison.seller.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edison.demonstration.service.DemonstrationService;
import com.edison.meta.Product;
import com.edison.seller.service.SellerService;
import com.edison.uitl.MapUtil;
@Controller
public class SellerController {
	
	@Autowired
	MapUtil mapUtil;
	
	@Autowired
	SellerService sellerServiceImpl;
	
	@Autowired
	DemonstrationService demonstrationServiceImpl;
	
	@RequestMapping("/public")
	public String toPublic(HttpServletRequest request, ModelMap map) {
		map = mapUtil.AfterAddUserMap(request, map);
		return "public";
	}
	@RequestMapping("/publicSubmit")
	public String dopublicSubmit(HttpServletRequest request, ModelMap map) {
		map = mapUtil.AfterAddUserMap(request, map);
		Product product = sellerServiceImpl.getProductFromGet(request);

		if (product != null) {
			sellerServiceImpl.saveProduct(product);
		}
		
		map.addAttribute("product", product);
		return "publicSubmit";
	}
	@RequestMapping("/edit")
	public String toEdit(ModelMap map, HttpServletRequest request) {
		map = mapUtil.AfterAddUserMap(request, map);

		Product product = demonstrationServiceImpl.getProductAll(request);
		map.addAttribute("product", product);

		
		

		return "edit";
	}
	@RequestMapping("/editSubmit")
	public String doEditSubmit(ModelMap map, HttpServletRequest request) {
		map = mapUtil.AfterAddUserMap(request, map);
		Product product = sellerServiceImpl.getProductFromGet(request);

		sellerServiceImpl.updateProduct(product);

		map.addAttribute("product",product);

		return "editSubmit";
	}
}
