package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import pages.LoginPageFactory;
import util.WebDriverFactory;

public class LoginTest {
	private LoginPageFactory loginPage;
	private DashboardPage dashboardPage;
	private WebDriver driver;
	private String username = "biguser";
	private String password = "bigpassword";
	
	@Given("^the user is on the login page$")
	public void the_user_is_on_the_login_page() {
		driver = WebDriverFactory.getDriver("firefox");
		loginPage = new LoginPageFactory(driver);
		
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
	}
	
    @When("^the user enters valid username and password$")
    public void the_user_enters_valid_username_and_password() {
    	loginPage.login(username, password);
    }
    
    @Then ("^the user is taken to the landing dashboard page$")
    public void the_user_is_taken_to_the_landing_dashboard_page() {
    	dashboardPage = new DashboardPage(driver);
    	dashboardPage.confirmationMessageIsDisplayed();
    }
}
