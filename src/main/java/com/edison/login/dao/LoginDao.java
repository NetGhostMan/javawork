package com.edison.login.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {

	@Select("select usertype from person where userName = #{username}")
	public int getUsertype(String username);

}
