package com.lanting.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品控制类
 */
@RequestMapping(value = "page")
@Controller
public class PageController {

	@RequestMapping(value="/{page}")
	public String product(@PathVariable String page,HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	@RequestMapping(value = "/{dir}/{page}")
	public String product(@PathVariable String dir, @PathVariable String page) {

		return dir + "/" + page;
	}
}
