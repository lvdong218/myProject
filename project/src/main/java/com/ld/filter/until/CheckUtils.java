package com.ld.filter.until;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 提供一些公共校验的方法
 * @author lvdong
 *
 */
public class CheckUtils {
	/**
	 * 校验邮箱
	 * @param email
	 * @return
	 */
	public static Boolean checkEmail(String email) {
		String regExp="^[a-zA-Z0-9-_]+@[a-zA-Z0-9]+\\.([a-zA-Z0-9]+|([a-zA-Z0-9]+\\.[a-zA-Z0-9]+))$";
		if(StringUtils.isBlank(email)) {
			return false;
		}
		Pattern p;
		Matcher ma;
		p=Pattern.compile(regExp);
		ma=p.matcher(email);
		return ma.matches();
	}
	/**
	 * 校验手机号码
	 * @param phone
	 * @return
	 */
	public static Boolean checkPhone(String phone) {
		String regExp="^[1][3|4|5|7|8]\\d{9}";
		if(StringUtils.isBlank(phone)) {
			return false;
		}
		Pattern p;
		Matcher m;
		p=Pattern.compile(regExp);
		m=p.matcher(phone);
		return m.matches();
	}
}
