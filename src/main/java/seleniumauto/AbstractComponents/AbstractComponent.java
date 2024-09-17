package seleniumauto.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumauto.pageobjects.Cartpage;
import seleniumauto.pageobjects.orderspage;

public class AbstractComponent {
	

			
			WebDriver driver;
			
			public AbstractComponent(WebDriver driver) {
				// TODO Auto-generated constructor stub
				this.driver = driver;
				
			   PageFactory.initElements(driver, this);;	 
			}
			
			@FindBy
			(css="[routerlink*='cart']")
			WebElement CartClick;
			
			@FindBy
			(css="[routerlink*='myorder']")
			WebElement Clickonorders;
			
			
			
			
			

			public void ToAppear(By findBy) {
			 WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
			 w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
			 
			}
			
			public void Invisiblebuffer(WebElement ele) {
		      WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		      w.until(ExpectedConditions.invisibilityOf(ele));
			      
			}
			
			public Cartpage cartaddeditems() 
			{
				CartClick.click();
				 Cartpage itemsverify = new Cartpage(driver);
				 return itemsverify;
				
			}
			
			public orderspage gotoorderspage() 
			{
				Clickonorders.click();		
				 orderspage orderpage = new orderspage(driver);
				 return	 orderpage ;
			}
}


