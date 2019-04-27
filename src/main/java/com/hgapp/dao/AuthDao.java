package com.hgapp.dao;

import com.hgapp.entity.UserCredential;

public interface AuthDao {
	public UserCredential findByUserName(String userName);
	public UserCredential saveUserCredential(UserCredential usercredential);
}
