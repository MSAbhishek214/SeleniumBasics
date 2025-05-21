package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownDynamic {

	public static void main(String[] args) throws InterruptedException {

		// Initializing Web driver for Chrome browser
		WebDriver driver = new ChromeDriver();

		// Providing implicit wait to ensure DOM is loaded before interacting with any
		// element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Hard coding wait
		Thread.sleep(5000);

		// Selecting the From drop down and clicking on it
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		// Hard coding wait
		Thread.sleep(3000);

		// Selecting the BLR option
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@text='Bengaluru (BLR)']")).click();

		// Hard coding wait
		Thread.sleep(3000);

		// Selecting the To address and the drop down is automatically selected
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		// closing browser and quitting driver
		driver.quit();

	}

}
