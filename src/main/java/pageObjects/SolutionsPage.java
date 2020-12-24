package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class holds the elements for Solutions Page.
 */
public class SolutionsPage {
	
	public WebDriver driver;	

	public SolutionsPage(WebDriver driver) {
		this.driver=driver;
	}	

	public WebElement viewAllLink() {
      return driver.findElement(By.xpath("//a[@class='view-all cta-button dg-cases-section__button']/div"));
   }
	
	public WebElement solutions() {
		return driver.findElement(By.xpath("//a[text()='View All']")); 
	}	
}