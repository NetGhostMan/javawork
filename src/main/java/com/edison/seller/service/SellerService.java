package com.edison.seller.service;

import javax.servlet.http.HttpServletRequest;

import com.edison.meta.Product;

public interface SellerService {

	void saveProduct(Product product);

	Product getProductFromGet(HttpServletRequest request);

	void updateProduct(Product product);

}
