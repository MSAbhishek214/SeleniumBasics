package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorsUsingXpath {

	public static void main(String[] args) throws InterruptedException {

		// Creating a string variable to hold name
		String name = "Abhi";

		// Initializing Webdriver for Chrome browser
		WebDriver driver = new ChromeDriver();

		// Providing implicit wait to ensure DOM is loaded before interacting with any
		// element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		// Selecting User name input field using ID selector and send value
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Abhishek");

		// Selecting Password input field using ID selector and send value
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("pass123");

		// Clicking on sign in button
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

		// Validating sign in button was clicked
		System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());

		// Clicking on Forgot your password link
		driver.findElement(By.xpath("//div[@class='forgot-pwd-container']/a")).click();

		// Selecting user name input field and sending value
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Abhi");

		// Selecting email input field and sending value
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abhi@ymail.com");

		// Selecting phone number input field and sending value
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("8965698965");

		Thread.sleep(1000);

		// Clicking on reset login button
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();

		// Validating reset was successful using text shown upon clicking reset login
		// button
		System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());

		// Clicking on go to login
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();

		Thread.sleep(1000);

		// Selecting User name input field using ID selector and send value
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Abhi");

		// Selecting Password input field using ID selector and send value
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");

		// Checking the box Remember my username
		driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();

		// Checking the box for agreeing terms and privacy policy
		driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();

		// Clicking on sign in button
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

		// Validating log in was successful using text shown upon clicking sign in
		// button
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());

		// Asserting the first line text using testNG
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),
				"Hello " + name + ",");

		// clicking on the log out button
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();

		// Close all browser instances and quit driver
		driver.quit();

	}

}
