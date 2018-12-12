package com.ld.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtils {
	/**
	 * 获取连接，后期修改为获取配置文件
	 * @return
	 */
	public Connection getConnection() {
		Connection conn=null;
		try {
			Properties p=new Properties();
			//此方法为读取配置文件，maven项目暂需查询
//			ResourceBundle resource=ResourceBundle.getBundle("/main/resources/jdbc.properties");
//			String driver=resource.getString("jdbc.driverClassname");
//			System.out.println("driver:"+driver);
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_base?useUnicode=true&characterEncoding=UTF-8", "root", "");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
