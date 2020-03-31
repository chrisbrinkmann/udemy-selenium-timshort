package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;
import pages.LoginPageFactory;
import util.WebDriverFactory;

public class LoginFactory {
	private WebDriver driver;
	private LoginPageFactory loginPageFactory;
	private DashboardPage dashboardPage;
	private String username = "JimJoe";
	private String password = "1234";
	
	@Before
	public void setUp() {
		driver = WebDriverFactory.getDriver("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		loginPageFactory = new LoginPageFactory(driver);
		dashboardPage = new DashboardPage(driver);
	}
	
	@Test
	public void loginTestPageFactory() {		
		// Enter Login Information
		loginPageFactory.login(username, password);
		
		// Get Confirmation (Dashboard Page)
		Assert.assertTrue(dashboardPage.confirmationMessageIsDisplayed());
	}

	@After
	public void tearDown() {
		driver.quit();
	}	
}
