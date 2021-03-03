package testcases;

import static java.time.temporal.ChronoUnit.SECONDS;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class ToolsQAAlertTest1 extends PageObject {

	/**
	 * Page factory
	 */

	@FindBy(css = "#timerAlertButton")
	WebElementFacade alertBtn;

	@Managed
	WebDriver driverObj;

	@Title(value = "To Test the alert wait")
	@Test
	public void alertTest1() {

		// To get the implicit wait we use the getImplicitWaitTimeout()
		System.out.println("Implicit Wait: " + getImplicitWaitTimeout());

		// To get the explicit wait we use the getWaitForTimeOut()
		System.out.println("Wait : " + getWaitForTimeout());

		// To change the implicit wait and explicit wait we can use the following fns

		setImplicitTimeout(10, SECONDS);
		setWaitForTimeout(10000);

		// To get the implicit wait we use the getImplicitWaitTimeout()
		System.out.println("Implicit Wait: " + getImplicitWaitTimeout());

		// To get the explicit wait we use the getWaitForTimeOut()
		System.out.println("Wait : " + getWaitForTimeout());

		getDriver().get("https://demoqa.com/alerts");
		clickOn(alertBtn);

		System.out.println("Alert Text: " + getDriver().switchTo().alert().getText());

	}

}
