package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.WebDriverFactory;

public class PageLogoTestNG {
	private WebDriver driver;	
	
	@Test
	public void logoTest() {
		String url = "https://www.google.com";
		driver.get(url);
		
		boolean pageHasLogo = driver.findElement(By.id("hplogo")).isDisplayed();
	
		Assert.assertTrue(pageHasLogo, "Page logo is present");
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Setting up tests");
		driver = WebDriverFactory.getDriver("firefox");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Tearing down tests");
		driver.close();
	}
}
