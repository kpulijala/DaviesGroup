package DaviesGroup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObjects.AboutUsPage;
import pageObjects.LandingPage;
import pageObjects.SolutionsPage;

/**
 * This class initiates the firefox browser and navigates to https://davies-group.com/
 * Click on ‘Solutions’ – Scroll down and click on ‘View All’  – look for ‘Fire investigation’ Case study and 
 * click on it – Validate if it’s navigated to right page and then captures the Results section from
 *  ‘Fire Investigation’ case study.
 */
public class SolutionsFireInvestigationTest  {
	
	public static WebDriver driver = null;
	public  Properties OR=null;
	
	@Test
	
	public void navigatingToFireInvestigation() throws IOException {		
		
		//providing location details of my properties file
		OR = new Properties();
		FileInputStream fis = new FileInputStream("C:\\KP\\DaviesGroup\\DaviesGroup\\src\\main\\java\\or.properties");	
		OR.load(fis);
		
		//initiating chrome browser	and navigating to https://davies-group.com/	
		System.setProperty("webdriver.gecko.driver", "C:\\KP\\Drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(OR.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

		
		LandingPage lp = new LandingPage(driver);
		SolutionsPage sp = new SolutionsPage(driver);
		AboutUsPage about = new AboutUsPage(driver);
		
		//By using Landing Page locators clicking on solutions and asserting its page title
		lp.solutions().click();
		Assert.assertEquals(driver.getTitle(), OR.getProperty("solutionsTitle"));	
		
		////By using Solutions Page locators clicking on view all link.		
		sp.viewAllLink().click();		
		about.searchForKeyWords().click();
		about.enterSearchWords().sendKeys(OR.getProperty("searchWord")); //searching for Fire Investigation
		about.fireInvestigation().click();
		Assert.assertEquals(driver.getTitle(), OR.getProperty("FireInvestigationTitle")); //asserting the title of the page
		
		// asserting the Results section heading
		Assert.assertEquals(OR.getProperty("FireInvestigationResults"),about.fireInvestigationResultsHeading().getText());
		driver.quit();
		}
}