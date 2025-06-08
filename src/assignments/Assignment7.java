package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {

		// Creating a web driver object for Chrome
		WebDriver driver = new ChromeDriver();

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to given url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Wrap the driver into Javascript Executor object
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// Capture web element for the desired table
		WebElement table = driver.findElement(By.id("product"));
		
		// Scroll the table into view
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", table);
		
		// Capture the number of records in the table
		int rows = driver.findElements(By.cssSelector(".table-display tr")).size();
		
		// Capture the number of columns in the table
		int columns = driver.findElements(By.cssSelector(".table-display th")).size();
		
		System.out.println("Table has " + rows + " rows and " + columns + " columns.");
		
		System.out.println(driver.findElement(By.cssSelector(".table-display tbody tr:nth-child(3)")).getText());
		
		// Quit driver
		driver.quit();

	}

}
