package com.hgapp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hgapp.entity.UserCredential;
public interface AuthRepositories extends JpaRepository<UserCredential, Long>{
	public UserCredential findByUserName(String userName);
}
