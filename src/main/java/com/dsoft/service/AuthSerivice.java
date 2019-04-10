package com.dsoft.service;

import com.dsoft.dto.AuthDetailsDto;
import com.dsoft.entity.UserCredential;

public interface AuthSerivice {
	public AuthDetailsDto authUserName(String userName);
	public AuthDetailsDto  authPassaword(AuthDetailsDto authDetails);
}
