package seleniumauto.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import seleniumauto.AbstractComponents.AbstractComponent;

public class orderspage extends AbstractComponent{
	
	WebDriver driver;
	

    
	public orderspage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy (css="tr td:nth-child(3)")
   private List<WebElement> orderednames;
    

     
    
	public Boolean ordereverify (String productName) throws InterruptedException {
		Thread.sleep(1000);
		  
	   Boolean Match= orderednames.stream().anyMatch(item->item.getText().equalsIgnoreCase(productName));
	   return(Match);
		
	}
	
	  
	  

	
	
	
	


	
	
	



}
