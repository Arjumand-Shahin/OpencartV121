package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{
	
	WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="(//table[@class='table table-bordered']//tbody//tr[4]//td[2])[2]")
	WebElement totalPrice;
	
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement chekout;
	
	
	
	public String totalProductPrice() {
		try {
			return totalPrice.getText();
		}catch(Exception e) {
			return "";
		}
		
	}
	
	public void clickChekout() {
		chekout.click();
	}

}
