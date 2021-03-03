package handlingWebELements.webtables;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.pages.components.HtmlTable;

@RunWith(SerenityRunner.class)
public class HandlingWebTablesUsingSerenity extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "To Print all the header name of the table using the HtmlTable class")
	@Test
	public void webtableTest1() {
		driverObj.get("https://money.rediff.com/gainers/bse/daily/groupa");

		/**
		 * In order to work with the web tables in serenity, we can use the object of
		 * the HtmlTable class
		 */

		HtmlTable table = new HtmlTable($("//table[@class = 'dataTable']"));

		List<String> headers = table.getHeadings();

		System.out.println("Output from the test 1");
		for (String header : headers) {
			System.out.println("Header value:" + header);
		}

	}

	@Title(value = "To Print all the rows of the table using the HtmlTable class")
	@Test
	public void webtableTest2() {
		driverObj.get("https://money.rediff.com/gainers/bse/daily/groupa");

		/**
		 * In order to work with the web tables in serenity, we can use the object of
		 * the HtmlTable class
		 */

		HtmlTable table = new HtmlTable($("//table[@class = 'dataTable']"));

		List<WebElement> rows = table.getRowElements();

		System.out.println("Output from the test 1");
		for (WebElement row : rows) {
			System.out.println("Row value:" + row.getText());
		}

	}

	@Title(value = "To store the data displayed on the UI in a List<Map<String , String>>")
	@Test
	public void webtableTest3() {
		driverObj.get("https://money.rediff.com/gainers/bse/daily/groupa");

		/**
		 * In order to work with the web tables in serenity, we can use the object of
		 * the HtmlTable class
		 */

//		HtmlTable table = new HtmlTable($("//table[@class = 'dataTable']"));
//
//		List<Map<String, String>> tableData = new ArrayList<>();
//		Map<String, String> rowData;
//
//		for (int i = 0; i < table.getRowElements().size(); i++) {
//			rowData = new HashMap<String, String>();
//
//			for (int j = 0; j < table.getHeadings().size(); j++) {
//				rowData.put(table.getHeadings().get(j),
//						table.getRowElements().get(i).findElements(By.tagName("td")).get(j).getText());
//			}
//
//			tableData.add(rowData);
//		}
//
//		System.out.println("Below is the table data displayed");
//		for(Map<String , String> data : tableData) {
//			System.out.println(data);
//		}
	}
	
	
	@Title(value = "Print all the values in the table")
	@Test
	public void webTablesTest4() {
		
		driverObj.get("https://www.w3schools.com/html/html_tables.asp");
		
		HtmlTable table = new HtmlTable($("//table[@id = 'customers']"));
		
		for(WebElement row : table.getRowElements()) {
			System.out.println(row.getText());
		}
	}

}
