package com.dsoft.controller;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsoft.dto.AuthDetailsDto;

@RestController
@RequestMapping("/authontication")
public class AuthController extends ControllerManager {
	private final Logger logger = LogManager.getLogger(AuthController.class);
	
	@GetMapping("/check-username/{userName}")
	public ResponseEntity<?> checkUserName(@PathVariable String userName) throws JSONException {
		logger.info(":Checking userName =>" + userName);
		if (userName==null||userName.isEmpty()) {
			throw new NullPointerException("please enter username");
			}
			return ResponseEntity.ok(this.getServiceManager().getAuthService().authUserName(userName));
	}

	@PostMapping("/check-password")
	public ResponseEntity<?> checkPassword(@RequestBody @Valid AuthDetailsDto authDetails, Errors error) throws JSONException {
		logger.info(":Checking password =>" + authDetails.getUserName() + " " + authDetails.getPassword());
		if (error.hasErrors())
			return ResponseEntity.ok(
					error.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
			return ResponseEntity.ok(this.getServiceManager().getAuthService().authPassaword(authDetails));
	}
}
