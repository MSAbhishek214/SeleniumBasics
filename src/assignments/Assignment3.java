package assignments;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		
		// 2. Create an instance of ChromeOptions
	    ChromeOptions options = new ChromeOptions();

	    // 3. Create a HashMap to hold the preferences for Chrome
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false); // Disables Chrome's offer to save passwords
	    prefs.put("profile.password_manager_enabled", false); // Turns off the password manager features
	    prefs.put("profile.password_manager_leak_detection", false); // Disables the data breach warning

	    // 4. Add the preferences to ChromeOptions as an experimental option
	    options.setExperimentalOption("prefs", prefs);

	    // Optional: Add other arguments for a cleaner test environment if needed
	    // options.addArguments("--incognito"); // To run in incognito mode
	    // options.addArguments("--disable-infobars"); // Might help disable some other info bars

	    // 5. Initialize the ChromeDriver with the configured options
	    WebDriver driver = new ChromeDriver(options);

		// Maximizing screen size
		driver.manage().window().maximize();

		// Creating a web driver wait for explicit waits
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// Sending value to username field
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");

		// Sending value to password field
		driver.findElement(By.id("password")).sendKeys("learning");

		// Selecting the User radio button
		driver.findElement(By.xpath("//span[normalize-space()='User']")).click();

		// Clickin on okay in the alert box after waiting for it to be active
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();

		// waiting until dropdown is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[class='form-control']")));

		// Creating a variable for static dropdown
		Select userType = new Select(driver.findElement(By.cssSelector("select[class='form-control']")));

		// Select the student userType from dropdown
		userType.selectByIndex(2);

		// Checking the terms checkbox
		driver.findElement(By.id("terms")).click();

		// Clicking on the Sign IN button
		driver.findElement(By.id("signInBtn")).click();

		// Waiting until the DOM is fully loaded in the products page
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='card-body']/following-sibling::div/button")));

		// Finding all buttons and clicking through them one by one
		List<WebElement> addToCartButtons = driver
				.findElements(By.xpath("//div[@class='card-body']/following-sibling::div/button"));

		for (WebElement button : addToCartButtons) {
			button.click();
		}

		// Clicking on the checkout button
		driver.findElement(By.cssSelector("a.nav-link.btn")).click();

		// quitting driver
		driver.quit();

	}

}
