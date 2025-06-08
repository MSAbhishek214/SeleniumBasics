package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorsUsingXpathPCSTest extends SetupAndTearDown {
	
	@Test
	public void LoginTest() {
		// Selecting User name input field using ID selector and send value
		driver.findElement(By.xpath("//form/h1/following-sibling::input[1]")).sendKeys("Abhishek");
		// Selecting Password input field using ID selector and send value
		driver.findElement(By.xpath("//form/h1/following-sibling::input[2]")).sendKeys("pass123");
		// Clicking on sign in button
		driver.findElement(By.xpath("//form/button")).click();
		// Validating sign in button was clicked
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/p")));
		// Fetching error message text using CSS Selector (Tag + Class)
		Assert.assertEquals(driver.findElement(By.xpath("//form/p")).getText(), "* Incorrect username or password");
	}

	@Test
	public void forgotPasswordTest() {
		// Creating a string variable to hold name
		String name = "Abhi";
		// Clicking on Forgot your password link
		driver.findElement(By.xpath("//form/div[2]/a")).click();
		// Selecting user name input field and sending value
		driver.findElement(By.xpath("//form/h2/following-sibling::input[1]")).sendKeys(name);
		// Selecting email input field and sending value
		driver.findElement(By.xpath("//form/h2/following-sibling::input[2]")).sendKeys("abhi@ymail.com");
		// Selecting phone number input field and sending value
		driver.findElement(By.xpath("//form/h2/following-sibling::input[3]")).sendKeys("8965698965");
		// Waiting for the reset button to fully load
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div/button[2]")));
		// Clicking on reset login button
		driver.findElement(By.xpath("//form/div/button[2]")).click();
		// Validating reset was successful using text shown upon clicking reset login
		// button
		Assert.assertEquals(driver.findElement(By.xpath("//form/h2/following-sibling::p")).getText(),
				"Please use temporary password 'rahulshettyacademy' to Login.");
		// Clicking on go to login
		driver.findElement(By.xpath("//form/div/button[1]")).click();
	}

	@Test
	public void successfulLoginAndLogoutTest() {
		// Creating a string variable to hold name
		String name = "Abhi";
		// Selecting User name input field using ID selector and send value
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Abhi");
		// Selecting Password input field using ID selector and send value
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");
		// Checking the box Remember my username
		driver.findElement(By.xpath("//form/div/span[1]")).click();
		// Checking the box for agreeing terms and privacy policy
		driver.findElement(By.xpath("//form/div/span[2]/input")).click();
		// Clicking on sign in button
		driver.findElement(By.xpath("//form/button")).click();
		// Wait for the element to be loaded onto DOM
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p")));
		// Validating log in was successful using text shown upon clicking sign in
		// button
		Assert.assertEquals(driver.findElement(By.xpath("//div/p")).getText(), "You are successfully logged in.");
		// Asserting the first line text using testNG
		Assert.assertEquals(driver.findElement(By.xpath("//div/h2")).getText(), "Hello " + name + ",");
		// clicking on the log out button
		driver.findElement(By.xpath("//div/button")).click();
		// Wait for element in Login page to be located
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/h1")));
		// Validating logout was successful by getting text from logged out page
		Assert.assertEquals(driver.findElement(By.xpath("//form/h1")).getText(), "Sign in");
	}
}
