package testcases;

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
public class LoginTest3 extends PageObject {

	@Managed
	WebDriver driverObj;

	/**
	 * Page factory for the login page
	 */

	@FindBy(id = "email")
	WebElementFacade emailField;

	@FindBy(id = "passwd")
	WebElementFacade pwdField;

	@Title(value = "Enter the username and password using type()")
	@Test
	public void doLogin() {

		open(); // open the browser with the default base url

		if (emailField.isDisplayed() && pwdField.isDisabled()) {
			emailField.type("automationuser01@gmail.com");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pwdField.type("password01");
		}

		else {
			System.out.println("Elements Not present");
		}

	}

	@Title(value = "Enter the username and password using typeAndTab()")
	@Test
	public void doLogin2() {

		open(); // open the browser with the default base url

		if (emailField.isDisplayed() && pwdField.isDisabled()) {
			emailField.typeAndTab("automationuser01@gmail.com");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pwdField.type("password01");
		}

		else {
			System.out.println("Elements Not present");
		}

	}

	@Title(value = "Enter the username and password using typeAndEnter()")
	@Test
	public void doLogin3() {

		open(); // open the browser with the default base url

		if (emailField.isDisplayed() && pwdField.isDisabled()) {
			emailField.typeAndTab("automationuser01@gmail.com");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pwdField.typeAndEnter("password01");

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		else {
			System.out.println("Elements Not present");
		}

	}
	
	
	@Title(value = "Check the username and password using WebElemenetFacade")
	@Test
	public void checkFields() {

		open(); // open the browser with the default base url

		emailField.shouldBeCurrentlyVisible();
		emailField.shouldBeEnabled();
		emailField.shouldBePresent();
		
		pwdField.shouldBeCurrentlyVisible();
		pwdField.shouldBeEnabled();
		pwdField.shouldBePresent();

	}


}
