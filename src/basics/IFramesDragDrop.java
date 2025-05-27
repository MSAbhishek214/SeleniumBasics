package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IFramesDragDrop {

	public static void main(String[] args) {

		// Creating a web driver object for Chrome
		WebDriver driver = new ChromeDriver();

		// Maximizing screen size
		driver.manage().window().maximize();

		// Navigating to given url
		driver.get("https://jqueryui.com/droppable/");

		// Switch focus to iframe
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

		// Create an Action object for drag and drop
		Actions dragAndDrop = new Actions(driver);

		// Create source and target WebElements for drag and drop
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		// Perform drag and drop function
		dragAndDrop.dragAndDrop(source, target).build().perform();

		// Bring focus back to default content
		driver.switchTo().defaultContent();

		// Print something from main window to ensure driver switched back to default
		// content
		System.out.println(driver.findElement(By.cssSelector("p.desc")).getText());

		// Quit driver
		driver.quit();

	}

}
