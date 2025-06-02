package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class FriendlyLocators {

	public static void main(String[] args) {

		// Initializing Web driver for Chrome browser
		WebDriver driver = new ChromeDriver();

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// Get the name input box web element
		WebElement nameInputBox = driver.findElement(By.name("name"));
		
		// Find the Name label by using element above name input box
		System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameInputBox)).getText());
		
		// Quit driver
		driver.quit();
		
	}

}
