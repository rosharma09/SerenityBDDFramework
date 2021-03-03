package handlingWebELements.Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDrowdownUsingSelenium {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/windows/chrome/chromedriver.exe");
		WebDriver driverObj = new ChromeDriver();

		driverObj.manage().window().maximize();
		driverObj.get("https://www.wikipedia.org/");

		WebElement langSelectDropdown = driverObj.findElement(By.id("searchLanguage"));

		/**
		 * In order to handle the dropdown in case of selenium we need to use the select
		 * class object and pass the select type webelement as the parameter
		 */

		Select selectObj = new Select(langSelectDropdown);

		/**
		 * In selenium we can select the option in the dropdown by the following ways
		 * 
		 */

		/**
		 * 1. Select By visible text
		 */

		selectObj.selectByVisibleText("Suomi");
		Thread.sleep(3000);

		/**
		 * 2. Select by value
		 */

		selectObj.selectByValue("simple");
		Thread.sleep(3000);

		/**
		 * 3. Select by index 0 -> denotes the first option in the dropdown 1 -> denotes
		 * the second option in the dropdown and so on
		 */

		selectObj.selectByIndex(0);
		Thread.sleep(3000);

		driverObj.quit();
	}

}
