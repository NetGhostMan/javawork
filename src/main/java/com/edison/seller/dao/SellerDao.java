package com.edison.seller.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.edison.meta.Product;

@Repository
public interface SellerDao {

	@Select("select * from content where id = #{id}")
	public Product getProductAll(int id);

	@Update("update `content` set `title`=#{title},`icon`=#{image}, `price`=#{price},`abstract`=#{summary},`text`=#{detail} where `id` = #{id}")
	public void updateProduct(@Param("id") int id, @Param("title") String title, @Param("image") String image,
			@Param("price") long price, @Param("summary") String summary, @Param("detail") String detail);

	@Insert("insert into `content`(`price`,`title`,`icon`,`abstract`,`text`)values (#{price},#{title},#{image},#{summary},#{detail})")
	public void saveProduct(@Param("title") String title, @Param("image") String image, @Param("price") long price,
			@Param("summary") String summary, @Param("detail") String detail);

}
