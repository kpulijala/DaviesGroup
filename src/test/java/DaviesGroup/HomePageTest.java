package DaviesGroup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObjects.LandingPage;

/**
 * This class initiates the chrome browser and navigates to https://davies-group.com/ and then Click's on 
 * ‘Twitter’ and ‘linkedIn’ Icon’s on the home page and Validates by their respective page title's.
 */
public class HomePageTest  {
	public static WebDriver driver = null;
	public  Properties OR=null;
	
	@Test	
	public void basePageNavigation() throws IOException {
		
		//providing location details of my properties file
		OR = new Properties();
		FileInputStream fis = new FileInputStream("C:\\KP\\DaviesGroup\\DaviesGroup\\src\\main\\java\\or.properties");	
		OR.load(fis);
		
		//initiating chrome browser	and navigating to https://davies-group.com/	
		System.setProperty("webdriver.chrome.driver","C:\\KP\\Drivers\\Drivers2020\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get(OR.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		
		// With the help of JavaScriptExecutor interface, scrolling the page by 5000 pixels through executeScript.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		
		//By using Landing Page locators, clicking on Twitter & LinkedIn Links respectively.
		LandingPage lp = new LandingPage(driver);	
	    lp.clickOnTwitter().click();	
	    lp.clickOnLinkedIn().click();
	    
	    //Handling the child windows and verifying their respective page titles
	    Set<String>ids =driver.getWindowHandles();
	    Iterator<String> it = ids.iterator();
	    String parentId=it.next();
	    String childID=it.next();
	    String childID1= it.next();
	    driver.switchTo().window(childID);
	    Assert.assertEquals(driver.getTitle(), OR.getProperty("linkedIn")); //verifying the page title of LinkedIn Page
	    driver.close();	
	    driver.switchTo().window(childID1);
	    Assert.assertEquals(driver.getTitle(), OR.getProperty("twitter")); //Verifying the page title of Twitter Page	
	    driver.close();
	    driver.quit();	
	}
}