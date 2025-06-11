package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment1Test extends SetupAndTearDown {

	@Test
	public void assignment1() {
		// Getting the first checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		// Validate if its successfully checked
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		// Unchecking the first checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		// Validate if its successfully unchecked
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		// Getting list of checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='checkbox-example'] //input"));
		// Interating through each
		Assert.assertEquals(3, checkboxes.size());
	}

}
