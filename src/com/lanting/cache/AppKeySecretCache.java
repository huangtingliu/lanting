package com.lanting.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weimingfj.common.cache.ICacheService;
import com.weimingfj.common.dao.IJdbcDao;
import com.weimingfj.common.utils.MapUtils;

@Service("appKeySecretCache")
public class AppKeySecretCache implements ICacheService {
    
	@Autowired
	private IJdbcDao jdbcDao;

    @Override
    public Map<String, Map<String, Object>> getCacheContext() {
        Map<String, Map<String, Object>> pairs = new HashMap<String, Map<String, Object>>();
//        List<Map<String, Object>> appkeys = jdbcDao.queryForList(
//                " select appkey, appsecret, for_app, effect_date, if(effect_date >= now(), 'Y', 'N') is_effect "
//                + " from sys_app_key a where is_del = 'N' ",
//                new Object[]{ });
//        if (null != appkeys && !appkeys.isEmpty()) {
//            for (Map<String, Object> appkey : appkeys) {
//                pairs.put(MapUtils.getString(appkey, "APPKEY"), appkey);
//            }
//        }
        return pairs;
    }

    @Override
    public long getCacheLiveTime() {
        // TODO Auto-generated method stub
        return 0;
    }

}
