package com.edison.login.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {

	@Select("select usertype from `person` where userName = #{username}")
	public int getUsertype(String username);

	@Insert("insert into `content`(`price`,`title`,`icon`,`abstract`,`text`)values (#{price},#{title},#{image},#{summary},#{detail})")
	public void saveProduct(@Param("title")String title,@Param("image") String image, @Param("price") long price, @Param("summary")String summary,@Param("detail")String detail);

}
