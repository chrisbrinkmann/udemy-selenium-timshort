package smoketests;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import util.WebDriverFactory;

// Smoke test means testing high level, basic, critical functionality
// A.K.A. confidence testing, sanity testing, build verification test (BVT)

public class PageTitleJUnit {

	@Test
	public void pageTitleTest() {
		String url = "https://www.google.com";
		String expectedTitle = "Google";

		WebDriver driver = WebDriverFactory.getDriver("chrome");
		driver.get(url);
		String actualTitle = driver.getTitle();	
		
		
	}
	
}
