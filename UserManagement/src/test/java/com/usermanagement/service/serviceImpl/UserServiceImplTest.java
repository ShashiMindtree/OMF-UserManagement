package com.usermanagement.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import com.usermanagement.service.dao.UserDao;
import com.usermanagement.service.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@Mock
	private UserDao userDao;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	
	@Test
	public void testAddUser() {
		User buildData = buildUser();
		when(userDao.findUserByEmailId(buildData.getEmailId())).thenReturn(buildData);
		when(userDao.save(buildData)).thenReturn(buildData);
		User save = userServiceImpl.addUser(buildData);
		assertEquals(save.getEmailId(),buildData.getEmailId());
	}
	
	@Test
	public void testUpdateUser() {
		User buildData = buildUser();
		when(userDao.save(buildData)).thenReturn(buildData);
		User user = userServiceImpl.updateUser(buildData);
		assertEquals(user.getEmailId(),buildData.getEmailId());
	}
	
	@Test
	public void testFindById() {
		User buildData = buildUser();
		when(userDao.findById(1).get()).thenReturn(buildData);
		User findById = userServiceImpl.findById(1);
		assertEquals(findById.getEmailId(),buildData.getEmailId());
	}
	
	@Test
	public void testFindAll() {
		List<User> listData = new ArrayList<>();
		User buildData = buildUser();
		listData.add(buildData);
		when(userDao.findAll()).thenReturn(listData);
		List<User> findAll = userServiceImpl.findAll();
		Assert.notNull(findAll.get(0));
	}
	
	
	private User buildUser() {
		User user = new User();
		user.setEmailId("emailId");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setPassword("password");
		return user;
	}

}
 