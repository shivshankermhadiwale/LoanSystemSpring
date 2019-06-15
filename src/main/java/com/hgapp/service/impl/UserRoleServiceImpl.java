package com.hgapp.service.impl;

import org.springframework.stereotype.Service;

import com.hgapp.entity.UserCredential;
import com.hgapp.entity.UserRole;
import com.hgapp.service.DaoServicess;
import com.hgapp.service.UserRoleService;

@Service
public class UserRoleServiceImpl extends DaoServicess implements UserRoleService{

	@Override
	public UserRole getUserRoleById(UserCredential userid) {
		return this.getDaoManager().getUserRole().getUserRoleById(userid);
	}

}
