package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.CSV;
import util.WebDriverFactory;

// This specifies a particular class to use as a runner.
// If it is not used then JUnit has a built in runner that automatically gets called.
@RunWith(Parameterized.class)
public class NewAccountDDT {
	private String name, email, phone, gender, password, country;
	private boolean weeklyEmail, monthlyEmail, occasionalEmail;
	private WebElement nameInput, emailInput, homePhoneInput, passwordInput, verifyPasswordInput, maleGenderRadioButton,
			femaleGenderRadioButton, countrySelect, weeklyEmailCheckBox, monthlyEmailCheckBox, occasionalEmailCheckBox,
			submitButton, transactionConfirmation;
	private WebDriver driver;

	@Before
	public void testSetUp() {
		System.out.println("Setting up the tests");
		driver = WebDriverFactory.getDriver("firefox");

		// Navigate to the page and click Create Account
		driver.get("http://sdettraining.com/trguitransactions/accountmanagement.aspx");
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();

		// cache the web elements in instance variables
		defineWebElements();
	}

	// This is our test method
	@Test
	public void newAccountTest() {
		System.out.printf("NEW RECORD: %s, %s, %s, %s, %s, %s, %b, %b, %b\n", name, email, phone, gender, password,
				country, weeklyEmail, monthlyEmail, occasionalEmail);

		// Fill out the form
		nameInput.sendKeys(name);
		emailInput.sendKeys(email);
		homePhoneInput.sendKeys(phone);
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

		if (occasionalEmail) {
			if (!occasionalEmailCheckBox.isSelected()) {
				occasionalEmailCheckBox.click();
			}
		} else {
			if (occasionalEmailCheckBox.isSelected()) {
				occasionalEmailCheckBox.click();
			}
		}

		submitButton.click();

		// Check confirmation message
		if (transactionConfirmation.getText().equals("Customer information added successfully")) {
			System.out.println("Create account successful");
		} else {
			System.out.println("Create account failed");
		}
	}

	@After
	public void testTearDown() {
		System.out.println("Tearing down the tests");
		driver.close();
	}

	// This annotated method is designed to pass params into the class via
	// constructor. Note that we pass it a list of String arrays and a separate
	// test is run for each item in the LIST, with the array of Strings as the
	// paramaters (which we access via the constructor).
	@Parameters
	public static List<String[]> getData() {
		return CSV.get("D:\\dev\\udemy\\selenium\\SDET-selenium\\SeleniumTraining\\src\\resources\\original.csv");
	}

	// The constructor uses the params to assign value to the instance variables
	// used by the test method
	public NewAccountDDT(String name, String email, String phone, String gender, String password, String country,
			String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;

		if (weeklyEmail.equals("TRUE")) {
			this.weeklyEmail = true;
		} else {
			this.weeklyEmail = false;
		}

		if (monthlyEmail.equals("TRUE")) {
			this.monthlyEmail = true;
		} else {
			this.monthlyEmail = false;
		}

		if (occasionalEmail.equals("TRUE")) {
			this.occasionalEmail = true;
		} else {
			this.occasionalEmail = false;
		}
	}

	// helper class to set the WebElement instance variables
	public void defineWebElements() {
		nameInput = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		emailInput = driver.findElement(By.id("MainContent_txtEmail"));
		homePhoneInput = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		passwordInput = driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
		verifyPasswordInput = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		maleGenderRadioButton = driver.findElement(By.id("MainContent_Male"));
		femaleGenderRadioButton = driver.findElement(By.id("MainContent_Female"));
		countrySelect = driver.findElement(By.id("MainContent_menuCountry"));
		weeklyEmailCheckBox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		monthlyEmailCheckBox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		occasionalEmailCheckBox = driver.findElement(By.id("MainContent_checkOccassionalEmail"));
		submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
		transactionConfirmation = driver.findElement(By.id("MainContent_lblTransactionResult"));
	}
}
