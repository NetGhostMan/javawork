package com.edison.api.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyDao {

	@Insert("insert into `trx` (`contentId`,`personId`,`price`,`time`)values(#{productId},#{userId},#{price},#{time}) ")
	void saveBuy(@Param("userId")int userId, @Param("productId")int productId, @Param("price")int price,@Param("time") long time);

}
