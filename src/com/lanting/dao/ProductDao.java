package com.lanting.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weimingfj.common.orm.DaoHelp;

@Component
public class ProductDao {

	@Autowired
	DaoHelp daoHelp;
	
	public List<Map<String,Object>> list(){
		
		List<Map<String, Object>> list = daoHelp.queryForList("select product_id,product_name,product_img,product_desc from product where is_del='N'", null);
		
		return list;
	}
}
