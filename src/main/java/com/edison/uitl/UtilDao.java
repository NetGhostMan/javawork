package com.edison.uitl;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilDao {

	@Select("select usertype from `person` where userName = #{username}")
	public int getUsertype(String username);

}
