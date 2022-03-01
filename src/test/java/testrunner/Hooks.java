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


/*

Scenario: User able to order T-shirt and verify order in order history page
Given I add "4" different products to my wishlist   
When i view my wishlist table

When i search for lowest price product
And i am able to add the lowest price item to my cart
Then i am able to verify the item in my cart

*/