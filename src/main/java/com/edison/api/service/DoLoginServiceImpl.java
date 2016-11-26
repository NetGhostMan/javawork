package com.edison.api.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.api.dao.BuyDao;
import com.edison.api.dao.UserDao;
import com.edison.meta.Product;
import com.edison.meta.User;

@Service
public class DoLoginServiceImpl implements DoLoginService {

	@Autowired
	private UserDao userDao;
	@Autowired
	BuyDao buyDao;

	@Override
	public boolean isUser(User user) {
		// TODO Auto-generated method stub
		String userPassword = userDao.getPassword(user.getUsername());
		if (userPassword == null) {
			return false;
		} else if (!userPassword.equals(user.getPassword())) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean delete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String strId = request.getParameter("id");
		if (strId != "") {
			int id = Integer.parseInt(strId);
			userDao.delete(id);
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public void saveBuy(HttpServletRequest request,Product product) {
		// TODO Auto-generated method stub
		double doublePrice = product.getPrice();
		int price =(int) doublePrice * 100;
		HttpSession httpSession = request.getSession();
		String userName = (String)httpSession.getAttribute("userName");
		int userId = userDao.getId(userName);
		int productId = product.getId();
		long time = new Date().getTime();
		buyDao.saveBuy(userId,productId,price,time);
		
	}

}
