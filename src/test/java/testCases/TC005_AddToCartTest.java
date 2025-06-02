package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC005_AddToCartTest extends BaseClass {
	
	@Test
	public void verifyAddToCart() {
		
		logger.info("*******Starting TC005_AddToCartTest *********");
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
			String priceText=scp.totalProductPrice();
			System.out.println("Price is : "+priceText);
			Assert.assertEquals(priceText, "$244.00");
			
			
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("*******Finished TC005_AddToCartTest *********");
	}

}
