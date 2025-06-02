package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

@Test
public class TC004_SearchProductTest extends BaseClass{
	
	public void verifySearchProduct() {
		
		logger.info("*******Starting TC004_SearchProductTest *********");
		try {
			HomePage hp=new HomePage(driver);
			hp.enterProductName(prop.getProperty("search"));
			hp.clickSearch();
			
			SearchPage sp=new SearchPage(driver);
			boolean status=sp.isProductExists();
			Assert.assertTrue(status);
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("*******Finished TC004_SearchProductTest *********");
		
	}
	
	

}
