package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsJS {

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

		// Providing value to the Input box meant for alerts
		driver.findElement(By.id("name")).sendKeys("Dark");

		// Clicking on alert button
		driver.findElement(By.id("alertbtn")).click();

		// Getting the alert dialog content
		System.out.println(driver.switchTo().alert().getText());

		// Clicking OK on the alert dialog box
		driver.switchTo().alert().accept();

		// Providing value to the Input box meant for alerts
		driver.findElement(By.id("name")).sendKeys("Dark");

		// Clicking on Confirm button
		driver.findElement(By.id("confirmbtn")).click();

		// Getting the alert dialog content
		System.out.println(driver.switchTo().alert().getText());

		// Clicking OK on the alert dialog box
		driver.switchTo().alert().accept();

		// Providing value to the Input box meant for alerts
		driver.findElement(By.id("name")).sendKeys("Dark");

		// Clicking on Confirm button
		driver.findElement(By.id("confirmbtn")).click();

		// Getting the alert dialog content
		System.out.println(driver.switchTo().alert().getText());

		// Clicking OK on the alert dialog box
		driver.switchTo().alert().dismiss();

		// Quit driver
		driver.quit();

	}

}
