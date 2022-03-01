package webdrivermanager;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility extends DriverManager{

	final long waitTime =20;
	final long pageLogTime = 20;
	public void waitUntileElementVisible(WebElement element)
	{
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntileElementEnabled(WebElement element)
	{
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void waitUntilAllElementsVisible(List<WebElement> elements)
	{
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	
	public void enterValue(WebElement element,String value)
	{
		waitUntileElementVisible(element);
		waitUntileElementEnabled(element);
		element.clear();
		element.sendKeys(value);
	}
	
	
	public void clickElement(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
		waitUntileElementVisible(element);
		waitUntileElementEnabled(element);
		element.click();
	}
	
	
	public void waitUntilPageLoad()
	{
		ExpectedCondition<Boolean> pageReadyState = 
				new ExpectedCondition<Boolean>() {
					@Override
					public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
					}
			
				};
				(new WebDriverWait(driver, pageLogTime)).until(pageReadyState);
	}
	
	
}
