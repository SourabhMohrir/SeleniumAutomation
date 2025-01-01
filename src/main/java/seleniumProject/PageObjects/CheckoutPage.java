package seleniumProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryPlaceHolder;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement submitBtn;
	
	By results = By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryName){
		Actions a = new Actions(driver);
        a.sendKeys(countryPlaceHolder,"India").build().perform();
        waitForElementToAppear(results);
        selectCountry.click();
        
	}
	 
	 public ConfirmationPage submitOrder() {
		 submitBtn.click();
		 ConfirmationPage cp = new ConfirmationPage(driver);
		 return cp;
				
	 }
}
