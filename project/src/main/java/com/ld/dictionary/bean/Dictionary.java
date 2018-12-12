package com.ld.dictionary.bean;

import java.util.Date;

public class Dictionary {
	//id
	private String id;
	//名称
	private String name;
	//value
	private String value;
	//状态
	private String status;
	//创建时间
	private Date createDate;
	//父节点id
	private String pId;
	//修改人
	private String modifyUser;
	//扩展字段
	private String ExtendedField;
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public String getExtendedField() {
		return ExtendedField;
	}
	public void setExtendedField(String extendedField) {
		ExtendedField = extendedField;
	}
	
}
