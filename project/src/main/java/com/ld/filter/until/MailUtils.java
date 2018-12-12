package com.ld.filter.until;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.ld.register.bean.User;
import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtils {
	private static final String FROM = "lvdong218@163.com";
	private static final String PORT="465";
	private static final String PASSSWORD="lvdong218310";
	public void validateMail(User user,String code) throws Exception{
		//创建Properties,并设置主机和认证
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		//开启SSL加密
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);
 
		//创建Authenticator内部类，重写getPasswordAuthentication()方法
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, "lvdong218310");
			}
		};
		//获取Session
		Session session = Session.getInstance(props, auth);
		
		//创建MimeMessage
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(FROM));
		msg.setRecipients(RecipientType.TO, user.getEmail());
		msg.setSentDate(new Date());
		msg.setSubject("网站向您发送验证信息>>请勿发送给其他人");
		msg.setContent("<h2>先生/女士您好</h2><div>您的激活码为<span style='color'>"+code+"</span></div>"
				,"text/html;charset=utf-8");
		//发送
		Transport.send(msg);
		System.out.println("发送成功");
	}
	
	public static void sendActivateEmail(User user,String code) {
		Session session=getSessionAli();
//		MimeMessage mm=new MimeMessage(session);
//		try {
//			mm.setSubject("网站向您发送验证信息，请勿发送给其他人");
//			mm.setSentDate(new Date());
//			//从哪个邮箱发送
//			mm.setFrom(new InternetAddress(FROM));
//			/**
//			 * RecipientType.TO||BCC||CC
//			 *     TO表示主要接收人
//			 *     BCC表示秘密抄送人
//			 *     CC表示抄送人
//			 * InternetAddress  接收者的邮箱地址
//			 */
//			mm.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));
//			/*message.setContent("<a target='_BLANK' href='"+GenerateLinkUtils.generateActivateLink(user)+"'>"+user.getUsername()+"先生/女士您好，请点击此链接激活账号"+GenerateLinkUtils.generateActivateLink(user)
//			+"</a>","text/html;charset=utf-8");*/
//			mm.setContent("<h2>先生/女士您好</h2><div>您的激活码为<span style='color'>"+code+"</span></div>"
//			,"text/html;charset=utf-8");
//			Transport.send(mm);
		try {
			// 创建默认的 MimeMessage 对象
	         MimeMessage message = new MimeMessage(session);
	      // Set From: 头部头字段
	         message.setFrom(new InternetAddress(FROM));
	      // Set To: 头部头字段
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(user.getEmail()));
	      // Set Subject: 头部头字段
	         message.setSubject("注册网站验证码");
	      // 设置消息体
//			Random rand=new Random();
//			String txt=String.valueOf(rand.nextInt(9000)+1000);
//			session.setAttribute("yanzhengma",txt);
			message.setText("你好!  欢迎注册论坛网。验证码为:"+code);
			Transport.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//设置发送邮箱
	public static Session getSession() {
		Properties prop=new Properties();
		//指定发送邮箱的邮箱协议
		prop.setProperty("mail.transport.protocol", "smtp");
		//指定smtp服务器
		prop.setProperty("mail.smtp.host", "smtp.163.com");
		//smtp是发信邮件服务器，端口25
		prop.setProperty("mail.smtp.port", "25");
		//是否需要smtp验证
		prop.setProperty("mail.smtp.auth", "true");
		Session session=Session.getInstance(prop,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM,"lvdong218310");
			}
		});
		return session;
	}
	
	
	/**
	 * 由于阿里云禁用25端口所以启动465端口，并进行代码修改
	 * @return
	 */
	public static Session getSessionAli() {
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.smtp.host", "smtp.163.com");
		javaMailProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		javaMailProperties.setProperty("mail.smtp.socketFactory.port", "465");
		javaMailProperties.setProperty("mail.smtp.port", "465");
		Session session=Session.getInstance(javaMailProperties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM,"lvdong218310");
			}
		});
		return session;
	}
	public static String buildCode() {
		String sources="0123456789";
		Random rand=new Random();
		StringBuffer sbf=new StringBuffer();
		for(int i=0;i<6;i++){
			sbf.append(sources.charAt(rand.nextInt(10)));
		}
		return sbf.toString();
	}
}
