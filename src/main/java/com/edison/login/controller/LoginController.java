package com.edison.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edison.demonstration.service.ProductService;
import com.edison.login.service.LoginService;
import com.edison.meta.Buy;
import com.edison.meta.Product;
import com.edison.meta.User;

@Controller
public class LoginController {

	@Autowired
	LoginService loginServiceImpl;
	@Autowired
	ProductService productServicetestImpl;

	@RequestMapping("/login")
	public String toLoginPage() {

		return "login";
	}

	@RequestMapping("/logout")
	public String doLogout(HttpServletRequest request,HttpServletResponse response) {
		HttpSession httpSession = request.getSession();
		
		httpSession.invalidate();
		
		return "login";
	}

	@RequestMapping("/")
	public String toIndex(ModelMap map, HttpServletRequest request) {
		List<Product> productList = productServicetestImpl.getProducts();
		map.addAttribute("productList", productList);
		User user = loginServiceImpl.getUser(request);
		if (user != null) {
			map.addAttribute("user", user);
		}
		return "index";
	}

	@RequestMapping("/show")
	public String toShow(ModelMap map, HttpServletRequest request) {
		Product product = productServicetestImpl.getProductAll();
		User user = loginServiceImpl.getUser(request);
		map.addAttribute("product", product);
		map.addAttribute("user", user);
		return "show";
	}

	@RequestMapping("/public")
	public String toPublic(HttpServletResponse response, HttpServletRequest request, ModelMap map) {
		User user = loginServiceImpl.getUser(request);

		map.addAttribute("user", user);
		return "public";
	}

	
	@RequestMapping("/account")
	public String toAccount(ModelMap map,HttpServletRequest request){
		List<Buy> buyList = productServicetestImpl.getBuyList();
		User user = loginServiceImpl.getUser(request);
		
		map.addAttribute("buyList",buyList);
		map.addAttribute("user",user);
		return "account";
	}
	
	@RequestMapping("/publicSubmit")
	public String dopublicSubmit(HttpServletRequest request,ModelMap map){
		Product product = loginServiceImpl.getProduct(request);
		
		if(product != null){
			loginServiceImpl.saveProduct(product);
		}
		User user = loginServiceImpl.getUser(request);
		map.addAttribute("user",user);
		map.addAttribute("product",product);
		return "publicSubmit";
	}
	
}
