package com.dench.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dench.entity.UserCredential;
public interface AuthRepositories extends JpaRepository<UserCredential, Long>{
	public UserCredential findByUserName(String userName);
}
