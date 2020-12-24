package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class holds the elements for Home Page.
 */
public class LandingPage {
	
	public WebDriver driver;	

	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}	

	public WebElement clickOnTwitter() {
      return driver.findElement(By.xpath("//div[@class='footer__share']/ul/li[1]/a"));
   }
	
	public WebElement clickOnLinkedIn() {
        return driver.findElement(By.xpath("//div[@class='footer__share']/ul/li[2]/a"));
    }
	
	public WebElement solutions() {
		return driver.findElement(By.xpath("//a[text()='Solutions']")); 
	}
	
	public WebElement aboutUs() {
		return driver.findElement(By.xpath("//a[text()='About']")); 
	}
	
	public WebElement locations() {
		return driver.findElement(By.xpath("//a[text()='Locations']")); 
	}	
}