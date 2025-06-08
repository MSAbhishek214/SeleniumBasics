package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {

		// Creating a web driver object for Chrome
		WebDriver driver = new ChromeDriver();

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to given url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Select the option 2 checkbox
		driver.findElement(By.id("checkBoxOption2")).click();

		// Get text from the selected checkbox
		String checkBoxValue = driver.findElement(By.id("checkBoxOption2")).getDomProperty("value");

		// Create a select object to deal with the dropdown values
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));

		// Select dropdown value based on text that was retrieved from selected checkbox
		dropdown.selectByValue(checkBoxValue);

		// Enter the same checkBoxValue in the alert input box
		driver.findElement(By.id("name")).sendKeys(checkBoxValue);

		// Click on Alert button
		driver.findElement(By.id("alertbtn")).click();

		// Switch focus to alert
		System.out.println(driver.switchTo().alert().getText().split(",")[0].split(" ")[1]);

		// Quit driver
		driver.quit();

	}

}
