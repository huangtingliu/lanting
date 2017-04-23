package com.lanting.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weimingfj.common.orm.DaoHelp;
import com.weimingfj.common.utils.MapUtils;

@Component
public class ProductDao {

	@Autowired
	DaoHelp daoHelp;
	
	public List<Map<String,Object>> list(Map<String,Object> param){
		
		List<Object> sqlParam= new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select img_id,img_name,img_path,img_desc,img_type from img where is_del='N' ");
		if(exists(param, "img_type")){
			sql.append(" and img_type = ? ");
			sqlParam.add(MapUtils.getString(param, "img_type"));
		}
		if(exists(param, "page") && exists(param, "page_num")){
			int page = MapUtils.getInt(param, "page");
			int pageNum = MapUtils.getInt(param, "page_num");
			int pageStart = (page-1)*pageNum;
			sql.append(" limit ?,?");
			sqlParam.add(pageStart);
			sqlParam.add(pageNum);
		}
		
		List<Map<String, Object>> list = daoHelp.queryForList(sql.toString(), sqlParam.toArray());
		
		return list;
	}
	
	public int count(Map<String,Object> param){
		
		List<Object> sqlParam= new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select count(1) from img where is_del='N' ");
		if(exists(param, "img_type")){
			sql.append(" and img_type = ? ");
			sqlParam.add(MapUtils.getString(param, "img_type"));
		}
		
		return daoHelp.queryForInteger(sql.toString(), sqlParam.toArray());
	}
	
	private boolean exists(Map<String,Object> param,String key){
		
		return param.containsKey(key) && !StringUtils.isEmpty(MapUtils.getString(param, key));
	}
}
