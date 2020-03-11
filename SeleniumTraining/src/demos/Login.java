package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

  public static void main(String[] args) {
    // 1. Define the web driver
    
      // set the system prop for the webdriver
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRINK\\Selenium\\chromedriver.exe");
    
      // instantiate a new WebDriver object as a ChromeDriver
    WebDriver driver = new ChromeDriver();
    
    // 2. Open web browser and navigate to web app page:
    driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
  
    // Find Elements: Locate the element, Determine the action, Pass any params
    // 3. Enter the email address
    driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("johndoe@example.com");
          
    // 4. Enter the password
    driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("1234");
  
    // 5. Click login
    driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
    
    // 6. Get confirmation
    String message = driver.findElement(By.id("conf_message")).getText();
    
    System.out.println("CONFIRMATION: " + message);
    
    String pageTitle = driver.getTitle();
    System.out.println("PAGE TITLE: " + pageTitle);
    
    // 7. Close the browser
    driver.close();
  }

}
