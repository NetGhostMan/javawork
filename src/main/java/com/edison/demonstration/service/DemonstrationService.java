package com.edison.demonstration.service;

import java.util.List;

import com.edison.meta.Buy;
import com.edison.meta.Product;

public interface ProductService {

	List<Product> getProducts();

	Product getProductAll();

	List<Buy> getBuyList();

}
