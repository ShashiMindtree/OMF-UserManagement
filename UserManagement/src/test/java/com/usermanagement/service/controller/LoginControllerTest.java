package com.usermanagement.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.usermanagement.service.entity.LogIn;
import com.usermanagement.service.service.LogInService;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	
	@InjectMocks
	private LoginController loginController;

	@Mock
	private LogInService logInService;

	@Test
	public void testLogIn() {
		LogIn login = new LogIn();
		login.setPassword("password");
		login.setUserName("userName");
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(logInService.validateLogin(login)).thenReturn(true);
		Boolean valid = loginController.logIn(login);
		assertEquals(valid, true);
	}
}