package seleniumauto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumauto.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	

	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement Password;
	
	
	@FindBy(css="#login")
	WebElement submit;
	
	
	public Productpage  loginapplication(String email,String password) 
	{
		
		Email.sendKeys(email);
		Password.sendKeys(password);
		submit.click();
		Productpage Propage = new Productpage(driver);
		return Propage;
	}
	
	
	
	public void WebPage() 
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	


}
