package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void verifyAccountRegistration() throws InterruptedException {

		logger.info("*******Starting TC001_AutomationRegistrationTest *********");
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link ");
			hp.clickRegister();
			logger.info("Clicked on Register Link ");

			Thread.sleep(5000);

			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			logger.info("Providing customer details...");
			arp.setFirstname(randomeString().toUpperCase());
			arp.setLastname(randomeString().toLowerCase());
			arp.setEmail(randomeString() + "@gmail.com");
			arp.setTelephoneNo(randomeNumber());

			String password = randomeAlphaNumeric();
			arp.setPassword(password);
			arp.confirmPassword(password);

			arp.agrdChkbox();
			arp.clickContinueButton();
			logger.info("Validating expected message...");
			String confirmMsg = arp.getConfirmationMsg();
			if(confirmMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
			
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("*******Finished TC001_AutomationRegistrationTest *********");
	}

}
