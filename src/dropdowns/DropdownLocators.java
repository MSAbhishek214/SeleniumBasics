package dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownLocators {

	public static void main(String[] args) {

		// Initializing Webdriver for Chrome browser
		WebDriver driver = new ChromeDriver();

		// Providing implicit wait to ensure DOM is loaded before interacting with any
		// element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// Clicking on the Passengers dropdown
		driver.findElement(By.id("divpaxinfo")).click();
		
		// Increasing the adult count from 1 to 5
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		// Clicking on done
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		// Getting the text from passengers dropdown
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		// Exit browser and quit driver
		driver.quit();
	}

}
