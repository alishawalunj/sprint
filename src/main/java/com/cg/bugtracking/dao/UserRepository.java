package com.cg.bugtracking.dao;

import javax.persistence.EntityManager;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.bugtracking.util.*;

import com.cg.bugtracking.bean.User;
import com.cg.exceptions.*;

public class UserRepository implements IUserRepository {
	/**
	 * @author dell
	 * 
	 **/


	private EntityManager entitymanager;

	// Constructor
	public UserRepository() {
		entitymanager = BugtrackingUtil.getEntityManager();
	}

	/**
	 * This method is used to Persist the object of type user in the database.
	 * 
	 * @return user This Method returns the user object which was stored in the
	 *         database.
	 * @throws This method throws PersistException.
	 */
	@Override
	public User createUser(User user) throws PersistException {
		try {
			entitymanager.persist(user);
			System.out.println("User Created");
		} catch (Exception e) {
			throw new PersistException("Could not Persist ");
		}

		return user;
	}

	/**
	 * This method is used to login into the Database entry using the Id and
	 * Password of the User.
	 * 
	 * @param logged_user is used to point to current logged in User
	 * @param uid finds the user from the User table
	 * @Query query is used to query the database and retrieve the values of User
	 * @return logged_user return the user that has logged into the system
	 * @throws This method throws LoginException and Exception.
	 */
	@Override
	public User login(User user) throws LoginException {
		User uid = entitymanager.find(User.class, user.getUserId());

		User logged_user = null;
		try {
			if (uid == null) {
				throw new LoginException("User not Registered");
			}
			Query query = entitymanager.createQuery("from User u WHERE u.userId=?1 AND u.password=?2");
			query.setParameter(1, user.getUserId());
			query.setParameter(2, user.getPassword());
			user = (User) query.getSingleResult();
			logged_user = entitymanager.find(User.class, user.getUserId());
			if (logged_user != null) {
				logged_user.setStatus(1);
				System.out.println("Login Successful!!");
			}
		} catch (Exception e) {
			throw new LoginException(e.getMessage());
		}

		return logged_user;

	}

	/**
	 * This method is used to logout from the database.
	 * 
	 * @param logged_user is used to point to current logged in User
	 * @param status is set to 0 when user successfully logs out
	 * @return user return the user that has logged out of the system
	 * @throws This method throws LoginException.
	 */
	@Override
	public User logout(User user) throws LogoutException {
		try {
			User logged_user = entitymanager.find(User.class, user.getUserId());

			logged_user.setStatus(0);
			System.out.println("Logout successfull !!");
		} catch (LogoutException e) {
			throw new LogoutException("Can't Logout..");
		}
		return user;
	}

	// method for beginning the transaction
	@Override
	public void beginTransaction() {
		entitymanager.getTransaction().begin();
	}

	// method for committing the transaction
	@Override
	public void commitTransaction() {
		entitymanager.getTransaction().commit();
	}

}
