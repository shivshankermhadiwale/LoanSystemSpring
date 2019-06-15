package com.hgapp.dao;

import com.hgapp.entity.UserCredential;
import com.hgapp.entity.UserRole;

public interface UserRoleDao {
	public UserRole getUserRoleById(UserCredential userid);
	public UserRole saveUserRole(UserRole userRole);

}
