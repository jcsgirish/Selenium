package seleniumauto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import seleniumauto.AbstractComponents.AbstractComponent;

public class confirmpage extends AbstractComponent {

	WebDriver driver;
	public confirmpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy 
	(css=".hero-primary")
	WebElement Orderdone;
	
	   
	   
	   public String getConfirmation () {
		   return Orderdone.getText();
		   
	   }
	
}
