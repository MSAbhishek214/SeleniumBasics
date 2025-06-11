package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment2Test extends SetupAndTearDown {

	@Test
	public void assignment2() {
		// Sending name value to the Name input tag
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("Dark");
		// Sending email value to the Email input tag
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='email']")).sendKeys("dark@light.com");
		// Sending password value to the password field
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");
		// Checking the checkbox after Password field
		driver.findElement(By.id("exampleCheck1")).click();
		// Clicking on the Gender dropdown
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		// Selecting Female
		driver.findElement(By.xpath("//option[contains(text(), 'Female')]")).click();
		// Clicking on the Student radio button
		driver.findElement(By.id("inlineRadio1")).click();
		// Sending DOB info to DOB field
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("14-05-1997");
		// Clicking on submit button
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		// Assert if success message was shown
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.getText().split("\n")[1], "Success! The Form has been submitted successfully!.");
	}

}
