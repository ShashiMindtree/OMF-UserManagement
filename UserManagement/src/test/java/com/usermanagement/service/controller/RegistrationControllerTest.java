
package com.usermanagement.service.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.usermanagement.service.entity.LogIn;
import com.usermanagement.service.entity.Registration;
import com.usermanagement.service.service.RegistrationService;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

	@InjectMocks
	private RegistrationController registrationController;

	@Mock
	private RegistrationService registrationService;
	

	@Test
	public void testSave() {
		Registration registration = build();
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(registrationService.save(registration)).thenReturn(registration);
		ResponseEntity<Registration> save = registrationController.save(registration);
		assertNotNull(save);
	}
	
	@Test
	public void testGetById() {
		Registration registration = build();
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(registrationService.findByEmailId(registration.getEmailId())).thenReturn(registration);
		Registration save = registrationController.getById(registration.getEmailId());
		assertNotNull(save);
	}
	
	
	private Registration build() {
		Registration registration = new Registration();
		registration.setEmailId("emailId");
		registration.setPassword("password");
		return registration;
	}

}
