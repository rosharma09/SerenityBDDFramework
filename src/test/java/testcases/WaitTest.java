package testcases;

import static java.time.temporal.ChronoUnit.SECONDS;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class WaitTest extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "To check the waits")
	@Test
	public void waitTest() {
		System.out.println("Default Timeouts: Defined in serenity.properties");
		System.out.println("Implicit Wait: " + getImplicitWaitTimeout());
		System.out.println("Explicit Wait: " + getWaitForTimeout());

		System.out.println("After Chaning the timeouts");
		setImplicitTimeout(20, SECONDS);
		setWaitForTimeout(10000);
		System.out.println("Implicit Wait: " + getImplicitWaitTimeout());
		System.out.println("Explicit Wait: " + getWaitForTimeout());
		
		System.out.println("After Reset");
		resetImplicitTimeout();
	
		System.out.println("Implicit Wait: " + getImplicitWaitTimeout());
		System.out.println("Explicit Wait: " + getWaitForTimeout());

	}

}
