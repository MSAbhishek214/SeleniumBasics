package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assignment3Test extends SetupAndTearDown {

	@Test
	public void assignment3() {
		// Sending value to username field
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		// Sending value to password field
		driver.findElement(By.id("password")).sendKeys("learning");
		// Selecting the User radio button
		driver.findElement(By.xpath("//span[normalize-space()='User']")).click();
		// Clickin on okay in the alert box after waiting for it to be active
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		// waiting until dropdown is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[class='form-control']")));
		// Creating a variable for static dropdown
		Select userType = new Select(driver.findElement(By.cssSelector("select[class='form-control']")));
		// Select the student userType from dropdown
		userType.selectByIndex(2);
		// Checking the terms checkbox
		driver.findElement(By.id("terms")).click();
		// Clicking on the Sign IN button
		driver.findElement(By.id("signInBtn")).click();
		// Waiting until the DOM is fully loaded in the products page
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='card-body']/following-sibling::div/button")));
		// Finding all buttons and clicking through them one by one
		List<WebElement> addToCartButtons = driver
				.findElements(By.xpath("//div[@class='card-body']/following-sibling::div/button"));
		for (WebElement button : addToCartButtons) {
			button.click();
		}
		// Clicking on the checkout button
		driver.findElement(By.cssSelector("a.nav-link.btn")).click();
	}
}
