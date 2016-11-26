package com.edison.api.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	@Select("select password from person where username = #{userName}")
	public String getPassword(String userName);

	@Delete("delete from `content` where id = #{id} ")
	public void delete(int id);

	@Select("select id from person where username = #{userName}")
	public int getId(String userName);


}
