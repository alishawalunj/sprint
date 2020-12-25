package com.capgemini.BugTracking;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BugtrackingUtil {
	private static EntityManagerFactory factory;
	private static EntityManager entitymanager;
	
	static {
		factory = Persistence.createEntityManagerFactory("Bug-Tracking");
	}
	
	public static EntityManager getEntityManager() {
		if(entitymanager==null || !entitymanager.isOpen()) {
			entitymanager = factory.createEntityManager();
		}
		return entitymanager;
	}
	
}
