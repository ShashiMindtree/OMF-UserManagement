package com.usermanagement.service.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.usermanagement.service.entity.User;

/**
 * @author M1055705
 *
 */
@Component
public interface UserService {

	public User addUser(User user);

	public User updateUser(User user);

	public void deleteById(int userId);

	public User findById(int userId);

	public User findUserByEmailId(String emailId);

	public List<User> findAll();

}
