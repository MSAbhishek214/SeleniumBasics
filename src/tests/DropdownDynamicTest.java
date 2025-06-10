package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DropdownDynamicTest extends SetupAndTearDown {

	@Test
	public void validateDynamicDropdown() {
		// Selecting the From drop down and clicking on it
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		// Selecting the BLR option
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@text='Bengaluru (BLR)']"))
				.click();
		// Wait until the From Drop down closes and To dropdown appears
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")));
		// Selecting the To address and the drop down is automatically selected
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
	}

}
