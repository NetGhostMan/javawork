package com.edison.demonstration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edison.meta.Buy;
import com.edison.meta.Product;

@Service
public class ProductServicetestImpl implements ProductService {

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> Products = new ArrayList<Product>();
		Product product1 = new Product();
		product1.setId(1);
		product1.setPrice(12);
		product1.setTitle("sdf");
		product1.setImage("sdf");
		product1.setIsBuy(true);
		product1.setIsSell(false);

		Product product2 = new Product();
		product2.setId(1);
		product2.setPrice(12);
		product2.setTitle("sdf");
		product2.setIsBuy(true);
		product2.setImage("sdf");
		product2.setIsSell(false);


		Product product3 = new Product();
		product3.setId(1);
		product3.setPrice(12);
		product3.setTitle("sdf");
		product3.setIsBuy(true);
		product3.setImage("sdf");
		product3.setIsSell(false);


		Products.add(product1);
		Products.add(product2);
		Products.add(product3);

		return Products;
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
