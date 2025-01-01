package seleniumProject.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	 public OrderPage(WebDriver driver) {
		 super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
		@FindBy(css="tr td:nth-child(3)")
		List<WebElement> orderItems;
		
	public Boolean verifyOrder(String productName) {
		Boolean match = orderItems.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

}
