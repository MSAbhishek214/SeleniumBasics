package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorsUsingCSSTest extends SetupAndTearDown {
	
	@Test
	public void LoginTest() {
		// Selecting User name input field using ID selector and send value
		driver.findElement(By.id("inputUsername")).sendKeys("Abhishek");
		// Selecting Password input field using ID selector and send value
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("pass123");
		// Clicking on sign in button
		driver.findElement(By.cssSelector("button[class='submit signInBtn']")).click();
		// Wait for error message to load on screen
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.error")));
		// Fetching error message text using CSS Selector (Tag + Class)
		Assert.assertEquals(driver.findElement(By.cssSelector("p.error")).getText(),
				"* Incorrect username or password");
	}

	@Test
	public void forgotPasswordTest() {
		// Creating a string variable to hold name
		String name = "Abhi";
		// Clicking on Forgot your password link
		driver.findElement(By.linkText("Forgot your password?")).click();
		// Selecting user name input field and sending value
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys(name);
		// Selecting email input field and sending value
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abhi@ymail.com");
		// Selecting phone number input field and sending value
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("8965698965");
		// Waiting for the reset button to full load
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".reset-pwd-btn")));
		// Clicking reset password button using CSS Selector (Class-based)
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		// Fetching password reset confirmation message using CSS Selector (Tag +
		// Descendant selection)
		Assert.assertEquals(driver.findElement(By.cssSelector("form p")).getText(),
				"Please use temporary password 'rahulshettyacademy' to Login.");
		// Clicking on go to login
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
	}

	@Test
	public void successfulLoginAndLogoutTest() {
		// Creating a string variable to hold name
		String name = "Abhi";
		// Selecting User name input field using ID selector and send value
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		// Selecting Password input field using ID selector and send value
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("rahulshettyacademy");
		// Checking the box Remember my username
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		// Checking the box for agreeing terms and privacy policy
		driver.findElement(By.cssSelector("#chkboxTwo")).click();
		// Clicking on sign in button
		driver.findElement(By.cssSelector("button[class='submit signInBtn']")).click();
		// Wait for the element to be loaded onto DOM
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='login-container'] > p")));
		// Validating log in was successful using text shown upon clicking sign in
		// button
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] > p")).getText(),
				"You are successfully logged in.");
		// Asserting the first line text using testNG
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");
		// clicking on the log out button
		driver.findElement(By.cssSelector(".logout-btn")).click();
	}
}
