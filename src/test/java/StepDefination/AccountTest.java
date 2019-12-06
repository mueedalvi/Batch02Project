package StepDefination;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.BaseClassCucumber;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class AccountTest extends BaseClassCucumber {

	@Then("^i Create an account$")
	public void i_Create_an_account(DataTable AccountDetails) throws InterruptedException {
		List<Map<String, String>> maps = AccountDetails.asMaps(String.class, String.class);
		for (Map<String, String> map : maps) {

			driver.findElement(By.linkText("Accounts")).click();

			driver.findElement(By.xpath("//input[@title='New']")).click();
			driver.findElement(By.id("acc2")).sendKeys(map.get("Account Name"));
			driver.findElement(By.id("acc10")).sendKeys(map.get("Phone"));
			driver.findElement(By.id("acc11")).sendKeys(map.get("Fax"));
			
			String parentWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//img[@title='Parent Account Lookup (New Window)']")).click();
			Set<String> childWindow = driver.getWindowHandles();
			System.out.println("Total windows open : " + childWindow.size());
			System.out.println(driver.getCurrentUrl());
			Iterator<String> num = childWindow.iterator(); // 2
			while (num.hasNext()) {
				String subPage = num.next(); // childWindow
				if (!parentWindow.equals(subPage)) {
					driver.switchTo().window(subPage);
					System.out.println("After switching to child" + driver.getCurrentUrl());
					driver.switchTo().frame(0);
					Thread.sleep(3000);
					driver.findElement(By.id("lksrch")).sendKeys(map.get("Parent Account"));
					driver.findElement(By.xpath("//div[@class='pBody']/input[@value=' Go! ']")).click();
					Thread.sleep(4000);
					driver.switchTo().window(subPage);
					driver.switchTo().frame(driver.findElement(By.id("resultsFrame")));
					List<WebElement> cells = driver.findElements(
							By.xpath("//div[@class='pbBody']//table[@class='list']//tbody//tr//th[@scope='row']"));
					for (WebElement eachCell : cells) {
						String parentAccountName = eachCell.getText();
						System.out.println(parentAccountName);
						if (parentAccountName.contains(map.get("Parent Account"))) {
							driver.findElement(By.xpath("//th[@scope='row']//a")).click();
							break;
						}
					}
					driver.switchTo().window(parentWindow);
					
				

				}

			}
	 	WebElement typeField = driver.findElement(By.id("acc6"));
		Select typePicker = new Select (typeField);
		typePicker.selectByVisibleText(map.get("Type"));
		
		}
		

	}
	
	}




