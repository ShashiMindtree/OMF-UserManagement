package com.usermanagement.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
@Table(name = "Registration")
public class Registration {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "first_name")
	private @NonNull String firstName;

	@Column(name = "last_name")
	private @NonNull String lastName;

	@Column(name = "email_id")
	private @NonNull String emailId;

	@Column(name = "password")
	private @NonNull String password;

	@Column(name = "mobile_No")
	private @NonNull String mobileNo;

	@Column(name = "is_customer")
	private @NonNull String isCustomer;

}
