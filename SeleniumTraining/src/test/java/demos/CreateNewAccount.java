package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import util.WebDriverFactory;

public class CreateNewAccount {
	public static void main(String[] args) {
		String name = "Tony Rice";
		String email = "TonyRice@thedevil.com";
		String password = "freebornman";
		String country = "Belgium";
		String phoneNumber = "555-555-5555";
		String gender = "Male";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occassionalEmail = false;
		String browserType = "chrome";

		// Instantiate a webdriver using the WebDriverFactory class that we created
		WebDriver driver = WebDriverFactory.getDriver(browserType);

		// Navigate to Acct Mgmt Page >> Click on Create Account
		driver.get("http://sdettraining.com/trguitransactions/accountmanagement.aspx");
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();

		// Cache web elements in WebElement objects
		WebElement nameInput = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailInput = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement homePhoneInput = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement passwordInput = driver
				.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
		WebElement verifyPasswordInput = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		WebElement maleGenderRadioButton = driver.findElement(By.id("MainContent_Male"));
		WebElement femaleGenderRadioButton = driver.findElement(By.id("MainContent_Female"));
		WebElement countrySelect = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement weeklyEmailCheckBox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement monthlyEmailCheckBox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		WebElement occassionalEmailCheckBox = driver.findElement(By.id("MainContent_checkOccassionalEmail"));
		WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
		WebElement transactionConfirmation = driver.findElement(By.id("MainContent_lblTransactionResult"));

		// Fill out the form
		nameInput.sendKeys(name);
		emailInput.sendKeys(email);
		homePhoneInput.sendKeys(phoneNumber);
		passwordInput.sendKeys(password);
		verifyPasswordInput.sendKeys(password);

		if (gender.equalsIgnoreCase("male")) {
			maleGenderRadioButton.click();
		} else {
			femaleGenderRadioButton.click();
		}

		// note that we create a new Select object to access the dropdown items
		new Select(countrySelect).selectByValue(country);

		if (weeklyEmail) {
			if (!weeklyEmailCheckBox.isSelected()) {
				weeklyEmailCheckBox.click();
			}
		} else {
			if (weeklyEmailCheckBox.isSelected()) {
				weeklyEmailCheckBox.click();
			}
		}

		if (monthlyEmail) {
			if (!monthlyEmailCheckBox.isSelected()) {
				monthlyEmailCheckBox.click();
			}
		} else {
			if (monthlyEmailCheckBox.isSelected()) {
				monthlyEmailCheckBox.click();
			}
		}

		if (occassionalEmail) {
			if (!occassionalEmailCheckBox.isSelected()) {
				occassionalEmailCheckBox.click();
			}
		} else {
			if (occassionalEmailCheckBox.isSelected()) {
				occassionalEmailCheckBox.click();
			}
		}

		submitButton.click();

		// Check confirmation message
		if (transactionConfirmation.getText().equals("Customer information added successfully")) {
			System.out.println("Create account successful");
		} else {
			System.out.println("Create account failed");
		}

		// Close the browser
		driver.quit();
	}
}
