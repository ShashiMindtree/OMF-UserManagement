package com.usermanagement.service.service;

import org.springframework.stereotype.Component;

import com.usermanagement.service.entity.Registration;
/**
 * @author M1055705
 *
 */
@Component
public interface RegistrationService {
	
	public Registration save(Registration registration);


	public Registration findById(int registrationId);
	
	public Registration findByEmailId(String  emailId);
	
}
