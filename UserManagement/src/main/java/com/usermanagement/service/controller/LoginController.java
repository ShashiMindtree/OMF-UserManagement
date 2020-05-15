package com.usermanagement.service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.service.entity.LogIn;
import com.usermanagement.service.service.LogInService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author M1055705
 *
 */
@RestController
@RequestMapping(value = "/logIn/v1")
@Api(value = "LoginController", description = "LogIn REST Apis")
public class LoginController {

	@Autowired
	private LogInService logInService;

	@ApiOperation(value = "login validate ", response = LogIn.class, tags = "validate")
	@PostMapping(value = "/login")
	public boolean logIn(@Valid @RequestBody LogIn logIn) {
		boolean isValid = false;
		try {
			boolean validateLogin = logInService.validateLogin(logIn);
			isValid = validateLogin ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;

	}

}
