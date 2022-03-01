package pageobject;



import java.util.*;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdrivermanager.WebDriverUtility;

public class CartPage extends WebDriverUtility{

	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//table[contains(@class,'shop_table')]/tbody/tr")
	private List<WebElement> tblItemsinCart;
	
	    
	    public String getItemFromCart() {	        
	        WebElement firstRow = tblItemsinCart.get(1);
	        return firstRow.findElement(By.xpath("//td[@class='product-remove']/a")).getAttribute("data-product_id");
	    }
}
