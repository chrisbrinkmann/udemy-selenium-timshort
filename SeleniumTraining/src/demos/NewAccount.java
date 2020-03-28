package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import util.WebDriverFactory;

public class NewAccount {
  public static void main(String[] args) {
    WebDriver driver;
    String name = "Tony Rice";
    String email = "TonyRice@thedevil.com";
    String password = "freebornman";
    String country = "Belgium";
    String phoneNumber = "555-555-5555";

    String gender;
    String weeklyEmail;
    String monthlyEmail;
    String occassionalEmail;

    String browserType = "chrome";

    // 1. Create WebDriver
    driver = WebDriverFactory.getDriver(browserType);

    // 2. Navigate to Acct Mgmt Page >> Click on Create Account
    driver.get(
        "http://sdettraining.com/trguitransactions/accountmanagement.aspx");
    driver.findElement(By.linkText("CREATE ACCOUNT")).click();

    // 3. Fill out the form

    // How to locate elements and input text...

    // find by name
    driver.findElement(By.name("ctl00$MainContent$txtFirstName"))
        .sendKeys(name);

    // find by id
    driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);

    // find by relative xpath
    driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"))
        .sendKeys(phoneNumber);

    // find by css selector
    driver
        .findElement(By.cssSelector(
            "input[type='password'][id='MainContent_txtPassword']"))
        .sendKeys(password);

    // by name again
    driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"))
        .sendKeys(password);

    // How to interact with other elements...

    // a radio button
    driver.findElement(By.id("MainContent_Male")).click();

    // a dropdown menu - note that we create a new Select object to access the
    // dropdown items
    new Select(driver.findElement(By.id("MainContent_menuCountry")))
        .selectByValue(country);

    driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();

    driver.findElement(By.id("MainContent_btnSubmit")).click();

    // 4. Get Confirmation
    boolean conf = driver.findElement(By.id("MainContent_lblTransactionResult"))
        .getText().equals("Customer information added successfully");

    // print result
    System.out.println("CONFIRMATION: " + conf);

    // 5. Close the browser
    driver.close();
  }
}
