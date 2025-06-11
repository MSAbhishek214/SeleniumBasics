package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupAndTearDown {
	// Create a web driver object
	protected WebDriver driver;
	// Create a Web driver wait object
	protected WebDriverWait wait;

	@BeforeMethod(alwaysRun = true)
	@Parameters({"baseURL"})
	public void setup(String baseURL) {
		
		WebDriverManager.chromedriver().setup();
		// Initializing WebDriver for Chrome browser
		driver = new ChromeDriver();
		// Create a wait object for handling explicit wait scenarios
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// Navigating to the login practice page
		driver.get(baseURL);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
