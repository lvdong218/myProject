package com.ld.register.action;

import com.ld.filter.until.CheckUtils;
import com.ld.filter.until.MailUtils;
import com.ld.filter.until.RedisUtils;
import com.ld.register.bean.User;
import com.ld.register.service.RegisterService;
import com.ld.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	@RequestMapping("regiter")
	public void regiter(User user,HttpServletResponse response,HttpServletRequest request) {
//		String str=checkUserInfo(user,request.getSession().getAttribute("activateCode")!=null?request.getSession().getAttribute("activateCode").toString():"");
		RedisUtils u=new RedisUtils();
		String result = null;
		if(!u.exit(user.getEmail()+"activateCode")) {
			result="您的验证码已过期，请重新输入";
		}
		String str=u.getString(user.getEmail()+"activateCode");
		if(!user.getActivateCode().equals(str)) {
			JSONObject json=new JSONObject();
			json.put("flag", false);
			if(null==result) {
				result="输入验证码错误，请核对后再进行输入";
			}
			json.put("result", result);
			ResponseUtil.outputJson(request, response,json);
			return;
		}
		registerService.insert(user);
		JSONObject json=new JSONObject();
		json.put("flag", true);
		ResponseUtil.outputJson(request, response,json);
	}
	@RequestMapping("getActivateCode")
	public void getActivateCode(User user,HttpServletResponse response,HttpServletRequest request) throws Exception {
		String code=MailUtils.buildCode();
//		request.getSession().setAttribute("activateCode",code);
		RedisUtils u=new RedisUtils();
		u.setEx(user.getEmail()+"activateCode", 30,code);
		
//		u.expire("activateCode", 60);
		System.out.println(u.getString(user.getEmail()+"activateCode"));
		new MailUtils().validateMail(user,code);
//		MailUtils.sendActivateEmail(user,code);
//		JSONObject json=new JSONObject();
//		json.put("activateCode", code);
//		ResponseUtil.outputJson(request, response,json);
	}
	public String checkUserInfo(User user,String activateCode) {
//		if(!user.getActivateCode().equals(activateCode)) {
//			return "您输入的激活码有误，请重新输入";
//		}
		if(!user.getPassword().equals(user.getRefPassword())) {
			return "您两次输入的密码不一致，请重新输入";
		}
//		if(!CheckUtils.checkEmail(user.getEmail())) {
//			return "您输入的邮箱格式不正确，清重新输入";
//		}
		if(!CheckUtils.checkPhone(user.getPhone())) {
			return "您输入的手机号格式不正确，请重新输入";
		}
		return null;
	}
	
}
