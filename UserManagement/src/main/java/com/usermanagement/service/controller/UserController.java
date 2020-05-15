package com.usermanagement.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.service.entity.User;
import com.usermanagement.service.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author M1055705
 *
 */
@RestController
@Api(value = "UserController", description = "User REST Apis")

@RequestMapping(value = "/user/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "save user ", response = User.class, tags = "save")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
	@ApiResponse(code = 401, message = "not authorized!"), 
	@ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping(value = "/add")
	public ResponseEntity<User> save(@RequestBody User user) {
		User addUser = new User();
		try {
			addUser = userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addUser != null ? new ResponseEntity<User>(HttpStatus.OK)
				: new ResponseEntity<User>(HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "delete user ", response = User.class, tags = "delete")
	@DeleteMapping(value = "/delete/{userId}")
	public void delete(@PathVariable(name = "userId") int userId) {
		try {
			userService.deleteById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@ApiOperation(value = "update user ", response = User.class, tags = "update")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
	@ApiResponse(code = 401, message = "not authorized!"), 
	@ApiResponse(code = 404, message = "not found!!!") })

	@PutMapping(value = "/update")
	public ResponseEntity<User> update(@RequestBody User user) {
		User updateUser = new User();
		try {
			updateUser = userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateUser != null ? new ResponseEntity<User>(HttpStatus.OK)
				: new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "get user by id ", response = User.class, tags = "getUserById")
	@GetMapping(value = "/getuser/{userId}")
	public User getById(@PathVariable(name = "userId") int userId) {
		User user = new User();
		try {
			user = userService.findById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@GetMapping(value = "/getalluser")
	@ApiOperation(value = "get all user ", response = User.class, tags = "getAllUser")
	public List<User> getAll() {
		List<User> findAll = new ArrayList<>();
		try {
			findAll = userService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findAll;
	}

}
