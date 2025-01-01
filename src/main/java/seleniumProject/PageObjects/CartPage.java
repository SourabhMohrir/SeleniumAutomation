package seleniumProject.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
    WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']//h3")
	List<WebElement> cartItems;
	
	@FindBy(xpath="//li[@class='totalRow']//button[@class='btn btn-primary']")
	WebElement checkoutBtn;
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartItems.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckOut() {
		checkoutBtn.click();
		CheckoutPage cp = new CheckoutPage(driver);
		return cp;
	}
	

	

}
