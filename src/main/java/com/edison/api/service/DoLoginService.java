package com.edison.api.service;

import javax.servlet.http.HttpServletRequest;

import com.edison.meta.Product;
import com.edison.meta.User;

public interface DoLoginService {

	public boolean isUser(User user);

	public boolean delete(HttpServletRequest request);

	public void saveBuy(HttpServletRequest request, Product product);

}
