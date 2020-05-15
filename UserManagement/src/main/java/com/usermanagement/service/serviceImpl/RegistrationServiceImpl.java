package com.usermanagement.service.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.service.dao.RegistrationServiceDao;
import com.usermanagement.service.dao.UserDao;
import com.usermanagement.service.entity.Registration;
import com.usermanagement.service.entity.User;
import com.usermanagement.service.service.RegistrationService;

/**
 * @author M1055705
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationServiceDao registrationServiceDao;

	@Autowired
	private UserDao userDao;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Registration save(Registration registration) {
		Registration findByEmailId = new Registration();
		Registration savedData = null;
		try {
			findByEmailId = registrationServiceDao.findByEmailId(registration.getEmailId());
			User user = new User();
			if (registration != null && findByEmailId == null) {
				user.setEmailId(registration.getEmailId());
				user.setFirstName(registration.getFirstName());
				user.setLastName(registration.getLastName());
				user.setMobileNo(registration.getMobileNo());
				user.setPassword(registration.getPassword());
				savedData = registrationServiceDao.save(registration);
				userDao.save(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return savedData;
	}

	@Override
	public Registration findById(int registrationId) {
		Registration registration  = new Registration();
		try {
			registration = registrationServiceDao.findById(registrationId).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registration;
	}

	@Override
	public Registration findByEmailId(String emailId) {
		Registration findByEmailId  = new Registration();
		try {
			findByEmailId = registrationServiceDao.findByEmailId(emailId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findByEmailId;
	}

}
