package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) {

		// Creating a web driver object for Chrome
		WebDriver driver = new ChromeDriver();

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to given url
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		// First switch focus to inner nested frame frame top
		driver.switchTo().frame("frame-top");
		
		// Switch focus to frame where MIDDLE is located and get text
		driver.switchTo().frame("frame-middle");
		
		// Print the text to console
		System.out.println(driver.findElement(By.id("content")).getText());
		
		// Quit driver
		driver.quit();

	}

}
