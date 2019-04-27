package com.hgapp.service;

import com.hgapp.dto.AuthDetailsDto;
import com.hgapp.entity.UserCredential;

public interface AuthSerivice {
	public AuthDetailsDto authUserName(String userName);
	public AuthDetailsDto  authPassaword(AuthDetailsDto authDetails);
}
