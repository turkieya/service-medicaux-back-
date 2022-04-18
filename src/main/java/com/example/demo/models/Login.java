package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Login {

	@Id
	  private Long id;
	  private String email;
	  private String password ; 
	  private String role;
	  private String token;
	public Login() {
		// TODO Auto-generated constructor stub
	}
	public Login(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

}
