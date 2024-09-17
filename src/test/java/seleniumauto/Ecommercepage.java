package seleniumauto;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.Testcomponents.BaseTest;
import seleniumauto.pageobjects.Cartpage;
import seleniumauto.pageobjects.LandingPage;
import seleniumauto.pageobjects.Productpage;
import seleniumauto.pageobjects.checkoutpage;
import seleniumauto.pageobjects.confirmpage;
import seleniumauto.pageobjects.orderspage;

public class Ecommercepage extends BaseTest {
	String productName = "ZARA COAT 3";
		//making changes
		@Test (dataProvider = "getData" , groups = {"smoke"})
		
		public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException {

		Productpage Propage = lpage.loginapplication(input.get("email"),input.get("password"));
		List<WebElement> products = Propage.getProducts();
		Propage.addProducttocart(input.get("product"));
		Cartpage itemsverify = Propage.cartaddeditems();
		Boolean Match = itemsverify.Cartpageverify(input.get("product"));
		Assert.assertTrue(Match);
		checkoutpage checkedpage = itemsverify.checkout();
		checkedpage.selectcountry("india");
		confirmpage confirmeditems = checkedpage.submitorder();
		String Confirmation = confirmeditems.getConfirmation();
		Assert.assertTrue(Confirmation.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
		
		@Test (dependsOnMethods={"submitorder"})
		
		public void OrderHistorytest () throws InterruptedException {
			
			
			Productpage Propage = lpage.loginapplication("Thewizard000@gmail.com", "Thewizard0004@");
			 orderspage orderpage =	Propage.gotoorderspage();
			Assert.assertTrue(orderpage.ordereverify(productName));
			
		}
		
		
	
		@DataProvider
		
		public Object[][] getData() throws IOException {
			
			
			   List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\selenium\\data\\PurchaseOrder.json");
		        return new Object[][] { { data.get(0) }, { data.get(1) } };
		}
		
		

	
		

}
