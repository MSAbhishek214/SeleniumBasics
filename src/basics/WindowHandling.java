package basics;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {

	public static void main(String[] args) {

		// Creating a web driver object for Chrome
		WebDriver driver = new ChromeDriver();

		// Maximizing screen size
		driver.manage().window().maximize();

		// Creating a web driver wait for explicit waits
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Navigating to given url
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// Clicking on "Free Access to InterviewQues/ResumeAssistance/Material" link
		driver.findElement(By.partialLinkText("Free Access to InterviewQues")).click();

		// Get the window handles set
		Set<String> windows = driver.getWindowHandles();

		// Creating an iterator to have the handles assigned to individual windows
		Iterator<String> it = windows.iterator();

		// Assigning first handle to parent window
		String firstWindow = it.next();

		// Assigning first handle to parent window
		String secondWindow = it.next();

		// switch to the second window
		driver.switchTo().window(secondWindow);

		// get text from the paragraph having email id
		String emailId = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];

		// Switch focus back to first window
		driver.switchTo().window(firstWindow);

		// pass the email id value to username field
		driver.findElement(By.id("username")).sendKeys(emailId);

		// wait until the element is visible
		wait.until(ExpectedConditions.attributeContains(By.id("username"), "value", emailId));

		// print out the username field value to check if it passed
		System.out.println(driver.findElement(By.id("username")).getDomProperty("value"));

		// Quit driver
		driver.quit();

	}

}
