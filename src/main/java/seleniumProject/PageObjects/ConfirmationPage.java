package seleniumProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement confirmMessage;
	
	By confirmMsg = By.xpath("//h1[@class='hero-primary']");
	
	public String verifyMessage() {
		waitForElementToAppear(confirmMsg);
		String successMessage = confirmMessage.getText();
		return successMessage;
	}
}
