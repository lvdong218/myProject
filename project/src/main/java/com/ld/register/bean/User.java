package com.ld.register.bean;

/**
 * user实体类
 * @author lvdong
 *
 */
public class User {
	private String id;
	private String name;
	private String password;
	private String refPassword;
	private String phone;
	private Integer sex;
	private String email;
	private String activateCode;
	
	public String getRefPassword() {
		return refPassword;
	}
	public void setRefPassword(String refPassword) {
		this.refPassword = refPassword;
	}
	public String getActivateCode() {
		return activateCode;
	}
	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
