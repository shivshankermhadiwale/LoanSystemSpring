package com.hgapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgapp.dao.AuthDao;
import com.hgapp.entity.UserCredential;
import com.hgapp.repositories.AuthRepositories;

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
