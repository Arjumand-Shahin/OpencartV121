package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="DataDriven") // getting data provider from different
																				// class
	public void verifyLoginDDT(String email, String pswd, String exp) {
		logger.info("*******Starting TC003_LoginTestDDT *********");
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmailAddress(email);
			lp.setPassword(pswd);
			lp.clickLogin();

			MyAccountPage mp = new MyAccountPage(driver);
			boolean targetPage = mp.isMyAccountPageExists();

			/*
			 * Valid Data - login success- test pass- logout 
			 * 				login failed- test failed
			 * 
			 * Invalid Data- login success- test fail- logout
			 * 				-login failed- test pass
			 */

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					mp.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					mp.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*******Finished TC003_LoginTestDDT *********");
	}
}
