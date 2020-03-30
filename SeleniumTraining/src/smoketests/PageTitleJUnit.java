package smoketests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import util.WebDriverFactory;

// Smoke test means testing high level, basic, critical functionality
// A.K.A. confidence testing, sanity testing, build verification test (BVT)

public class PageTitleJUnit {
	private String url = "https://www.google.com";
	private String expectedTitle = "Google";
	private WebDriver driver;
	
	
	@Test
	public void pageTitleTest() {
		System.out.println("Running the Page Title test");
		
		driver.get(url);
		String actualTitle = driver.getTitle();	
		
		Assertions.assertEquals(expectedTitle, actualTitle);
	}
	
	@BeforeEach
	public void testSetUp() {
		System.out.println("Setting up the tests");
		driver = WebDriverFactory.getDriver("firefox");
	}
	
	@AfterEach
	public void testTearDown() {
		System.out.println("Tearing down the tests");
		driver.close();
	}
	
}
