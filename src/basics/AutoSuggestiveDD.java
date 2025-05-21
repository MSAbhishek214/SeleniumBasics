package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDD {

	public static void main(String[] args) throws InterruptedException {

		// Initializing Web driver for Chrome browser
		WebDriver driver = new ChromeDriver();

		// Providing implicit wait to ensure DOM is loaded before interacting with any
		// element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Hard coding wait
		Thread.sleep(5000);

		// Clicking on the country input box and type IND
		driver.findElement(By.id("autosuggest")).click();

		// Typing ind in the box to get auto suggestions
		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		// Hard coding wait
		Thread.sleep(3000);

		// Finding the list of elements that are auto suggested
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1'] //a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		Thread.sleep(2000);

		// Checking if India was populated in the input box
		System.out.println(driver.findElement(By.xpath("//input[@id='autosuggest']")).getDomProperty("value"));
		
		Thread.sleep(3000);

		// Close and quit driver
		driver.quit();

	}

}
