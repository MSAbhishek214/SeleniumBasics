package assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {

		// Creating a web driver object for Chrome
		WebDriver driver = new ChromeDriver();

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to given url
		driver.get("https://the-internet.herokuapp.com/windows");

		// click on the link that opens new window
		driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

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
		
		// Getting the text from second window
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		
		// switch back to first window
		driver.switchTo().window(firstWindow);
		
		// getting the text from first window
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		
		// quit driver
		driver.quit();

	}

}
