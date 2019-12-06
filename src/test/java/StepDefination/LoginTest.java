package StepDefination;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;


import Utilities.BaseClassCucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginTest extends BaseClassCucumber {
	@Given("^i open chrome browser$")
	public void i_open_chrome_browser() {
		openBrowser();
	}

	@Given("^i go to salesforce home page$")
	public void i_go_to_salesforce_home_page()  {
		driver.get("https://login.salesforce.com");
	}

	@When("^I enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_enter_username_and_password(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	  
	}
	  
	



	@When("^i click the login button$")
	public void i_click_the_login_button()  {
		driver.findElement(By.id("Login")).click();
	}

	@Then("^i see the dashboard$")
	public void i_see_the_dashboard()  {
		boolean isNamePresent = driver.findElement(By.linkText("test user")).isDisplayed();
		Assert.assertTrue(isNamePresent);

	   
	}


}
