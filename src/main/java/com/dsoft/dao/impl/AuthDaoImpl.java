package com.dsoft.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsoft.dao.AuthDao;
import com.dsoft.entity.UserCredential;
import com.dsoft.repositories.AuthRepositories;

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
