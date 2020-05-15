package com.usermanagement.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.usermanagement.service.entity.LogIn;
import com.usermanagement.service.entity.User;
import com.usermanagement.service.service.UserService;


@RunWith(MockitoJUnitRunner.class)
public class LogInServiceImplTest  {

	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private LogInServiceImpl logInServiceImpl;
	
	@Test
	public void testGetChannelByChannelId() {
		LogIn logIn = new LogIn();
		logIn.setPassword("password");
		logIn.setUserName("userName");
		
		
		when(userService.findUserByEmailId(logIn.getUserName())).thenReturn(buildUser());
		Boolean valid = logInServiceImpl.validateLogin(logIn);
		assertEquals(valid,true);
	}
	
	@Test
	public void testGetChannelByChannelIdFailure() {
		LogIn logIn = new LogIn();
		logIn.setPassword("password");
		when(userService.findUserByEmailId(logIn.getUserName())).thenReturn(buildUser());
		Boolean valid = logInServiceImpl.validateLogin(logIn);
		assertEquals(valid,false);
	}
	
	private User buildUser() {
		User users = new User();
		users.setFirstName("firstName");
		users.setLastName("lastName");
		users.setPassword("password");
		users.setEmailId("emailId");
		
		return users;
		
	}
	

}
