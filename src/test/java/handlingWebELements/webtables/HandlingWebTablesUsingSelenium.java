package handlingWebELements.webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWebTablesUsingSelenium {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/windows/chrome/chromedriver.exe");
		WebDriver driverObj = new ChromeDriver();

		driverObj.manage().window().maximize();
		driverObj.get("https://money.rediff.com/gainers/bse/daily/groupa");

		/**
		 * Below is the mechanism by which we are going to handle the web tables using
		 * selenium
		 */

		WebElement table = driverObj.findElement(By.xpath("//table[@class = 'dataTable']"));

		WebElement tableHeader = table.findElement(By.tagName("thead"));
		WebElement tableBody = table.findElement(By.tagName("tbody"));

		/**
		 * Working with the table header
		 */

		WebElement tableHeaderRow = tableHeader.findElement(By.tagName("tr"));

		System.out.println("Tables Header: " + tableHeaderRow.getText());

		List<WebElement> tableHeaderRowColumns = tableHeaderRow.findElements(By.tagName("th"));

		for (WebElement header : tableHeaderRowColumns) {
			System.out.println("Header Value:" + header.getText());
		}

		/**
		 * Working with the table rows
		 */

		List<WebElement> tableRows = tableBody.findElements(By.tagName("tr"));

		// To print the number of rows

		System.out.println("Total rows displayed : " + tableRows.size());

		// To print the content of each of the row
		int rowCount = 0;
		for (WebElement row : tableRows) {

			System.out.println("Row no" + (++rowCount) + ": " + row.getText());
		}

		/**
		 * We are going to store these data in the form of key-value pair
		 */

		driverObj.quit();
	}

}
