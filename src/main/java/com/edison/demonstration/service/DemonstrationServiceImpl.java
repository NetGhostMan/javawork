package com.edison.demonstration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.demonstration.dao.DemonstrationDao;
import com.edison.meta.Buy;
import com.edison.meta.Product;

@Service
public class ProductServicetestImpl implements ProductService {

	@Autowired
	public DemonstrationDao demonstrationDao;

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> products = demonstrationDao.getProducts();
		for (int i=0 ; i< products.size();i++){
			double price = products.get(i).getPrice() / 100;
			products.get(i).setPrice(price);
		}
		return products;
	}

	@Override
	public Product getProductAll() {
		// TODO Auto-generated method stub
		Product product1 = new Product();
		product1.setId(1);
		product1.setPrice(12);
		product1.setTitle("sdf");
		product1.setImage("sdf");
		product1.setIsBuy(true);
		product1.setIsSell(false);
		return product1;
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

}
