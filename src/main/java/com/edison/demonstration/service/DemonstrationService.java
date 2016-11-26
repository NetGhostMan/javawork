package com.edison.demonstration.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.edison.meta.Product;

public interface DemonstrationService {

	List<Product> getProductList();

	Product getProductAll(HttpServletRequest request);

}
