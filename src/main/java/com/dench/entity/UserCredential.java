package com.dench.entity;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userCredential")
public class UserCredential {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long userId;
	@Column(name = "userName",length = 20,unique=true)
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "token")
	private Integer token;
	private LocalTime tokenTime;

	public Long getUserId() {
		return userId;
	}

	public LocalTime getTokenTime() {
		return tokenTime;
	}

	public void setTokenTime(LocalTime tokenTime) {
		this.tokenTime = tokenTime;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getToken() {
		return token;
	}

	public void setToken(Integer token) {
		this.token = token;
	}

}