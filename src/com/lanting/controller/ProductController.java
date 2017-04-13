package com.lanting.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanting.service.ProductService;

/**
 * 产品控制类
 */
@RequestMapping(value="product")
@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;

	@RequestMapping(value="/list")
	@ResponseBody
	public List<Map<String,Object>> list(){
		
		return productService.list();
	}
}
