package com.cg.bugtracking.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BugtrackingUtil {
	public static EntityManager getEntityManager() {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("Bug-Tracking");
	EntityManager entitymanager=factory.createEntityManager();
	return entitymanager;
	}
}
