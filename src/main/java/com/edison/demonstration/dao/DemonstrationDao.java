package com.edison.demonstration.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.edison.meta.Product;

@Repository
public interface DemonstrationDao {

	@Select("select * from content")
	public List<Product> getProducts();

}
