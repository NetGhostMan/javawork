package com.edison.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edison.api.service.DoLoginService;
import com.edison.meta.User;

@Controller
@RequestMapping("/api")
public class ApiController {

	@Autowired
	DoLoginService doLoginServiceImpl;

	@RequestMapping("/login")
	public String doLogin(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		int code = 100;
		String message = "";
		boolean result = false;

		User user = new User();
		HttpSession httpSession = request.getSession();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("password");

		// 是不是第一次 默认是
		boolean isfirst = true;
		// 如果cookies里没有叫userName的内容说明是第一次登陆。

		if (httpSession.getAttribute("userName") != null) {
			isfirst = false;
		}

		// 如果是第一次登陆，同时userName为空。说明没有登陆过
		if (isfirst && userName == null) {
			message = "未登陆";
		}
		// 如果不是第一次
		if (!isfirst) {

			if (userName == null) {
				userName = "";
			}
			if (userName.equals("")) {
				if (httpSession.getAttribute("userName").equals("")) {
					message = "未登陆";
				} else {
					user.setUsername((String) httpSession.getAttribute("userName"));
					user.setPassword((String) httpSession.getAttribute("userPassword"));
				}
			} else {
				user.setUsername(userName);
				user.setPassword(userPassword);
			}

		}
		// 如果第一次登陆
		else {
			if (userName.equals("")) {
				message = "未登陆";
			} else {
				user.setUsername(userName);
				user.setPassword(userPassword);
			}
		}

		if (doLoginServiceImpl.isUser(user)) {

			httpSession.setAttribute("userName", user.getUsername());
			httpSession.setAttribute("userPassword", user.getPassword());

			code = 200;
			result = true;

		} else {

			message = "用户名密码错误";
		}

		map.addAttribute("code", code);
		map.addAttribute("message", message);
		map.addAttribute("result", result);

		return "islogin";
	}

}
