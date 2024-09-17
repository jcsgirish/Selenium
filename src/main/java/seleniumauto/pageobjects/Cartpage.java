package seleniumauto.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import seleniumauto.AbstractComponents.AbstractComponent;

public class Cartpage extends AbstractComponent{
	
	WebDriver driver;
	

    
	public Cartpage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy (xpath="//*[@class='cartSection']/h3")
   private List<WebElement> verifyitems;
    
    @FindBy (xpath="//button[text()='Checkout']")
    WebElement checked;
    

     
     

	
	public Boolean Cartpageverify (String productName) throws InterruptedException {
		Thread.sleep(1000);
		  
	   Boolean Match= verifyitems.stream().anyMatch(item->item.getText().equalsIgnoreCase(productName));
	   return(Match);
		
	}
	
	  
	  
	 public checkoutpage checkout() {
		 
		 checked.click();
		 
		 return new checkoutpage(driver);

		 
	 }
	
	
	
	


	
	
	



}
