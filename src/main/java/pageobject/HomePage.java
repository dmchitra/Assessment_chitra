package pageobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdrivermanager.WebDriverUtility;


public class HomePage extends WebDriverUtility{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	final String pageTitle = "TESTSCRIPTDEMO – Automation Practice";
	
	
	@FindBy(xpath="//div[@class = 'header-cart']/..//div[@class = 'header-wishlist']//a")
	private WebElement lnkWishList;
			
	@FindBy(xpath="//a[text()='Add to cart']//parent::li//span[text()='Add to wishlist']")
	//@FindBy(xpath="//span[text()='Add to wishlist']")
	List<WebElement> allElements;
	

	/**
	 * Method to wait for page to load and verify the HomePage title
	 */
	public void verifyUserOnHomePage() {
		waitUntilPageLoad();
		Assert.assertEquals(pageTitle, driver.getTitle());
	}

	/**
	 * Method to click on the wishlist icon
	 */
	public void selectWishList() {
		clickElement(lnkWishList);
		waitUntilPageLoad();
		Assert.assertEquals("Wishlist – TESTSCRIPTDEMO", driver.getTitle());
		
	}

	/**
	 * Method to click on the add to cart button
	 * @throws InterruptedException 
	 */
	public void addproductstocart(String stritem) throws InterruptedException
	{		
		WebElement ele = driver.findElement(By.xpath("(//h2[text()='"+stritem+"']/../..//span[text()='Add to wishlist'])[1]"));			
		clickElement(ele);
		Thread.sleep(4000);	//can be avoided and should be removed
				
	}
	
	
}
