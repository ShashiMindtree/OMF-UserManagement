package com.usermanagement.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.service.dao.UserDao;
import com.usermanagement.service.entity.User;
import com.usermanagement.service.service.UserService;

/**
 * @author M1055705
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserDao userDao;
	
    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public User addUser(User user) {
		User userData = new User();
		try {
			if (user != null && user.getEmailId() != null) {
				User findUserByEmailId = userDao.findUserByEmailId(user.getEmailId());
				if(findUserByEmailId == null ) {
					userData =userDao.save(user);
				}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userData;
	}

	@Override
	public User updateUser(User user) {
		User userData = new User();
		try {
			  userData = userDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userData;
	}

	@Override
	public void deleteById(int userId) {
		try {
		 userDao.deleteById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findById(int userId) {
		User userData = new User();
		try {
			userData = userDao.findById(userId).get();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return userData;
	}

	@Override
	public List<User> findAll() {
		List<User> findAll = new ArrayList<>();
		try {
			findAll = userDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findAll;
	}
	
	@Override
	public User findUserByEmailId(String emailId) {
		User findUserByEmailId = new User();
		try {
			findUserByEmailId = userDao.findUserByEmailId(emailId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findUserByEmailId;
	}

}
 