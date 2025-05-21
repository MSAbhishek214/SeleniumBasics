package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) {

		// Initializing Web driver for Chrome browser
		WebDriver driver = new ChromeDriver();

		// Providing implicit wait to ensure DOM is loaded before interacting with any
		// element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Getting the first checkbox
		driver.findElement(By.id("checkBoxOption1")).click();

		// Validate if its successfully checked
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());

		// Unchecking the first checkbox
		driver.findElement(By.id("checkBoxOption1")).click();

		// Validate if its successfully checked
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());

		// Getting list of checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='checkbox-example'] //input"));

		// Interating through each
		Assert.assertEquals(3, checkboxes.size());
		
		// Qutting driver
		driver.quit();
		

	}

}
