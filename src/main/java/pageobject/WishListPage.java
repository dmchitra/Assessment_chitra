package pageobject;



import java.util.*;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdrivermanager.WebDriverUtility;

public class WishListPage extends WebDriverUtility{

	public WishListPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[contains(@class,'wishlist_table')]/tbody//tr")
	private List<WebElement> tblWishlist;
	
	
	@FindBy(xpath="//div[@class='woocommerce-message']")
	private WebElement lblAddedtoCart;
	
	@FindBy(xpath="//div[@class='site-header container-fluid']//a[@title='Cart']")
	private WebElement lnkCart;
	    public void gotoCart() {	        
	        clickElement(lnkCart);
			waitUntilPageLoad();
	    }
	/**
	 * Method to log in into the application with given username and password
	 * @param userName User userName to log in
	 * @param passwrd password of the provided userName
	 */
	public void verifyNumberOfProductsInWishList(int noofitems) {
	 	 waitUntilPageLoad();
         int itemsinwishlist = tblWishlist.size();   
         Assert.assertEquals(itemsinwishlist,noofitems);         
         }
	
	 public Map.Entry<String, Double> findTheLowestPricedProduct() {
	        Map<String, Double> map = new HashMap();
	        for(int i = 1; i < tblWishlist.size(); i++){
	            WebElement currentRow = tblWishlist.get(i);
	            WebElement insElement;
	            String productId = currentRow.getAttribute("data-row-id");
	            try {
	                insElement = currentRow.findElement(By.tagName("ins"));	              
	                map.put(productId, Double.parseDouble(insElement.findElement(By.tagName("bdi")).getText().split("£")[1]));
	            } catch (Exception e) {
	                map.put(productId, Double.parseDouble(currentRow.findElement(By.tagName("bdi")).getText().split("£")[1]));
	            }
	        }
	        Optional<Map.Entry<String, Double>> lowestProductEntry = map.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue));
	        return lowestProductEntry.get();
	    }
	 
	 public void addLowestPricedProductToCart(Map.Entry<String, Double> theLowestPricedProduct) {
		 driver.findElement(By.xpath("//tr[@data-row-id='" + theLowestPricedProduct.getKey() + "']/td[@class='product-add-to-cart']/a")).click();
		 //Assert.assertTrue(verifyProductAddedToCart());
	    }
	 public boolean verifyProductAddedToCart() {
	        return lblAddedtoCart.isDisplayed();
	    }    
}
