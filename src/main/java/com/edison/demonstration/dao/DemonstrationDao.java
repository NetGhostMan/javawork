package com.edison.demonstration.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.edison.meta.Product;

@Repository
public interface DemonstrationDao {

	@Select("select * from `content`")
	@Results({ @Result(property = "image", column = "icon"), @Result(property = "summary", column = "abstract"),
			@Result(property = "detail", column = "text") })

	public List<Product> getProductList();

	@Select("select * from content where id = #{id}")
	@Results({ @Result(property = "image", column = "icon"), @Result(property = "summary", column = "abstract"),
			@Result(property = "detail", column = "text") })
	public Product getProductAll(int id);

	@Update("update `content` set `title`=#{title},`icon`=#{image}, `price`=#{price},`abstract`=#{summary},`text`=#{detail} where `id` = #{id}")
	public void updateProduct(@Param("id") int id, @Param("title") String title, @Param("image") String image,
			@Param("price") long price, @Param("summary") String summary, @Param("detail") String detail);

	@Insert("insert into `content`(`price`,`title`,`icon`,`abstract`,`text`)values (#{price},#{title},#{image},#{summary},#{detail})")
	public void saveProduct(@Param("title") String title, @Param("image") String image, @Param("price") long price,
			@Param("summary") String summary, @Param("detail") String detail);

}
