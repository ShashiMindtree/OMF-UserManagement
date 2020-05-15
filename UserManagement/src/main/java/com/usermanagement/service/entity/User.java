package com.usermanagement.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author M1055705
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Users")
public class User {

	@Column(name = "id")
	@ApiModelProperty(notes = "id", name = "id", required = true, value = "test id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;

	 @Column(name = "first_name")
	@ApiModelProperty(notes = "firstName", name = "firstName", required = true, value = "test firstName")
	private String firstName;

	@Column(name = "last_name")
	@ApiModelProperty(notes = "lastName", name = "lastName", required = true, value = "test lastName")
	private String lastName;

	@Column(name = "email_id")
	@ApiModelProperty(notes = "emailId", name = "emailId", required = true, value = "test emailId")
	private String emailId;

	@Column(name = "password")
	@ApiModelProperty(notes = "password", name = "password", required = true, value = "test password")
	private String password;

	 @Column(name = "mobile_No")
	@ApiModelProperty(notes = "mobileNo", name = "mobileNo", required = true, value = "test mobileNo")
	private String mobileNo;
}
