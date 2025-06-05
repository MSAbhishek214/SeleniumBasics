package basics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class Locators {

	public static void main(String[] args) throws InterruptedException {

		// Initializing WebDriver for Chrome browser
		WebDriver driver = new ChromeDriver();

		// Setting implicit wait for 5 seconds (to handle dynamic elements)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		// Selecting username input field using ID selector
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");

		// Selecting password input field using Name selector
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");

		// Clicking sign-in button using Class Name selector
		driver.findElement(By.className("signInBtn")).click();

		// Fetching error message text using CSS Selector (Tag + Class)
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		// Clicking "Forgot your password?" link using Link Text selector
		driver.findElement(By.linkText("Forgot your password?")).click();

		// Pausing execution for 1 second to allow form elements to load
		Thread.sleep(1000);

		// Entering name in input field using XPath (Attribute-based selection)
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

		// Entering email in input field using CSS Selector (Attribute-based selection)
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

		// Clearing an input field using XPath (Indexed selection)
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

		// Entering new email in input field using CSS Selector (nth-child pseudo-class)
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

		// Entering phone number in input field using XPath (Parent-child relationship)
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

		// Clicking reset password button using CSS Selector (Class-based)
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		// Fetching password reset confirmation message using CSS Selector (Tag +
		// Descendant selection)
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		// Clicking "Go to login" button using XPath (Class-based, indexed button
		// selection)
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		// Pausing execution for 1 second to allow page transition
		Thread.sleep(1000);

		// Entering username again using CSS Selector (ID-based selection)
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

		// Entering password using CSS Selector (Attribute contains selector)
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		// Clicking checkbox using ID selector
		driver.findElement(By.id("chkboxOne")).click();

		// Clicking submit button using XPath (Contains function for class-based search)
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}
}