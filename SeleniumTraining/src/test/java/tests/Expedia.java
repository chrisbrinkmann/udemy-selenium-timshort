package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.WebDriverFactory;

public class Expedia {
	private WebDriver driver;
	private JavascriptExecutor je;
	private String browserType = "chrome";
	private String city = "Bangkok";
	private String checkInDate = "12/15/20";
	private String checkOutDate = "01/05/21";

	@Before
	public void setUp() {
		System.out.println("Setting up test");

		System.out.println("Instantiating Web Driver");
		driver = WebDriverFactory.getDriver(browserType);
		je = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		System.out.println("Navigating to website");
		driver.get("https://www.expedia.com/");
	}

	@Test
	public void hotelReservation() throws Exception {
		System.out.println("Executing Hotel Reservation Test");

		System.out.println("Executing Search Page Test Steps");
		// Search page steps
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkInDate);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOutDate);
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button")).click();
		driver.findElement(
				By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div[1]/div[2]/div[2]/button"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[13]/label/button")).click();

		System.out.println("Pausing 5 seconds while Search Page loads...");

		// Pause while search page loads
		Thread.sleep(5000);

		// Searh results page steps
		System.out.println("Executing Search Results Page Test Steps");

		WebElement fourStarButton = driver.findElement(By.id("star-3"))
				.findElement(By.xpath("./following-sibling::label/span[1]"));
		// This line is needed to scroll the element into view in order that it is
		// clickable
		je.executeScript("arguments[0].scrollIntoView(true);", fourStarButton);
		System.out.println("Filtering By Four Star Hotels Only");
		fourStarButton.click();

		System.out.println("Pausing  6 seconds after applying filter...");
		// Pause after filtering
		Thread.sleep(6000);

		System.out.println("Selecting Hotel");
		driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div/div/div[1]/div[1]/main/div/div/div[2]/section[2]/ol/li[1]/div/div/a"))
				.click();

		System.out.println("Pausing 5 seconds after clicking link to hotel...");
		// Pause after clicking hotel link
		Thread.sleep(5000);

		// Switch to new tab after hotel is selected
		System.out.println("Switching Tabs");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		WebElement hotelTitle = driver.findElement(By.cssSelector("h1[data-stid=content-hotel-title]"));

		System.out.printf("Selected Hotel Name: %s\n", hotelTitle.getText());
		
		Assert.assertTrue(hotelTitle.isDisplayed());

		System.out.println("End of Test");
		System.out.println("Pausing 3 seconds at End of Test...");
		Thread.sleep(3000);
	}

	@After
	public void tearDown() {
		System.out.println("Tearing down test");
		driver.quit();
	}
}
