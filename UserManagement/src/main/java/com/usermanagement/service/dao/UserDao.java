package com.usermanagement.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usermanagement.service.entity.User;

/**
 * @author M1055705
 *
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query(value = "SELECT * FROM Users WHERE email_id = ?1", nativeQuery = true)
	public User findUserByEmailId(String emailId);
}
