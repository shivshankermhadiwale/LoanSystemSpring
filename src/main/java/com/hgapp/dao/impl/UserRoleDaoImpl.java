package com.hgapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgapp.dao.UserRoleDao;
import com.hgapp.entity.UserCredential;
import com.hgapp.entity.UserRole;
import com.hgapp.repositories.UserRoleRepo;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {
	@Autowired
	private UserRoleRepo userRole;

	@Override
	public UserRole getUserRoleById(UserCredential userId) {
		return userRole.findByUserId(userId);
	}

	@Override
	public UserRole saveUserRole(UserRole userRole) {
		return this.userRole.save(userRole);
	}

}
