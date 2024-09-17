package seleniumauto.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumauto.AbstractComponents.AbstractComponent;

public class Productpage extends AbstractComponent{
	
	WebDriver driver;
	

	public Productpage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy
	(css=".mb-3")
	List <WebElement> products; 
	By addtoCart = By.cssSelector(".card-body button:last-of-type");
	By productslist = By.cssSelector(".mb-3");
	By Toastmessage=By.xpath("//div[text()=' Product Added To Cart ']");

	@FindBy
	(css=".ng-animating")
	WebElement Buffer;
	
	
	
	public List<WebElement> getProducts() {
		ToAppear(productslist);
		return products;
	}
	
	public WebElement  productname(String productName) {
		
	    WebElement prod =  getProducts().stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
	    return prod;
	}
	
	public void addProducttocart(String productName) {
		
	   WebElement prod = productname(productName);
       prod.findElement(addtoCart).click();
       ToAppear(Toastmessage);
       Invisiblebuffer(Buffer);
	}
	

	
	
	



}
