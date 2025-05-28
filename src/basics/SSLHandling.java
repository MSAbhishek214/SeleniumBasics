package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLHandling {

	public static void main(String[] args) {

		// Create ChromeOptions object to handle Browser related setup
		ChromeOptions options = new ChromeOptions();
		
		// Bypass bad ssl certs using options
		options.setAcceptInsecureCerts(true);
		
		// Initializing Web driver for Chrome browser
		WebDriver driver = new ChromeDriver(options);

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to the login practice page
		driver.get("https://expired.badssl.com/");
		
		// Get the page title and print it to console
		System.out.println(driver.getTitle());
		
		// Quitting driver
		driver.quit();

	}

}
