package com.edison.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.edison.meta.Buy;

public interface BuyerDao {

	@Select("select `title`,`icon`,content.price,`time` from `content`,`trx`")
	@Results({@Result(property = "image", column = "icon"),@Result(property = "buyPrice", column = "price"),@Result(property = "buyTime", column = "time")})
	List<Buy> getBuys();

}
