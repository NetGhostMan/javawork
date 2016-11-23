package com.edison.seller.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.meta.Product;
import com.edison.seller.dao.SellerDao;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerDao sellerDao;
	
	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		int id = product.getId();
		String detail = product.getDetail();
		String title = product.getTitle();
		String image = product.getImage();
		long price = (long) (product.getPrice() * 100);
		String summary = product.getSummary();
		sellerDao.updateProduct(id, title, image, price, summary, detail);

	}
	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		String detail = product.getDetail();
		String title = product.getTitle();
		String image = product.getImage();
		long price = (long) (product.getPrice() * 100);
		String summary = product.getSummary();
		sellerDao.saveProduct(title, image, price, summary, detail);

	}
	@Override
	public Product getProductFromGet(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Product product = new Product();
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		product.setId(id);
		product.setTitle(request.getParameter("title"));
		product.setImage(request.getParameter("image"));
		product.setDetail(request.getParameter("detail"));
		String stringPrice = request.getParameter("price");
		double price = Double.parseDouble(stringPrice);
		product.setPrice(price);
		product.setSummary(request.getParameter("summary"));
		return product;
	}

}
