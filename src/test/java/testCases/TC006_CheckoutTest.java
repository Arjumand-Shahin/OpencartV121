package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC006_CheckoutTest extends BaseClass {
	
	@Test
	public void verifyCheckout() {
		
		logger.info("*******Starting TC006_CheckoutTest *********");
		try {
			HomePage hp=new HomePage(driver);
			hp.enterProductName(prop.getProperty("search"));
			hp.clickSearch();
			
			SearchPage sp=new SearchPage(driver);
			sp.clickAddToCart();
			sp.enterDeliveryDate(prop.getProperty("date"));
			sp.enterQuantity("2");
			sp.clickAddToCart2();
			sp.clickShoppingCart();
			Thread.sleep(3000);
			ShoppingCartPage scp=new ShoppingCartPage(driver);
			scp.clickChekout();
			CheckoutPage cp=new CheckoutPage(driver);
			cp.enterEmail(prop.getProperty("emailAddress"));
			cp.enterPassword(prop.getProperty("password"));
			cp.clickLogin();
			String textVerify=cp.verifyMessageHeading();
			Assert.assertEquals(textVerify, "Checkout");
			
			
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("*******Finished TC006_CheckoutTest *********");
		
		
	}
	

}
