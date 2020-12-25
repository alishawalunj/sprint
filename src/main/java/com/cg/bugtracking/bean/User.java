package com.cg.bugtracking.bean;

import javax.persistence.*;



@Entity																	
@Table(name = "user_tbl")		//TABLE NAME										
				
public class User {
	
	@Id	//PRIMARY KEY
	@GeneratedValue(strategy=GenerationType.AUTO)	//AUTO GENERATION
	@Column(name = "user_id")											
	private long userId;
	@Column(name = "user_password")										
	private String password;
	@Column(name = "user_role")											
	private String role;
	//@Transient
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	//Constructor
	public User(long userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	

}
