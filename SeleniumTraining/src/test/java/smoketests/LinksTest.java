package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.WebDriverFactory;

public class LinksTest {
	private WebDriver driver;	
	
	@Test
	public void gmailLinkTest() {
		String url = "https://www.google.com";
		driver.get(url);
		
		boolean pageHasSignInLink = driver.findElement(By.id("gb_70")).isDisplayed();
	
		Assert.assertTrue(pageHasSignInLink, "Sign in link is present");
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
