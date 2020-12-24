package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class holds the elements for About Us Page.
 */
public class AboutUsPage {
	
	public WebDriver driver;	

	public AboutUsPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement searchForKeyWords() {
      return driver.findElement(By.xpath("//span[@id='select2--container']"));
   }
	
	public WebElement enterSearchWords() {
	      return driver.findElement(By.xpath("//span[@class='select2-container select2-container--default select2-container--open']/span/span/input"));
	   }
	
	public WebElement fireInvestigation() {
	      return driver.findElement(By.xpath("//span[@class='select2-container select2-container--default select2-container--open']/span/span[2]/ul/li"));
	   }
	
	public WebElement fireInvestigationResultsHeading() {
	      return driver.findElement(By.xpath("//section[@class='case-single-desc']/div/div[1]/div/div/h2[2]"));
	   }	
}