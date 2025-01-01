package seleniumProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='userEmail']")
	WebElement userId;
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement userPassword;
	@FindBy(xpath="//input[@id='login']")
	WebElement loginBtn;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMsg;
	By msg = By.cssSelector("[class*='flyInOut']");
	
	public ProductCatalog loginApplication(String email, String password) {
		userId.sendKeys(email);
		userPassword.sendKeys(password);
		loginBtn.click();
		ProductCatalog pc = new ProductCatalog(driver);
		return pc;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().fullscreen();
	}
	
	public String getErrorMessage() {
		waitForElementToAppear(msg);
		String errorMessage = errorMsg.getText();
		return errorMessage;
	}
	

}
