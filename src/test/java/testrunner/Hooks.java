package testrunner;


import webdrivermanager.DriverManager;

import io.cucumber.java.After;


public class Hooks {
	
	@After
	public void testTearDown()
	{
		DriverManager.quiteDriver();
	}
	
}