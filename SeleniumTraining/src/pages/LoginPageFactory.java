package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	private WebDriver driver;
	
	// Define web elements
	@FindBy(id="MainContent_txtUserName")
	private WebElement usernameInput;
	
	@FindBy(id="MainContent_txtpassword")
	private WebElement passwordInput;
	
	@FindBy(id="MainContent_btnLogin")
	private WebElement submitButton;
	
	// Page steps
	public void setUserName(String username) {
		usernameInput.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void clickSubmit() {
		submitButton.click();
	}
	
	// Grouped actions
	public void login(String username, String password) {
		setUserName(username);
		setPassword(password);
		clickSubmit();
	}
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
