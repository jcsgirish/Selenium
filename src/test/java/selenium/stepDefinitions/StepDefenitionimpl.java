package selenium.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium.Testcomponents.BaseTest;
import seleniumauto.pageobjects.Cartpage;
import seleniumauto.pageobjects.LandingPage;
import seleniumauto.pageobjects.Productpage;
import seleniumauto.pageobjects.checkoutpage;
import seleniumauto.pageobjects.confirmpage;

public class StepDefenitionimpl extends BaseTest {
	
	public LandingPage lpage;
	public Productpage Propage;
	public confirmpage confirmeditems ;
	
	
	
	@Given("I landed on Ecommerce page")
	
	public void IlandedonEcommercepage() throws IOException 

	{
		lpage = launchapplication();
	}
	
	@Given ( "^I Logged in with username(.+) and password(.+)$" )
	
	public void  ILoggedinwithusernameandpassword(String username , String password) {
	Propage = lpage.loginapplication(username,password);
		
	}
	
	
	 @When("^I add items(.+)from cart$")

	 public void  Iadditemsfromcart(String productName){
		 
		 List<WebElement> products = Propage.getProducts();
		Propage.addProducttocart(productName);
		 
	 }
	 
	 
	 @And  ("^Checkout(.+)and submit the order$")
	 
	 public void  AndCheckoutandsubmittheorder (String productName) throws InterruptedException{
		 Cartpage itemsverify = Propage.cartaddeditems();
		Boolean Match = itemsverify.Cartpageverify(productName);
		Assert.assertTrue(Match);
		checkoutpage checkedpage = itemsverify.checkout();
		checkedpage.selectcountry("india");
	     confirmeditems = checkedpage.submitorder();
		 
	 }
	 
	 @Then  ("^(.+)verified in the confirmation page$")
	 
	 public void  Thenverifiedintheconfirmationpage (String status) {
		 
		
			String Confirmation = confirmeditems.getConfirmation();
			Assert.assertTrue(Confirmation.equalsIgnoreCase(status));
			driver.close();
		 

	 }
	 

}
