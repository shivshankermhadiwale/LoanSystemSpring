package com.dsoft.service.impl;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.dsoft.dto.AuthDetailsDto;
import com.dsoft.entity.UserCredential;
import com.dsoft.exception.RecordNotFound;
import com.dsoft.service.AuthSerivice;
import com.dsoft.service.DaoServicess;
import com.dsoft.utils.CommanUtil;
import com.dsoft.utils.JwtTokenUtil;


@Service("AuthSericeImpl")
public class AuthServiceImpl extends DaoServicess implements AuthSerivice {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
	@Override
	public AuthDetailsDto authUserName(String userName) {
		UserCredential usercredential = null;
		usercredential = this.getDaoManager().getAuthDao().findByUserName(userName);
		if (usercredential == null)
			throw new RecordNotFound("user name not found");
		if (usercredential != null) {
			usercredential.setToken((new Random()).nextInt(900000) + 100000);
			usercredential.setTokenTime(LocalTime.now());
			this.getDaoManager().getAuthDao().saveUserCredential(usercredential);
			AuthDetailsDto authDto=new AuthDetailsDto();
			authDto.setUserName(userName);
			authDto.setToken(usercredential.getToken());
			return authDto;
		}
		return null;
	}

	@Override
	public AuthDetailsDto authPassaword(AuthDetailsDto authDetails) {
		UserCredential usercredential = null;
		AuthDetailsDto authDetailDto=null;
		usercredential = this.getDaoManager().getAuthDao().findByUserName(authDetails.getUserName());
		if (usercredential != null && usercredential.getPassword().equals(authDetails.getPassword())) {
			if (Duration.between(usercredential.getTokenTime(), LocalTime.now()).toMinutes() > 5) {
				 authDetailDto=new AuthDetailsDto();
				 authDetailDto.setStatus("Session time out");
				return authDetailDto;
			}else {
				authDetailDto=new AuthDetailsDto();
				authDetailDto.setStatus("Success");
				authDetailDto.setJwtToken("Bearer "+CommanUtil.createJwtToken(usercredential.getUserName(), usercredential.getPassword(), authenticationManager, jwtTokenUtil));
			//Call servlet context intilizer for initilizing 
				
			}
		}else {
			throw new RecordNotFound("user not found");
		}
		return authDetailDto;
	}

}
