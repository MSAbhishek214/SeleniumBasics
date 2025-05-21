package basics;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EComCart {

	public static void main(String[] args) {

		// Initializing Web driver for Chrome browser
		WebDriver driver = new ChromeDriver();

		// Providing implicit wait to ensure DOM is loaded before interacting with any
		// element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to the login practice page
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		// List of items that need to be added to cart
		ArrayList<String> itemsAddToCart = new ArrayList<String>();
		
		// Add items to itemsAddToCart
		itemsAddToCart.add("Cucumber");
		itemsAddToCart.add("Brocolli");
		itemsAddToCart.add("Beetroot");
		itemsAddToCart.add("Beans");
		
		// get all Product Names WebElements
		List<WebElement> productNameWebElements = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		// Storing iteration count in j
		int j = itemsAddToCart.size();
		
		// Run through all product names to check if each item in itemsAddToCart has been fetched.
		for (int i = 0; i < productNameWebElements.size(); i++) {
			String productName = productNameWebElements.get(i).getText().split("-")[0].trim();
			if (itemsAddToCart.contains(productName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j--;
				if (j == 0) break;
			}
		}
		
		// Clicking on cart icon
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		// Clicking on Proceed to Checkout button
		driver.findElement(By.xpath("//div[@class='cart-preview active']/child::div[@class='action-block']/button")).click();
		
		// Applying the promo code as rahulshettyacademy
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		
		// Clicking on Apply button
		driver.findElement(By.className("promoBtn")).click();
		
		// Validating applied promo code success message text
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		
		// Quit driver
		driver.quit();

	}

}
