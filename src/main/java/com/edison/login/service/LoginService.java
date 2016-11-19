package com.edison.login.service;

import javax.servlet.http.HttpServletRequest;

import com.edison.meta.User;

public interface LoginService {

	public void doLogout();


	public User getUser(HttpServletRequest request);

}
