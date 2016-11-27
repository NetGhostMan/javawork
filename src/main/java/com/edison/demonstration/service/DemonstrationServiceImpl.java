package com.edison.demonstration.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.demonstration.dao.DemonstrationDao;
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
	public Product getProductAll(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		Product product = demonstrationDao.getProductAll(id);
		long longPrice = (long) product.getPrice();
		double price = longPrice / 100;
		product.setPrice(price);
		return product;
	}

}
