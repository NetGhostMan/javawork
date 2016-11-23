package com.edison.buyer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.buyer.dao.BuyerDao;
import com.edison.meta.Buy;
@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	BuyerDao buyerDao;
	@Override
	public List<Buy> getBuyList() {
		// TODO Auto-generated method stub
		List<Buy> buys = buyerDao.getBuys();
		for(int i = 0 ; i<buys.size();i++){
			double intPrice = buys.get(i).getBuyPrice();
			double price = intPrice/100;
			buys.get(i).setBuyPrice(price);
		}
		return buys;
	}

}
