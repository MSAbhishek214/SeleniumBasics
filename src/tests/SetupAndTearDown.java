package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetupAndTearDown {
	// Create a web driver object
	WebDriver driver;
	// Create a Web driver wait object
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		// Initializing WebDriver for Chrome browser
		driver = new ChromeDriver();
		// Create a wait object for handling explicit wait scenarios
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
