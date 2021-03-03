package handlingWebELements.Dropdown;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class PrintingValuesDropdown extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "Print dropdown option text at index 0 - using findAll(By.tagName(\"options\"))")
	@Test
	public void printValuesTest1() {
		driverObj.get("https://www.wikipedia.org/");
		List<WebElementFacade> dropdownValues = findAll(By.tagName("option"));

		// To print the text of the option at index 0
		System.out.println("Value at index 0: " + dropdownValues.get(0).getText());

		System.out.println("Total Values identified: " + dropdownValues.size());
	}

	@Title(value = "Print dropdown option text at the last index - using findAll(By.tagName(\"options\"))")
	@Test
	public void printValuesTest2() {
		driverObj.get("https://www.wikipedia.org/");
		List<WebElementFacade> dropdownValues = findAll(By.tagName("option"));

		// To print the text of the option at index 0

		System.out.println("Value at index " + (dropdownValues.size() - 1) + ":"
				+ dropdownValues.get(dropdownValues.size() - 1).getText());

		System.out.println("Total Values identified: " + dropdownValues.size());

	}

	@Title(value = "Print all the dropdown text - using findAll(By.tagName(\"options\")) and using for loop to print the values")
	@Test
	public void printValuesTest3() {
		driverObj.get("https://www.wikipedia.org/");
		List<WebElementFacade> dropdownValues = findAll(By.tagName("option"));

		// To print the text of the option at index 0

		System.out.println("Values printed from test 3");

		for (int i = 0; i < dropdownValues.size(); i++) {
			System.out.println("The text at option [" + (i + 1) + "] :" + dropdownValues.get(i).getText());
		}

		System.out.println("Total Values identified: " + dropdownValues.size());

	}

	@Title(value = "Print all the dropdown text - using findAll(By.tagName(\"options\")) and using for each loop")
	@Test
	public void printValuesTest4() {
		driverObj.get("https://www.wikipedia.org/");
		List<WebElementFacade> dropdownValues = findAll(By.tagName("option"));

		// To print the text of the option at index 0

		System.out.println("Values printed from test 4");
		int i = 1;

		for (WebElementFacade value : dropdownValues) {
			System.out.println("The text at option [" + i + "] :" + value.getText());
			i++;
		}

		System.out.println("Total Values identified: " + dropdownValues.size());

	}

	@Title(value = "Print all the dropdown text - using findAll(By.xpath(\"//select[@id = 'searchLanguage']//option\")) and using for each loop")
	@Test
	public void printValuesTest5() {
		driverObj.get("https://www.wikipedia.org/");
		List<WebElementFacade> dropdownValues = findAll(By.xpath("//select[@id = 'searchLanguage']//option"));

		// To print the text of the option at index 0

		System.out.println("Values printed from test 5");
		int i = 1;

		for (WebElementFacade value : dropdownValues) {
			System.out.println("The text at option [" + i + "] :" + value.getText());
			i++;
		}

		System.out.println("Total Values identified: " + dropdownValues.size());
	}

	@Title(value = "Print all the values of the options - using findAll(By.xpath(\"//select[@id = 'searchLanguage']//option\")) and using for each loop")
	@Test
	public void printValuesTest6() {
		driverObj.get("https://www.wikipedia.org/");
		List<WebElementFacade> dropdownValues = findAll(By.xpath("//select[@id = 'searchLanguage']//option"));

		// To print the text of the option at index 0

		System.out.println("Values printed from test 6");
		int i = 1;

		for (WebElementFacade value : dropdownValues) {
			System.out.println("The Value at option [" + i + "] :" + value.getAttribute("value"));
			i++;
		}

		System.out.println("Total Values identified: " + dropdownValues.size());
	}

	@Title(value = "Print all the lang of the options - using findAll(By.xpath(\"//select[@id = 'searchLanguage']//option\")) and using for each loop")
	@Test
	public void printValuesTest7() {
		driverObj.get("https://www.wikipedia.org/");
		List<WebElementFacade> dropdownValues = findAll(By.xpath("//select[@id = 'searchLanguage']//option"));

		// To print the text of the option at index 0

		System.out.println("Values printed from test 7");
		int i = 1;

		for (WebElementFacade value : dropdownValues) {
			System.out.println("The Value at option [" + i + "] :" + value.getAttribute("lang"));
			i++;
		}

		System.out.println("Total Values identified: " + dropdownValues.size());
	}

	@Title(value = "Print all the options- using find(By.xpath(\"\")) and using for each loop")
	@Test
	public void printValuesTest8() {
		driverObj.get("https://www.wikipedia.org/");
		List<String> optionsList = find(By.xpath("//select[@id = 'searchLanguage']")).getSelectOptions();
		// To print the text of the option at index 0

		System.out.println("Values printed from test 8");
		int i = 1;

		for (String option : optionsList) {
			System.out.println("The Value at option [" + i + "] :" + option);
			i++;
		}

		System.out.println("Total Values identified: " + optionsList.size());
	}
	
	@Title(value = "To check the selected option text")
	@Test
	public void printValuesTest9() {
		driverObj.get("https://www.wikipedia.org/");
		find(By.xpath("//select[@id = 'searchLanguage']")).selectByVisibleText("العربية");
		// To print the text of the option at index 0

		System.out.println("The selected option text: "+find(By.xpath("//select[@id = 'searchLanguage']")).getSelectedVisibleTextValue());
	}
	
	@Title(value = "To check the selected option value")
	@Test
	public void printValuesTest10() {
		driverObj.get("https://www.wikipedia.org/");
		find(By.xpath("//select[@id = 'searchLanguage']")).selectByVisibleText("العربية");
		// To print the text of the option at index 0

		System.out.println("The selected option value: "+find(By.xpath("//select[@id = 'searchLanguage']")).getSelectedValue());
		
		
	}
	
	@Title(value = "Print all the dropdown text - using thenFindAll() and using for each loop")
	@Test
	public void printValuesTest11() {
		driverObj.get("https://www.wikipedia.org/");
		
		
		WebElementFacade selectDropdown = find(By.xpath("//select[@id = 'searchLanguage']"));
		List<WebElementFacade>  dropdownValues = selectDropdown.thenFindAll(By.tagName("option"));

		// To print the text of the option at index 0

		System.out.println("Values printed from test 11");
		int i = 1;

		for (WebElementFacade value : dropdownValues) {
			System.out.println("The text at option [" + i + "] :" + value.getText());
			i++;
		}

		System.out.println("Total Values identified: " + dropdownValues.size());
	}
}
