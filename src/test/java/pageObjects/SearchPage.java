package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@title='HP LP3065']")
	WebElement mySearchedProduct;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//div[@class='input-group date']/input")
	WebElement deliveryDate;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement quantity;
	
	@FindBy(xpath="//button[text()='Add to Cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//span[text()='Shopping Cart']")
	WebElement shoppingCart;
	
	@FindBy(xpath="//table[@class='table table-bordered']//tr[4]//td[2]")
	WebElement totalPrice;
	
	public boolean isProductExists() {
		try {
			return mySearchedProduct.isDisplayed();
		}catch(Exception e) {
			return false;
		}
		
	}
	
	public void clickAddToCart() {
		addToCartBtn.click();
	}
	
	public void enterDeliveryDate(String date) {
		deliveryDate.clear();
		deliveryDate.sendKeys(date);
	}
	
	public void enterQuantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	public void clickAddToCart2() {
		addToCart.click();
	}
	
	public void clickShoppingCart() {
		shoppingCart.click();
	}
	

}
