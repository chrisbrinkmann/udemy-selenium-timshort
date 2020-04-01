package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	private WebDriver driver;
	
	public boolean confirmationMessageIsDisplayed() {
		return driver.findElement(By.id("conf_message")).isDisplayed();
	}
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
}
