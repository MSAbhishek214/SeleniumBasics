package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment4Test extends SetupAndTearDown {

	@Test
	public void assignment4() {
		// click on the link that opens new window
		driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
		// Get the window handles set
		Set<String> windows = driver.getWindowHandles();
		// Creating an iterator to have the handles assigned to individual windows
		Iterator<String> it = windows.iterator();
		// Assigning first handle to parent window
		String firstWindow = it.next();
		// Assigning first handle to parent window
		String secondWindow = it.next();
		// switch to the second window
		driver.switchTo().window(secondWindow);
		// Getting the text from second window
		Assert.assertEquals(driver.findElement(By.cssSelector("div.example h3")).getText(), "New Window");
		// switch back to first window
		driver.switchTo().window(firstWindow);
		// getting the text from first window
		Assert.assertEquals(driver.findElement(By.cssSelector("div.example h3")).getText(), "Opening a new window");
	}
}
