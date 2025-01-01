package SourabhMohrir.SeleniumProject;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SourabhMohrir.TestComponents.BaseTest;
import seleniumProject.PageObjects.CartPage;
import seleniumProject.PageObjects.CheckoutPage;
import seleniumProject.PageObjects.ConfirmationPage;
import seleniumProject.PageObjects.LandingPage;
import seleniumProject.PageObjects.OrderPage;
import seleniumProject.PageObjects.ProductCatalog;

public class StandaloneTest extends BaseTest{
	
	
	@Test(dataProvider="getData",groups= {"purchase"})
	public void submitOrderTest(HashMap<String,String> input) throws IOException {
		
		String expectedMsg = "Thankyou for the order.";
		ProductCatalog pc = lp.loginApplication(input.get("email"),input.get("password"));
		List<WebElement>products = pc.getProductList();
		pc.addProductToCart(input.get("productName"));
		CartPage cp = pc.clickOnCart();
        Boolean match = cp.verifyProductDisplay(input.get("productName"));
        Assert.assertTrue(match);
        CheckoutPage checkout = cp.goToCheckOut();
        checkout.selectCountry("India");
        ConfirmationPage confirm = checkout.submitOrder();
        Assert.assertTrue(confirm.verifyMessage().equalsIgnoreCase(expectedMsg));   
}
	@Test(dataProvider="getData")
	public void orderHistoryTest(String email, String Password, String productName) throws IOException {
		ProductCatalog pc = lp.loginApplication(email, Password);
		OrderPage ordersPage = pc.clickOnOrders();
		Assert.assertFalse(ordersPage.verifyOrder(productName));
	}
	@DataProvider
	public Object[][] getData() 
	{
		HashMap<String,String> map = new HashMap();
		map.put("email", "sourabh07@gmail.com");
		map.put("password", "Sourabh@123");
		map.put("productName", "IPHONE 13 PRO");
		
		HashMap<String,String> map1 = new HashMap();
		map1.put("email", "srm@gmail.com");
		map1.put("password", "SourabhMoh@123");
		map1.put("productName", "ADIDAS ORIGINAL");
		//return new Object[][] {{"sourabh07@gmail.com","Sourabh@123","IPHONE 13 PRO"},{"srm@gmail.com","SourabhMoh@123","ADIDAS ORIGINAL"}};
		return new Object[][] {{map},{map1}};
	}
		
	
}
