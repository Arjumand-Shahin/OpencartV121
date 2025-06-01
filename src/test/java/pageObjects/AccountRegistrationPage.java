package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage {
	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement passwordConfirm;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agreeBtn;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement confirmationMessage;
	
	public void setFirstname(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String emal) {
		email.sendKeys(emal);
	}
	
	public void setTelephoneNo(String telephn) {
		telephone.sendKeys(telephn);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void confirmPassword(String pwd) {
		passwordConfirm.sendKeys(pwd);
	}
	
	public void agrdChkbox() {
		agreeBtn.click();
	}
	
	public void clickContinueButton() {
		continueBtn.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (confirmationMessage.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
		
}
