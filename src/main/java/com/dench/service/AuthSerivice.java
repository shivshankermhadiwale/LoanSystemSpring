package com.dench.service;

import com.dench.dto.AuthDetailsDto;
import com.dench.entity.UserCredential;

public interface AuthSerivice {
	public AuthDetailsDto authUserName(String userName);
	public AuthDetailsDto  authPassaword(AuthDetailsDto authDetails);
}
