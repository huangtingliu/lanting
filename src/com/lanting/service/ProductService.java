package com.lanting.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanting.dao.ProductDao;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	
	public Map<String,Object> list(Map<String,Object> param){
		List<Map<String, Object>> list = productDao.list(param);
		int total = productDao.count(param);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("list", list);
		result.put("total", total);
		return result;
	}
}
