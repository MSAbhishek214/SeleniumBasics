package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment8 {

	public static void main(String[] args) {

		// Initializing Web driver for Chrome browser
		WebDriver driver = new ChromeDriver();

		// Providing wait object to handle explicit wait scenarios
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

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
		System.out.println(driver.findElement(By.id("autocomplete")).getDomProperty("value"));

		// Close and quit driver
		driver.quit();

	}

}
