package com.capgemini.BugTracking;
import com.cg.bugtracking.bean.User;
import com.cg.bugtracking.dao.*;
import com.cg.bugtracking.service.*;
import com.cg.bugtracking.util.*;

public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	IUserService service=new UserService();
    	User user1=new User();
    	
    	user1.setPassword("monday");
    	user1.setRole("admin");
    	service.createUser(user1);
    	
    	User user2=new User();
    	
    	user2.setPassword("tuesday");
    	user2.setRole("admin");
    	service.createUser(user2);
    	
    	User user3=new User();
    	
    	user3.setPassword("wednesday");
    	user3.setRole("employee");
    	service.createUser(user3);
    	
    	User user4=new User();
    	
    	user4.setPassword("thursday");
    	user4.setRole("employee");
    	service.createUser(user4);
    	
    	
   /* User newuser=new User();
    newuser.setUserId(45);
    newuser.setPassword("thursday");
    newuser.setRole("employee");
    service.login(newuser);*/
}
}
