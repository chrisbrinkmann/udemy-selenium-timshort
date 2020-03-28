package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

	public static WebDriver getDriver(String browserType) {

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRINK\\Selenium\\chromedriver.exe");

			System.out.println("Using Chrome WebDriver");

			return new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\BRINK\\Selenium\\IEDriverServer.exe");

			System.out.println("Using IE WebDriver");

			return new InternetExplorerDriver();
		} else {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\BRINK\\Selenium\\geckodriver.exe");

			System.out.println("Using Firefox WebDriver");

			return new FirefoxDriver();
		}

	}
}
