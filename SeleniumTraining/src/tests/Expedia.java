package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import util.WebDriverFactory;

public class Expedia {
	private WebDriver driver;
	private String browserType = "firefox";
	private String city = "Bangkok";
	private String checkInDate = "12/12/20";
	private String checkOutDate = "01/05/21";

	@Before
	public void setUp() {
		driver = WebDriverFactory.getDriver(browserType);
		driver.manage().window().maximize();
		driver.get("https://www.expedia.com/");
	}

	@Test
	public void hotelReservation() {
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkInDate);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOutDate);
		driver.findElement(By.xpath(
				"/html/body/meso-native-marquee/section/div/div/div[1]/section/div/div[2]/div[2]/section[2]/form/div[7]/div[3]/div/ul/li/button"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/meso-native-marquee/section/div/div/div[1]/section/div/div[2]/div[2]/section[2]/form/div[7]/div[3]/div/ul/li/div/div/div[1]/div[2]/div[2]/button"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[13]/label/button")).click();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
