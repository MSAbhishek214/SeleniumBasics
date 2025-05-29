package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalendars {

	public static void main(String[] args) {

		// Define Month, Year and Day
		String month = "May";
		String year = "2027";
		String day = "14";

		// Creating a web driver object for Chrome
		WebDriver driver = new ChromeDriver();

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to given url
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Select the date picker button and click on it
		driver.findElement(By.cssSelector(".react-date-picker__calendar-button.react-date-picker__button")).click();

		// Click once on the Month and Year selection button
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		// Click again for year selection
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		// Select year 2027
		driver.findElement(By.xpath("//button[normalize-space()='" + year + "']")).click();

		// Select month as May
		driver.findElement(By.xpath("//button[normalize-space()='" + month + "']")).click();

		// Select day as 14
		driver.findElement(By.xpath("//button/abbr[normalize-space()='" + day + "']")).click();

		// Quit driver
		driver.quit();

	}

}
