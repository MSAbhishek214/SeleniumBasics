package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment7Test extends SetupAndTearDown {

	@Test
	public void assignment7() {
		// Wrap the driver into Javascript Executor object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Capture web element for the desired table
		WebElement table = driver.findElement(By.id("product"));
		// Scroll the table into view
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", table);
		// Capture the number of records in the table
		int rows = driver.findElements(By.cssSelector(".table-display tr")).size();
		// Capture the number of columns in the table
		int columns = driver.findElements(By.cssSelector(".table-display th")).size();
		// Assert the number of rows and columns
		Assert.assertEquals(rows, 11);
		Assert.assertEquals(columns, 3);
		// Assert the value of 3rd row
		Assert.assertEquals(driver.findElement(By.cssSelector(".table-display tbody tr:nth-child(3)")).getText(),
				"Rahul Shetty Learn SQL in Practical + Database Testing from Scratch 25");
	}
}
