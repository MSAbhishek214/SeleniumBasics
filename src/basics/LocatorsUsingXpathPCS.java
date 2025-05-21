package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorsUsingXpathPCS {

	public static void main(String[] args) throws InterruptedException {

		// Creating a string variable to hold name
		String name = "Abhi";

		// Initializing Webdriver for Chrome browser
		WebDriver driver = new ChromeDriver();

		// Providing implicit wait to ensure DOM is loaded before interacting with any
		// element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		// Selecting User name input field using ID selector and send value
		driver.findElement(By.xpath("//form/h1/following-sibling::input[1]")).sendKeys("Abhishek");

		// Selecting Password input field using ID selector and send value
		driver.findElement(By.xpath("//form/h1/following-sibling::input[2]")).sendKeys("pass123");

		// Clicking on sign in button
		driver.findElement(By.xpath("//form/button")).click();

		// Validating sign in button was clicked
		System.out.println(driver.findElement(By.xpath("//form/p")).getText());

		// Clicking on Forgot your password link
		driver.findElement(By.xpath("//form/div[2]/a")).click();

		// Selecting user name input field and sending value
		driver.findElement(By.xpath("//form/h2/following-sibling::input[1]")).sendKeys("Abhi");

		// Selecting email input field and sending value
		driver.findElement(By.xpath("//form/h2/following-sibling::input[2]")).sendKeys("abhi@ymail.com");

		// Selecting phone number input field and sending value
		driver.findElement(By.xpath("//form/h2/following-sibling::input[3]")).sendKeys("8965698965");

		Thread.sleep(1000);

		// Clicking on reset login button
		driver.findElement(By.xpath("//form/div/button[2]")).click();

		// Validating reset was successful using text shown upon clicking reset login
		// button
		System.out.println(driver.findElement(By.xpath("//form/h2/following-sibling::p")).getText());

		// Clicking on go to login
		driver.findElement(By.xpath("//form/div/button[1]")).click();

		Thread.sleep(1000);

		// Selecting User name input field using ID selector and send value
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Abhi");

		// Selecting Password input field using ID selector and send value
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");

		// Checking the box Remember my username
		driver.findElement(By.xpath("//form/div/span[1]")).click();

		// Checking the box for agreeing terms and privacy policy
		driver.findElement(By.xpath("//form/div/span[2]/input")).click();

		// Clicking on sign in button
		driver.findElement(By.xpath("//form/button")).click();
		
		Thread.sleep(1000);

		// Validating log in was successful using text shown upon clicking sign in
		// button
		System.out.println(driver.findElement(By.xpath("//div/p")).getText());

		// Asserting the first line text using testNG
		Assert.assertEquals(driver.findElement(By.xpath("//div/h2")).getText(),
				"Hello " + name + ",");

		// clicking on the log out button
		driver.findElement(By.xpath("//div/button")).click();
		
		// Validating logout was successful by getting text from logged out page
		System.out.println(driver.findElement(By.xpath("//form/h1")).getText());

		// Close all browser instances and quit driver
		driver.quit();
	}

}
