package com.ld.filter.until;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang.StringUtils;
/**
 * 编码转换位utf-8的拦截器
 * @author lvdong
 *
 */
public class CharacterEncodingFilter implements Filter{
	private String characterEncoding;
	private boolean enabled;//是否启用
	public void init(FilterConfig filterConfig) throws ServletException {
		//获取配置好的参数
		characterEncoding=filterConfig.getInitParameter("characterEncoding");
		enabled="true".equals(filterConfig.getInitParameter("enabled"));
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(enabled&&StringUtils.isNotBlank(characterEncoding)) {
			request.setCharacterEncoding(characterEncoding);
			response.setCharacterEncoding(characterEncoding);
		}
	}

	public void destroy() {
		characterEncoding=null;
	}
	
}
