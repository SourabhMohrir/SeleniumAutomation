package SourabhMohrir.SeleniumProject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SourabhMohrir.TestComponents.BaseTest;
import seleniumProject.PageObjects.CartPage;
import seleniumProject.PageObjects.ProductCatalog;

public class ErrorValidation extends BaseTest{

	@Test
	public void verifyWrongPassword() {
	ProductCatalog pc = lp.loginApplication("sourabh0@gmail.com", "Sourabh@123");
	String errorMsg = lp.getErrorMessage();
	Assert.assertEquals(errorMsg, "Incorrect email or password.");
	}
	
	@Test
	public void productErrorValidation() {
		String productName = "IPHONE 13 PRO";
		ProductCatalog pc = lp.loginApplication("sourabh07@gmail.com", "Sourabh@123");
		List<WebElement>products = pc.getProductList();
		pc.addProductToCart(productName);
		CartPage cp = pc.clickOnCart();
        Boolean match = cp.verifyProductDisplay("IPHONE 133 PRO");
        Assert.assertFalse(match);
	}
}
