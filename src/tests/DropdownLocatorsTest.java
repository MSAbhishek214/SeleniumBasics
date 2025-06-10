package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownLocatorsTest extends SetupAndTearDown {

	@Test
	public void validateAdultCountIncreased() {
		// Clicking on the Passengers dropdown
		driver.findElement(By.id("divpaxinfo")).click();
		// Wait until the plus button is interactable
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("hrefIncAdt"))));
		// Increasing the adult count from 1 to 5
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		// Clicking on done
		driver.findElement(By.id("btnclosepaxoption")).click();
		// Getting the text from passengers dropdown and asserting its matching
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
	}

}
