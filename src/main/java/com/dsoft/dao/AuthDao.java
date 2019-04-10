package com.dsoft.dao;

import com.dsoft.entity.UserCredential;

public interface AuthDao {
	public UserCredential findByUserName(String userName);
	public UserCredential saveUserCredential(UserCredential usercredential);
}
