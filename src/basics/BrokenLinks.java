package basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {

		// Initializing Web driver for Chrome browser
		WebDriver driver = new ChromeDriver();
		
		// Create a soft assert object
		SoftAssert softAssert = new SoftAssert();

		// Maximizing screen size
		driver.manage().window().maximize();
		
		// Create a Javascript Executor object
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Get a list of all links in footer
		List<WebElement> footerLinks = driver.findElements(By.cssSelector("#gf-BIG a"));
		
		for (WebElement footerLink: footerLinks) {
			
			String link = (String) jse.executeScript("return arguments[0].href", footerLink);
			System.out.println(link);
			URI uri = new URI(link);
			URL url = uri.toURL();
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			
			int responseCode = connection.getResponseCode();
			System.out.println(responseCode);
			
			softAssert.assertTrue(responseCode < 400, "The link with text " + footerLink.getText() + " is broken.");
			
		}
		
		softAssert.assertAll();
		
		// Quit Driver
		driver.quit();
	}

}
