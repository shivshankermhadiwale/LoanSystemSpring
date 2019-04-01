package com.dench.dao;

import com.dench.entity.UserCredential;

public interface AuthDao {
	public UserCredential findByUserName(String userName);
	public UserCredential saveUserCredential(UserCredential usercredential);
}
