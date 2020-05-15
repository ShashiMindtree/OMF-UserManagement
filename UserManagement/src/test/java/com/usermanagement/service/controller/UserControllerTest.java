
package com.usermanagement.service.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.usermanagement.service.entity.User;
import com.usermanagement.service.service.UserService;
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	private UserController userController;

	@Mock
	private UserService userService;
	
	@Test
	public void testSave() {
		User user = build();
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userService.addUser(user)).thenReturn(user);
		ResponseEntity<User> save = userController.save(user);
		assertNotNull(save);
	}
	
	@Test
	public void testUpdate() {
		User user = build();
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userService.updateUser(user)).thenReturn(user);
		ResponseEntity<User> save = userController.update(user);
		assertNotNull(save);
	}
	
	@Test
	public void testGetById() {
		User user = build();
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userService.findById(user.getId())).thenReturn(user);
		User byId = userController.getById(user.getId());
		assertNotNull(byId);
	}
	
	@Test
	public void testGetAll() {
		List<User> users = new ArrayList<>();
		User user = build();
		users.add(user);
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userService.findAll()).thenReturn(users);
		List<User> ListUsers = userController.getAll();
		assertNotNull(ListUsers);
	}
	
	private User build() {
		User user = new User();
		user.getId();
		user.setEmailId("emailId");
		user.setPassword("password");
		return user;
		
	}
	

}
