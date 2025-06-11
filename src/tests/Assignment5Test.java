package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment5Test extends SetupAndTearDown {

	@Test
	public void assignment5() {
		// First switch focus to inner nested frame frame top
		driver.switchTo().frame("frame-top");
		// Switch focus to frame where MIDDLE is located and get text
		driver.switchTo().frame("frame-middle");
		// Assert the text as a validation
		Assert.assertEquals(driver.findElement(By.id("content")).getText(), "MIDDLE");
	}
}
