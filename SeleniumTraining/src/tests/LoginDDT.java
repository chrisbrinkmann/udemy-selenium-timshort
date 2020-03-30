package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Excel;
import util.WebDriverFactory;

public class LoginDDT {
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = WebDriverFactory.getDriver("firefox");
		
		// 2. Open web browser and navigate to web app page:
	    driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}

	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password) {
		// System.out.printf("NEW RECORD: %s, %s, %s\n\n", name, email, password);
		
		// fill out the form
	    driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
	    driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
	    driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	    
	    // Get confirmation
	    String message = driver.findElement(By.id("conf_message")).getText();
	    System.out.println("CONFIRMATION: " + message);
	    
	}
	
	@AfterMethod
	public void tearDown() {
	    driver.quit();
	}
	
	// This tag marks the method as a Data Provider which will pass its return
	// to the @Test method as a parameter. It is a 2d array, and the test will
	// be run once for each row, with the columns being passed as params for each run
	@DataProvider
	public String[][] getData(){
		return Excel.get("D:\\dev\\udemy\\selenium\\SDET-selenium\\SeleniumTraining\\src\\resources\\original.xls");
	}
}
