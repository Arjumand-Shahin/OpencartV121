package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	//constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//locator
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement registerBtn;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginBtn;
	
	//Actions or methods
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickRegister() {
		registerBtn.click();
	}
	
	public void clickLogin() {
		loginBtn.click();
	}

}
