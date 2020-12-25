package com.cg.bugtracking.service;

import com.cg.bugtracking.dao.*;

import com.cg.bugtracking.bean.User;
import com.cg.exceptions.*;

public class UserService implements IUserService {
	/**
	 * @author dell
	 * 
	 **/

	private static IUserRepository dao;

	// Constructor
	public UserService() {
		dao = new UserRepository();
	}

	/**
	 * This method is used to create the object of type User in the database.
	 * 
	 * @param user This is the only parameter to createUser Method which is of User
	 *             type.
	 * @param u is used as temporary variable to store current user
	 * @return u This Method returns the User object which was stored in the
	 *         database.
	 * @exception Persist is handled
	 */
	public User createUser(User user) {
		User u = null;
		dao.beginTransaction();
		try {
			if (user.getPassword() != null) {
				u = dao.createUser(user);
			}
		} catch (PersistException e) {
			e.printStackTrace();
		}
		dao.commitTransaction();

		return u;
	}

	/**
	 * This method is used to create the object of type loggedin_user in the
	 * database.
	 * 
	 * @param user This is the only parameter to pass the user which has to login of
	 *             User type.
	 * @param u    is used as temporary variable to store current user
	 * @return u This Method returns the User object which was stored in the
	 *         database.
	 * @exception Login is handled
	 */
	public User login(User user) {

		dao.beginTransaction();
		try {
			dao.login(user);
		} catch (LoginException e) {
			System.out.println("Login exception");
		}
		dao.commitTransaction();
		return user;
	}

	/**
	 * This method is used to create the object of type loggedout_user in the
	 * database.
	 * 
	 * @param user This is the only parameter to pass the user which has to logout
	 *             of User type.
	 * 
	 * @return user This Method returns the User object which was logged in the
	 *         database.
	 * @exception Logout is handled
	 */
	public User logout(User user) {

		dao.beginTransaction();
		try {
			dao.logout(user);
		} catch (LogoutException e) {
			System.out.println("Logout Exception");
		}
		dao.commitTransaction();

		return user;
	}

}
