package com.ld.util;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
/**
 * 关于response和request的一些公用方法
 * @author lvdong
 *
 */
public class ResponseUtil {
	/**
	 * 将json通过response输出
	 * @param request
	 * @param response
	 * @param json
	 */
	public static void outputJson(HttpServletRequest request,HttpServletResponse response,JSONObject json) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		try {
			PrintWriter wr=response.getWriter();
			wr.append(json.toString());
			wr.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
