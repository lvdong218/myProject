package com.ld.login.Bean;
/**
 * user实体类
 * @author lvdong
 *
 */
public class User {
	//id
	private Integer id;
	//登录名
	private String username;
	//密码
	private String password;
	//部门id
	private Integer deptId;
	//信息id
	private Integer infoId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	
}
