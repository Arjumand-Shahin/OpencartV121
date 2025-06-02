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
	
	@FindBy(xpath="//h1[text()='Checkout']")
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
	
	public String verifyMessageHeading() {
		try {
			return msgHeading.getText();
		}catch(Exception e) {
			return "";
		}
		
	}
	

}
