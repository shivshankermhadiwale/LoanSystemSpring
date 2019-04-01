package com.dench.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dench.dao.AuthDao;
import com.dench.entity.UserCredential;
import com.dench.repositories.AuthRepositories;

@Repository("AuthDaoImpl")
public class AuthDaoImpl implements AuthDao {
	@Autowired
	AuthRepositories authrepo;
	@Override
	public UserCredential findByUserName(String userName) {
		return authrepo.findByUserName(userName);
	}
	
	public UserCredential saveUserCredential(UserCredential usercredential) {
		return authrepo.save(usercredential);
	}

}
