package com.hgapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hgapp.entity.UserCredential;
import com.hgapp.entity.UserRole;

public interface UserRoleRepo extends CrudRepository<UserRole, Long> {
	public UserRole findByUserId(UserCredential userId);

}
