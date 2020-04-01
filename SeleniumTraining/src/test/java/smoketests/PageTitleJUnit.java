package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
		
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Before
	public void testSetUp() {
		System.out.println("Setting up the tests");
		driver = WebDriverFactory.getDriver("firefox");
	}
	
	@After
	public void testTearDown() {
		System.out.println("Tearing down the tests");
		driver.close();
	}
	
}
