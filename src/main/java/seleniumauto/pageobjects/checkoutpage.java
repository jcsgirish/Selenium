package seleniumauto.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumauto.AbstractComponents.AbstractComponent;

public class checkoutpage extends AbstractComponent{
     
	WebDriver driver;
	public checkoutpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (css=".form-group")
	WebElement country;
	
	@FindBy (xpath="//button[contains(@class,'ta-item')][2]")
	WebElement Selectcountry;
	
	
	@FindBy (css=".btnn")
	WebElement submit;
	
	By results =  By.cssSelector(".ta-results");
	
	public void selectcountry(String CountryName) {
		
		Actions item =  new Actions(driver);
		  item.sendKeys(country,CountryName).build().perform();
		  ToAppear(By.cssSelector(".ta-results"));
		  Selectcountry.click();
	
	}
	public confirmpage submitorder() {
		 submit.click();
		 return new confirmpage(driver);
	}
	
	  
	

	
	
}
