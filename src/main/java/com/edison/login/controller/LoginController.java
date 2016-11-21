package com.edison.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	// 登陆页面
	@RequestMapping("/login")
	public String toLoginPage() {
		return "login";
	}

	// 退出登陆
	@RequestMapping("/logout")
	public String doLogout(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "login";
	}

}
