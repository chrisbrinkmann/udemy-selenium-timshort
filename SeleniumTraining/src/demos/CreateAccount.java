package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
  
  public static void main(String[] args) {
    // 1. Create WebDriver
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\BRINK\\Selenium\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    
    
    // 2. Navigate to Acct Mgmt Page >> Click on Create Account
    driver.get("http://sdettraining.com/trguitransactions/accountmanagement.aspx");
    driver.findElement(By.linkText("CREATE ACCOUNT")).click();
    
    // 3. Fill out the form
    
      // How to locate elements and input text...
    
      // find by name
    driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Tony Rice");
    
      // find by id
    driver.findElement(By.id("MainContent_txtEmail")).sendKeys("TonyRice@thedevil.com");
    
      // find by relative xpath
    driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("555-555-5555");
    
      // find by css selector
    driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']")).sendKeys("freebornman");
    
      // by name again
    driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("freebornman");
    
      // How to interact with other elements...
    
      // a radio button
    driver.findElement(By.id("MainContent_Male")).click();
    
      // a dropdown menu - note that we create a new Select object to access the dropdown items
    new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByValue("Belgium");;
    
    driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
    
    driver.findElement(By.id("MainContent_btnSubmit")).click();
    
    // 4. Get Confirmation
    boolean conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText().equals("Customer information added successfully");
    
      // print result
    System.out.println("CONFIRMATION: " + conf);
    
    // 5. Close the browser
    driver.close();
  }
}
