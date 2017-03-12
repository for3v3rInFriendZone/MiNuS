package com.minus.www.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "APPUSER")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "FIRSTNAME")
	private String firstname;

	@NotNull
	@Column(name = "LASTNAME")
	private String lastname;

	@NotNull
	@Column(name = "USERNAME", unique=true)
	private String username;

	@NotNull
	@Column(name = "USER_PASSWORD")
	private String password;

	@NotNull
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "PROFILE_IMAGE", length = 10485760)
	private String image;

	public User() {

	}

	public User(String firstname, String lastname, String username, String password, String email, String type,
			String image) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
		this.image = image;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}