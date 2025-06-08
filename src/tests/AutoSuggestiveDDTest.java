package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoSuggestiveDDTest extends SetupAndTearDown {

	@Test
	public void validateCorrectDropDownSelected() {

		// Clicking on the country input box and type IND
		driver.findElement(By.id("autosuggest")).click();
		// Typing ind in the box to get auto suggestions
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		// Wait until the dropdown is loaded
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@id='ui-id-1']"))));
		// Finding the list of elements that are auto suggested
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1'] //a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		// Checking if India was populated in the input box
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='autosuggest']")).getDomProperty("value"),
				"India");
	}
}
