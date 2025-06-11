package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment6Test extends SetupAndTearDown {

	@Test
	public void assignment6() {
		// Select the option 2 checkbox
		driver.findElement(By.id("checkBoxOption2")).click();
		// Get text from the selected checkbox
		String checkBoxValue = driver.findElement(By.id("checkBoxOption2")).getDomProperty("value");
		// Create a select object to deal with the dropdown values
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		// Select dropdown value based on text that was retrieved from selected checkbox
		dropdown.selectByValue(checkBoxValue);
		// Enter the same checkBoxValue in the alert input box
		driver.findElement(By.id("name")).sendKeys(checkBoxValue);
		// Click on Alert button
		driver.findElement(By.id("alertbtn")).click();
		// Switch focus to alert and assert if its the same option selected
		Assert.assertEquals(driver.switchTo().alert().getText().split(",")[0].split(" ")[1], "option2");
	}
}
