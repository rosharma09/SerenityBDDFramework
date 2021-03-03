
package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)

public class LoginTest1 {

	@Managed
	private WebDriver driverObj;

	/**
	 * To mark the title of the test in serenity, we can use the @Title annotation
	 * to specify the title of the test which will be displayed in the serenity
	 * report
	 * 
	 */
	@Title(value = "To get the title of the page")

	@Test
	public void getTitleTest() {
		driverObj.get("https://www.google.com");
		System.out.println("The Title of the page is: " + driverObj.getTitle());

	}

}
