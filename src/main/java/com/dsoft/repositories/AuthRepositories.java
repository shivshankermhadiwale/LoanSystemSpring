package com.dsoft.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dsoft.entity.UserCredential;
public interface AuthRepositories extends JpaRepository<UserCredential, Long>{
	public UserCredential findByUserName(String userName);
}
