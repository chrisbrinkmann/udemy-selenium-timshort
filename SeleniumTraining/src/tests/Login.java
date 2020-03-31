package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;
import util.WebDriverFactory;

public class Login {
	private WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private String username = "JimJoe";
	private String password = "1234";
	
	@Before
	public void setUp() {
		driver = WebDriverFactory.getDriver("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
	}
	
	@Test
	public void loginTestPOM() {		
		// Enter Login Information (Login Page)
		loginPage.setUserName(username);
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		
		// Get Confirmation (Dashboard Page)
		Assert.assertTrue(dashboardPage.confirmationMessageIsDisplayed());
	}

	@After
	public void tearDown() {
		driver.quit();
	}	
}
