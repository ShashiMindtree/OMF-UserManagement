package com.usermanagement.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.service.entity.LogIn;
import com.usermanagement.service.entity.User;
import com.usermanagement.service.service.LogInService;
import com.usermanagement.service.service.UserService;

/**
 * @author M1055705
 *
 */
@Service
public class LogInServiceImpl implements LogInService {

	@Autowired
	private UserService userService;

	@Override
	public boolean validateLogin(LogIn logIn) {
		User user = new User();
		try {
			user = userService.findUserByEmailId(logIn.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (user != null
				&& (logIn.getUserName().equals(user.getEmailId()) 
				|| logIn.getUserName().equals(user.getMobileNo()))
				&& logIn.getPassword().equals(user.getPassword())) ? true : false;
	}

}
