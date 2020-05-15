package com.usermanagement.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.usermanagement.service.dao.RegistrationServiceDao;
import com.usermanagement.service.dao.UserDao;
import com.usermanagement.service.entity.Registration;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceImplTest {

	@Mock
	private RegistrationServiceDao registrationServiceDao;
	
	@Mock
	private UserDao userDao;
	
	@InjectMocks
	private RegistrationServiceImpl registrationServiceImpl;
	
	@Test
	public void testGetChannelByChannelId() {
		Registration buildData = buildData();
		when(registrationServiceDao.findByEmailId(buildData.getEmailId())).thenReturn(buildData);
		when(registrationServiceDao.save(buildData)).thenReturn(buildData);
		Registration save = registrationServiceImpl.save(buildData);
		assertEquals(save.getEmailId(),buildData.getEmailId());
	}
	
	@Test
	public void testFindById() {
		Registration buildData = buildData();
		when(registrationServiceDao.findById(1).get()).thenReturn(buildData);
		Registration registration = registrationServiceImpl.findById(1);
		assertEquals(registration.getEmailId(),buildData.getEmailId());
	}
	
	@Test
	public void testFindByEmailId() {
		Registration buildData = buildData();
		when(registrationServiceDao.findByEmailId(buildData.getEmailId())).thenReturn(buildData);
		Registration registration = registrationServiceImpl.findByEmailId(buildData.getEmailId());
		assertEquals(registration.getEmailId(),buildData.getEmailId());
	}
	
	private Registration buildData() {
		Registration registration = new Registration();
		registration.setEmailId("emailId");
		registration.setFirstName("firstName");
		registration.setIsCustomer("true");
		registration.setLastName("lastName");
		registration.setMobileNo("mobileNo");
		return registration;
		
	}
}
