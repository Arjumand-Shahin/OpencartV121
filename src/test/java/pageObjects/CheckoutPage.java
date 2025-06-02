package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailBox;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordBox;
	
	@FindBy(xpath="//input[@id='button-login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@value='existing']")
	WebElement existingAddressBillingDetails;
	
	@FindBy(xpath="//input[@id='button-payment-address']")
	WebElement continueBillingBtn;
	
	@FindBy(xpath="input[value='existing'][name='shipping_address']")
	WebElement existingAddressDeliveryDetails;
	
	@FindBy(xpath="//input[@id='button-shipping-address']")
	WebElement continueDeliveryBtn;
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	WebElement deliveryMethodContinue;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agreeCheckbox;
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	WebElement paymentMethodContinue;
	
	@FindBy(xpath="//input[@id='button-confirm']")
	WebElement confirmOrderBtn;
	
	@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
	WebElement msgHeading;
	
	public void enterEmail(String email) {
		emailBox.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		passwordBox.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void clickExistingAddressBillingDetails() {
		existingAddressBillingDetails.click();
	}
	
	public void clickContinueBillingBtn() {
		continueBillingBtn.click();
	}
	
	public void clickContinueDeliveryBtn() {
		continueDeliveryBtn.click();
	}
	
	public void clickDeliveryMethodContinue() {
		deliveryMethodContinue.click();
	}
	
	public void clickAgreeChkbox() {
		agreeCheckbox.click();
	}
	
	public void clickPaymentMethodContinue() {
		paymentMethodContinue.click();
	}
	
	public void clickConfirmOrder() {
		confirmOrderBtn.click();
	}

	public String verifyMessageHeading() {
		try {
			return msgHeading.getText();
		}catch(Exception e) {
			return "";
		}
		
	}
	
}
