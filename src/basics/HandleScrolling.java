package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleScrolling {

	public static void main(String[] args) {

		// Creating a web driver object for Chrome
		WebDriver driver = new ChromeDriver();

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to given url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Create a JS Executor to handle window scrolling actions
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		// Get the web element for the table
		WebElement table = driver.findElement(By.className("tableFixHead"));
		
		// Scroll window until the table is in focus
		jse.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", table);
		
		
		
		
		// quit driver
		

	}

}
