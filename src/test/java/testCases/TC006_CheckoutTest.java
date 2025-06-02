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
			Thread.sleep(2000);
			cp.clickExistingAddressBillingDetails();
			Thread.sleep(2000);
			cp.clickContinueBillingBtn();
			Thread.sleep(2000);
			cp.clickContinueDeliveryBtn();
			Thread.sleep(2000);
			cp.clickDeliveryMethodContinue();
			Thread.sleep(2000);
			cp.clickAgreeChkbox();
			cp.clickPaymentMethodContinue();
			Thread.sleep(2000);
			cp.clickConfirmOrder();
			Thread.sleep(2000);
			String text=cp.verifyMessageHeading();
			Assert.assertEquals(text, "Your order has been placed!");
			
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("*******Finished TC006_CheckoutTest *********");
		
		
	}
	

}
