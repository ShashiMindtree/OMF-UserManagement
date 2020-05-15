package com.usermanagement.service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.service.entity.Registration;
import com.usermanagement.service.service.RegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;

/**
 * @author M1055705
 *
 */
@RestController
@Api(value = "RegistrationController", description = "Registration REST Apis")
@RequestMapping(value = "/registration/v1")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;

	// add registration detail and save data in user table as well
	@ApiOperation(value = "save registration ", response = Registration.class, tags = "save")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
	@ApiResponse(code = 401, message = "not authorized!"), 
	@ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping(value = "/add")
	public ResponseEntity<Registration> save(@Valid @RequestBody Registration registration) {
		Registration registered = new Registration();
		try {
			registered = registrationService.save(registration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registered != null ? new ResponseEntity<Registration>(HttpStatus.OK)
				: new ResponseEntity<Registration>(HttpStatus.BAD_REQUEST);

	}

	// view registration detail by user id
	@ApiOperation(value = "get registration detail by email id", response = Registration.class, tags = "get")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
	@ApiResponse(code = 401, message = "not authorized!"), 
	@ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping(value = "/get/{emailId}")
	public Registration getById(@NonNull @PathVariable(name = "emailId") String emailId) {
		Registration findByEmailId = new Registration();
		try {
			findByEmailId = registrationService.findByEmailId(emailId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findByEmailId;

	}

}
