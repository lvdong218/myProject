package com.ld.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import net.sf.json.JSONObject;
/**
 * httpClient类的一些封装方法
 * @author lvdong
 *
 */
public class HttpClientUtils {
	//打印日志
	private static Logger log=Logger.getLogger(HttpClientUtils.class);
	/**
	 * 调用httpclient的get方法，返回值为json对象
	 * @param url
	 * @param params
	 * @return
	 */
	public static JSONObject doGet(String url,Map<String,Object> map) {
		if(StringUtils.isBlank(url)) {
			log.info("调用HttpClientUtils.doGet方法错误，没有url");
		}
		HttpClient client=new DefaultHttpClient();
		
		HttpGet httpGet=new HttpGet(appendUrl(url,map));
		try {
			HttpResponse response=client.execute(httpGet);
			if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
				String resultStr=EntityUtils.toString(response.getEntity());
				JSONObject json=JSONObject.fromObject(resultStr);
				return json;
			}
		} catch (Exception e) {
			log.error("执行get请求失败");
		}
		return null;
	}
	/**
	 * 调用httpclient的get方法，返回值为json对象
	 * @param url
	 * @return
	 */
	public static JSONObject doGet(String url) {
		if(StringUtils.isBlank(url)) {
			log.info("调用HttpClientUtils.doGet方法错误，没有url");
		}
		HttpClient client=new DefaultHttpClient();
		
		HttpGet httpGet=new HttpGet(url);
		try {
			HttpResponse response=client.execute(httpGet);
			if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
				String resultStr=EntityUtils.toString(response.getEntity());
				//将返回结果转换成为json对象
				JSONObject json=JSONObject.fromObject(resultStr);
				return json;
			}
		} catch (Exception e) {
			log.error("执行get请求失败");
		}
		return null;
	}
	/**
	 * 拼接url使用
	 * @param url
	 * @param map
	 * @return
	 */
	private static String appendUrl(String url,Map<String,Object> map) {
		
		StringBuffer tempUrl=new StringBuffer(url);
		tempUrl.append("?");
		for(String key:map.keySet()) {
			tempUrl.append("&").append(key).append("=").append(map.get(key));
		}
		System.out.println(tempUrl.toString());
		return tempUrl.toString();
	}
	
	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("ty", 1);
		map.put("w", "xxxx");
		doGet("www.baidu.com",map);
	}
}
