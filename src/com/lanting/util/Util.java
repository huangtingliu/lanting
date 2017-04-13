package com.lanting.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
//import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

//import net.sf.json.JSON;
//import com.weimingfj.common.utils.JsonUtil;

public class Util {


//	@SuppressWarnings({ "unchecked" })
//	public static String[] getIpAreaCode(String ipAddr){
//		Map<String,String> ipParameter=new HashMap<String, String>();
//		ipParameter.put("ip", ipAddr);
//		String jsonStr="";
//		String[] area=new String[2];
//		try {
//			jsonStr = HttpUtil.post(ipParameter, "http://ip.taobao.com/service/getIpInfo.php");
//			//jsonStr = HttpUtil.post(ipParameter, "http://gw.api.taobao.com/router/rest");
//			Map<String,Object> ipResultMap=JsonUtil.jsonToMapObject(jsonStr);
//			if("0.0".equals(ipResultMap.get("code").toString())){
//				Map<String,String> data=(Map<String,String>)ipResultMap.get("data");
//				if(!"-1".equals(data.get("county_id"))){
//					area[0]=data.get("county_id");
//					area[1]=data.get("region")+data.get("city")+data.get("county");
//					return area;
//				}
//				if(!"-1".equals(data.get("city_id"))){
//					area[0]=data.get("city_id");
//					area[1]=data.get("region")+data.get("city");
//					return area;
//				}
//				if(!"-1".equals(data.get("region_id"))){
//					area[0]=data.get("region_id");
//					area[1]=data.get("region");
//					return area;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return area;
//	}
//	public static String getIpArea(String ipAddr){
//		Map<String,String> ipParameter=new HashMap<String, String>();
//		ipParameter.put("ip", ipAddr);
//		ipParameter.put("format","json");
//		String area="";
//		String jsonStr;
//		try {
//			jsonStr = HttpUtil.post(ipParameter, "http://int.dpool.sina.com.cn/iplookup/iplookup.php");
//			//jsonStr = HttpUtil.post(ipParameter, "http://gw.api.taobao.com/router/rest");
//			//Map<String,Object> ipResultMap=JsonUtil.jsonToMapObject(jsonStr);
//				//Map<String,String> data=(Map<String,String>)ipResultMap.get("data");
//				area=jsonStr.substring(11, 13)+jsonStr.substring(14, 16);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return area;
//	}
	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if(ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1") || "192".equals(ip.substring(0, 3)) || "172".equals(ip.substring(0, 3))){  
                //根据网卡取本机配置的IP  
                InetAddress inet=null;  
                try {  
                    inet = InetAddress.getLocalHost();  
                } catch (UnknownHostException e) {  
                    e.printStackTrace();  
                }  
                ip= inet.getHostAddress();
                String reg = "(10|172|192)\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})";//正则表达�?=�? =、懒得做文字处理了�??
                Pattern p = Pattern.compile(reg);
                Matcher matcher = p.matcher(ip);
                if(matcher.find()){
                	ip = getDns();
                }
            }  
        }  
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
        if(ip!=null && ip.length()>15){ //"***.***.***.***".length() = 15  
            if(ip.indexOf(",")>0){  
            	ip = ip.substring(0,ip.indexOf(","));  
            }  
        }  
		
		return ip;
	}
	/**
	 * 
	 * 功能说明：获取DNS服务器地址
	 *<p>参数说明</p>
	 * @author huangtl
	 */
    @SuppressWarnings("unused")
	public   static   String   getDns()   {  
        String   s   =   "";  
        try   {  
                String   s1   =   "ipconfig   /all";  
                Process   process   =   Runtime.getRuntime().exec(s1);  
                BufferedReader   bufferedreader   =   new   BufferedReader(  
                                new   InputStreamReader(process.getInputStream()));  
                String   nextLine;  
                int num=0;
                for   (String   line   =   bufferedreader.readLine();   line   !=   null;   line   =   nextLine)   {  
                        nextLine   =   bufferedreader.readLine();  
                        if   (line.indexOf("DNS")   <=   0 )   {  
                                continue;  
                        } 
                        num++;
//                        if(num == 3){
                        if(line.indexOf("DNS")   >   0 && line.indexOf("服务�?")   >   0){
                        	s   =   line.substring(51-16);
                        	System.out.println(s.length());
                        	String regexString=".*(\\d{3}(\\.\\d{1,3}){3}).*";
                    		s=s.replaceAll(regexString,"$1");
                            break;  
                        }
//                        int   i=0;
//                        	i   =   line.indexOf("")   +   36;  
                        
                }  

                bufferedreader.close();  
                process.waitFor();  
        }   catch   (Exception   exception)   {  
                s   =   "";  
        }  
        return   s.trim();  
}
    /**
     * 计算相差月份
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static String getMonthDiff(Date dateStart,Date dateEnd){
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String startStr = sdf .format(dateStart).toString();
//        String endStr = sdf .format(dateEnd).toString();
    	
//    	long dayNumber = 0;
    	long DAY = 24L * 60L * 60L;
    	long month = DAY * 30L;
    	long between = (dateEnd.getTime()-dateStart.getTime())/1000; //得到�?
    	long result = between / month;
    	
    	return String.valueOf(result);
    }

}
