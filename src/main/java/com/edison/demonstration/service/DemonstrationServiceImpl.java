package com.edison.demonstration.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.demonstration.dao.DemonstrationDao;
import com.edison.meta.Buy;
import com.edison.meta.Product;

@Service
public class DemonstrationServiceImpl implements DemonstrationService {

	@Autowired
	DemonstrationDao demonstrationDao;

	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		List<Product> products = demonstrationDao.getProductList();
		for (int i = 0; i < products.size(); i++) {
			double price = products.get(i).getPrice() / 100;
			products.get(i).setPrice(price);
		}
		return products;
	}

	

	@Override
	public List<Buy> getBuyList() {
		// TODO Auto-generated method stub
		List<Buy> buyList = new ArrayList<Buy>();
		Buy buy = new Buy();
		buy.setId(1);
		buy.setImage("sdf");
		buy.setTitle("sdf");
		buy.setBuyPrice(123);
		buy.setBuyTime(201212232312L);
		Buy buy1 = new Buy();
		buy.setId(2);
		buy.setImage("sdf");
		buy.setTitle("sdf");
		buy.setBuyPrice(123);
		buy.setBuyTime(201212232312L);
		buyList.add(buy1);
		buyList.add(buy);
		return buyList;
	}



	@Override
	public Product getProductAll(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		Product product = demonstrationDao.getProductAll(id);
		return product;
	}

	

	

	
}
