package com.xutao.domain;
import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginLog implements Serializable{
	private int loginLogId;

	private int userId;

	private String ip;

	private Date loginDate;

	@Bean(name="user")
	public User buildUser(){
		User user = new User();
		user.setUserName("admin");
		user.setPassword("123456");
		return user;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public int getLoginLogId() {
		return loginLogId;
	}

	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
