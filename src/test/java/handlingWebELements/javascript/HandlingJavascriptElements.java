package handlingWebELements.javascript;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class HandlingJavascriptElements extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "Using java script to higlight elements on the UI")
	@Test
	public void jsTest1() throws InterruptedException {

		driverObj.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_myfirst");

		driverObj.switchTo().frame("iframeResult");

		evaluateJavascript("arguments[0].style.border='3px solid white'", $("/html/body/h2"));

	}
}
