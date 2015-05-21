package com.samsung.biz.user.vo;

import org.springframework.stereotype.Component;

import com.samsung.biz.common.CommonVO;
@Component("userVO")
public class UserVO extends CommonVO {

	private String id;
	private String password;
	private String name;
	private String role;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name
				+ ", role=" + role + ", getSearchCondition()="
				+ getSearchCondition() + ", getSearchKeyword()="
				+ getSearchKeyword() + "]";
	}
	
	
}
