package com.edison.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.login.dao.LoginDao;
import com.edison.meta.User;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public void doLogout() {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();

		User user = new User();
		if (httpSession.getAttribute("userName") != null) {

			user.setUsername((String) httpSession.getAttribute("userName"));
			System.out.println(user.getUsername());

			if (user.getUsername() != null) {
				user.setUsertype(loginDao.getUsertype(user.getUsername()));
			}
			return user;
		} else {
			return null;
		}
	}

}
