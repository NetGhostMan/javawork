package com.edison.demonstration.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.edison.meta.Buy;
import com.edison.meta.Product;

public interface DemonstrationService {

	List<Product> getProductList();

	List<Buy> getBuyList();

	Product getProductAll(HttpServletRequest request);

}
