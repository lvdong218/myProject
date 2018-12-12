package com.ld.login.action;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ld.filter.until.Test;
import com.ld.login.Bean.User;
import com.ld.login.service.LoginService;
import com.ld.login.service.impl.LoginServiceImpl;
import com.ld.util.ResponseUtil;
import net.sf.json.JSONObject;

@Controller
/**
 * login的action
 * @author lvdong
 *
 */
public class LoginAction {
	@Autowired
	private LoginService loginService;
	@RequestMapping("/login.do")
	/**
	 * 校验登陆
	 * @param req
	 * @param resp
	 * @param user
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp,User user) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User loginUser =loginService.queryByInfo(user);
		User exitUser =loginService.queryByName(user);
		System.out.println("loginuser hashcode"+Objects.hashCode(user));
		ResponseUtil.outputJson(req, resp, loginResultJson(loginUser,exitUser,req));
	}
	/**
	 * 判断用于loginUser判断账号密码是否正确，exitUser用户判断是否存在输入的用户名
	 * @param loginUser
	 * @param exitUser
	 * @param req
	 * @return
	 */
	public JSONObject loginResultJson(User loginUser,User exitUser,HttpServletRequest req) {
		JSONObject json=new JSONObject();
		HttpSession session = req.getSession();
		if(loginUser!=null) {
			session.setAttribute("username",loginUser.getUsername() );
			session.setAttribute("password", loginUser.getPassword());
		}else if(exitUser!=null) {
			json.put("status", 1);
		}
		if(loginUser!=null) {
			json.put("loginUser", loginUser);
		}
		return json;
	}
	/**
	 * 判断文件夹是否存在不存在创建文件夹
	 * @param req
	 * @param resp
	 * @param user
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("mkdirs.do")
	public void createDir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Test.resolveZip("/usr/local/data.zip");
//		File file=new File("/home/wzhy/mlkfk");
		
//		if(!file.exists()&&!file.isDirectory()) {
//			file.mkdirs();
//		}
	}
}
