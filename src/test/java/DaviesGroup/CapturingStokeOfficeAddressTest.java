package DaviesGroup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

/**
 * This is an incomplete test
 * This class initiates the chrome browser and navigates to https://davies-group.com/
 * Click on Menu ->  ‘About Us’. 
 * This is an incomplete Test
 */
public class CapturingStokeOfficeAddressTest {
	public static WebDriver driver = null;
	public  Properties OR=null;
	
	@Test	
	public void navigatingToFireInvestigation() throws IOException, InterruptedException {
		
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
		
		//By using Landing Page locators, and using Action class to hover on about us.		
		
		LandingPage lp = new LandingPage(driver);		
		Actions a = new Actions(driver);
		a.moveToElement(lp.aboutUs()).build().perform();		
	}		
}