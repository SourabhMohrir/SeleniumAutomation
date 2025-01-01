package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumProject.PageObjects.CartPage;
import seleniumProject.PageObjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement cartBtn;
	@FindBy(xpath="//button[contains(@routerlink,'myorders')]")
	WebElement orderBtn;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElementToDisappear(WebElement webElement) {
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(webElement));
	}
	public CartPage clickOnCart() {
		cartBtn.click();
		 CartPage cp = new CartPage(driver);
		 return cp;
	}
	public OrderPage clickOnOrders() {
		cartBtn.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}

}
