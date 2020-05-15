package com.usermanagement.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usermanagement.service.entity.Registration;

/**
 * @author M1055705
 *
 */
@Repository
public interface RegistrationServiceDao extends JpaRepository<Registration, Integer> {

	@Query(value = "SELECT * FROM Registration WHERE email_id = :emailId", nativeQuery = true)
	public Registration findByEmailId(@Param("emailId") String emailId);

}
