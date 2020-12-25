package com.capgemini.BugTracking;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import com.cg.bugtracking.bean.*;
import com.cg.bugtracking.dao.*;
import com.cg.bugtracking.service.*;
import com.cg.exceptions.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {
	
	
	

	@Mock
	private IUserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	
	@Test
	public void createUserTest()
	{
		User user=new User();
		user.setPassword("sunday");
		user.setRole("admin");
		userService.createUser(user);
		
		User userObj=userService.createUser(user);
        
		
	
		
	}
	@Test(expected=PersistException.class)
	public void createUserTestThrowsLoginException()
	{
		User user=new User();
		user.setPassword("sunday");
		user.setRole("admin");
		
		when(userRepository.createUser(user)).thenThrow(PersistException.class);
		User userObj=userService.createUser(user);
        
      
	
		
	}
	
	@Test
	public void loginTest()
	{
		User user=new User();
		user.setUserId(150);
		user.setPassword("saturday");
		user.setRole("employee");
		
		when(userRepository.login(user)).thenReturn(user);
		
		User userObj=userService.login(user);
		
		
	}

	@Test(expected=LoginException.class)
	public void loginTestThrowsLoginException()
	{
		User user=new User();
		user.setUserId(150);
		user.setPassword("saturday");
		user.setRole("employee");
		
		User userObj=userService.login(user);
		
		doThrow(LoginException.class).when(userRepository).login(user);
		
	}

	@Test
	public void logoutTest()
	{
		User user=new User();
		user.setUserId(150);
		user.setPassword("saturday");
		user.setRole("employee");
		
		when(userRepository.logout(user)).thenReturn(user);
		
		User userObj=userService.logout(user);
		
		
		assertEquals("saturday",userObj.getPassword());
		
	}
	
	
	
	
	
	@Test(expected=LogoutException.class)
	public void logoutTestThrowsLogoutException()
	{
		User user=new User();
		user.setUserId(150);
		user.setPassword("saturday");
		user.setRole("employee");
		
		User userObj=userService.logout(user);
		
		
		doThrow(LogoutException.class).when(userRepository).logout(user);
		
	}
	
}
