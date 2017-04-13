package com.lanting.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanting.dao.ProductDao;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	
	public List<Map<String,Object>> list(){
		
		return productDao.list();
	}
}
