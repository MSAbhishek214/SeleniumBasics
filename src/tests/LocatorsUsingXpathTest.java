package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorsUsingXpathTest extends SetupAndTearDown {

	@Test
	public void LoginTest() {
		// Selecting User name input field using ID selector and send value
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Abhishek");
		// Selecting Password input field using ID selector and send value
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("pass123");
		// Clicking on sign in button
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		// Validating sign in button was clicked
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='error']")));
		// Fetching error message text using CSS Selector (Tag + Class)
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='error']")).getText(),
				"* Incorrect username or password");
	}

	@Test
	public void forgotPasswordTest() {
		// Creating a string variable to hold name
		String name = "Abhi";
		// Clicking on Forgot your password link
		driver.findElement(By.xpath("//div[@class='forgot-pwd-container']/a")).click();
		// Selecting user name input field and sending value
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		// Selecting email input field and sending value
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abhi@ymail.com");
		// Selecting phone number input field and sending value
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("8965698965");
		// Waiting for the reset button to full load
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='reset-pwd-btn']")));
		// Clicking on reset login button
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		// Validating reset was successful using text shown upon clicking reset login
		// button
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText(),
				"Please use temporary password 'rahulshettyacademy' to Login.");
		// Clicking on go to login
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
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
		driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
		// Checking the box for agreeing terms and privacy policy
		driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();
		// Clicking on sign in button
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		// Wait for the element to be loaded onto DOM
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='login-container']/p")));
		// Validating log in was successful using text shown upon clicking sign in
		// button
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(), "You are successfully logged in.");
		// Asserting the first line text using testNG
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),
				"Hello " + name + ",");
		// clicking on the log out button
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
	}
}
