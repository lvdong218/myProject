package com.ld.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class StartUpHttpServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("开机启动HttpServlet");
	}
}
