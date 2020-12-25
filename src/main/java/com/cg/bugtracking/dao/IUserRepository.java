package com.cg.bugtracking.dao;

import com.cg.bugtracking.bean.*;
import com.cg.exceptions.*;


public interface IUserRepository {

	public User createUser(User user)throws PersistException;

	public User login(User user) throws LoginException;

	public User logout(User user) throws LogoutException;

	public void beginTransaction();

	public void commitTransaction();

}
