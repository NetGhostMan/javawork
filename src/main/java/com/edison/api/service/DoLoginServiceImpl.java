package com.edison.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.api.dao.UserDao;
import com.edison.meta.User;

@Service
public class DoLoginServiceImpl implements DoLoginService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean isUser(User user) {
		// TODO Auto-generated method stub
		String userPassword = userDao.getPassword(user.getUsername());
		if(userPassword == null){
			return false;
		}else if(!userPassword.equals(user.getPassword())){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public int getUsertype() {
		// TODO Auto-generated method stub
		return 1;
	}

}
