package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassCucumber {
	public static WebDriver driver;
	
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mueedalvi\\Desktop\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com");
	}

}
