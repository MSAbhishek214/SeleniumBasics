package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment8Test extends SetupAndTearDown {

	@Test
	public void assignment8() {
		// Clicking on the country input box and type IND
		driver.findElement(By.id("autocomplete")).click();
		// Typing ind in the box to get auto suggestions
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		// Wait until the auto suggestions load into UI
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("ul#ui-id-1"))));
		// Finding the list of elements that are auto suggested
		List<WebElement> options = driver.findElements(By.cssSelector("ul#ui-id-1 li div"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		// Checking if India was populated in the input box
		Assert.assertEquals(driver.findElement(By.id("autocomplete")).getDomProperty("value"), "India");
	}

}
