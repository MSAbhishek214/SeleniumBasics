package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorsTest extends SetupAndTearDown {

	@Test
	public void LoginTest() {
		// Selecting username input field using ID selector
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		// Selecting password input field using Name selector
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		// Clicking sign-in button using Class Name selector
		driver.findElement(By.className("signInBtn")).click();
		// Wait for error message to load on screen
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.error")));
		// Fetching error message text using CSS Selector (Tag + Class)
		Assert.assertEquals(driver.findElement(By.cssSelector("p.error")).getText(),
				"* Incorrect username or password");
	}

	@Test
	public void forgotPasswordTest() {
		// Clicking "Forgot your password?" link using Link Text selector
		driver.findElement(By.linkText("Forgot your password?")).click();
		// Entering name in input field using XPath (Attribute-based selection)
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		// Entering email in input field using CSS Selector (Attribute-based selection)
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
		// Clearing an input field using XPath (Indexed selection)
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		// Entering new email in input field using CSS Selector (nth-child pseudo-class)
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		// Entering phone number in input field using XPath (Parent-child relationship)
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");
		// Waiting for the reset button to full load
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".reset-pwd-btn")));
		// Clicking reset password button using CSS Selector (Class-based)
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		// Fetching password reset confirmation message using CSS Selector (Tag +
		// Descendant selection)
		Assert.assertEquals(driver.findElement(By.cssSelector("form p")).getText(),
				"Please use temporary password 'rahulshettyacademy' to Login.");
		// Clicking "Go to login" button using XPath (Class-based, indexed button
		// selection)
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
	}

	@Test
	public void successfulLoginTest() {
		// Entering username again using CSS Selector (ID-based selection)
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		// Entering password using CSS Selector (Attribute contains selector)
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		// Clicking checkbox using ID selector
		driver.findElement(By.id("chkboxOne")).click();
		// Clicking submit button using XPath (Contains function for class-based search)
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}

}
