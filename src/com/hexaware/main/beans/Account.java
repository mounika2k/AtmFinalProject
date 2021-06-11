package com.hexaware.main.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class Account {
	private Long id;
	
	private String name;
	
	private String pan;
	@NotNull(message="name is required")
	@NotBlank(message="name is required")
	private String email;
	
	private String address;
	@NotNull(message="name is required")
	@NotBlank(message="name is required")
	private String password;
	
	public Account(Long id, String name, String pan, String email, String address, String password) {
		super();
		this.id = id;
		this.name = name;
		this.pan = pan;
		this.email = email;
		this.address = address;
		this.password = password;
	}
	
	public Account() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", pan=" + pan + ", email=" + email + ", address=" + address
				+ ", password=" + password + "]";
	}
	
}
