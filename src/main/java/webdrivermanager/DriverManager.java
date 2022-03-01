package webdrivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	public static WebDriver driver=null;
	
	
	/**
	 * Method to initialise the driver for given browser
	 * @param Browser Name of the browser to initialise e.g Chrome, Internet Explorer
	 * @return
	 */
	public static WebDriver iniialiseDriver(String Browser) {
		switch(Browser.toUpperCase())
		{
		case "CHROME" :
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		break;
		default:
			throw new RuntimeException("Please provide correct brwoser name or add case to handle the browser");
		}
		
		return driver;
	}
	
	
	/**
	 * Method to quiet all running webdriver sessions 
	 */
	public static void quiteDriver() {
		
		driver.quit();
		
	}
	
}
