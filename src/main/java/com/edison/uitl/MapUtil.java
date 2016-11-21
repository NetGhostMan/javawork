package com.edison.uitl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.edison.meta.User;

@Component
public class MapUtil {
	
	@Autowired
	public UtilDao utilDao;
	
	public ModelMap AfterAddUserMap(HttpServletRequest request,ModelMap map){
		
		User user = getUserFromGet(request);
		map.addAttribute("user",user);
		return map;
	}
	public User getUserFromGet(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();

		User user = new User();
		if (httpSession.getAttribute("userName") != null) {

			user.setUsername((String) httpSession.getAttribute("userName"));
			System.out.println(user.getUsername());

			if (user.getUsername() != null) {
				user.setUsertype(utilDao.getUsertype(user.getUsername()));
			}
			return user;
		} else {
			return null;
		}
	}
}
