package com.cg.bugtracking.service;

import com.cg.bugtracking.bean.*;


public interface IUserService {
	
	public User createUser(User user) ;

	public User login(User user);

	public User logout(User user);

}
