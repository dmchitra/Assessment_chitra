package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import pageobject.HomePage;
import pageobject.WishListPage;
import webdrivermanager.DriverManager;

public class HomePageSteps extends DriverManager{
	WishListPage wishlistpage;
	HomePage homePage;

	@Given("User Launch the url {string}")
	public void user_launch_the_url(String applicationUrl) {
		DriverManager.iniialiseDriver("CHROME");
		driver.get(applicationUrl);
	}
	
	@Given("^I add (\\d+) different products to my wishlist")
	public void I_add_four_different_products_to_my_wishlist(int noofitems) throws InterruptedException{
		homePage = new HomePage();
		System.out.print("no of products =");	  
		homePage.verifyUserOnHomePage();
		homePage.addproductstocart(noofitems);	  
	}
	 
	@When("i view my wishlist table")
	public void i_view_my_wishlist_table() {
		  homePage.selectWishList();
	}
	
	@Then("i find total four selected items in my wishlist")
	public void i_find_total_four_selected_items_in_my_wishlist() {
		wishlistpage = new WishListPage();
		wishlistpage.verifyNumberOfProductsInWishList(3);	    
	}
	
	@When("i search for lowest price product")
	public void i_find_total_four_selected_items_in_mywishlist() {
	    
	}
	
	@And("i am able to add the lowest price item to my cart")
	public void i_am_able_to_add_the_lowest_price_item_to_mycart() {
	    
	}
	@Then("i am able to verify the item in my cart")
	public void i_am_able_to_verify_the_item_in_mycart() {
	   
	}
	  
}
