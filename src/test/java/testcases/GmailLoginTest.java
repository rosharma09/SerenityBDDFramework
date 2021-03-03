package testcases;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.Duration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class GmailLoginTest extends PageObject {

	@Managed(driver = "firefox")
	WebDriver driverObj;

	@Title(value = "Test1 : with no wait")
	@Test
	public void test1() {

		driverObj.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		typeInto($("//*[@id=\"identifierId\"]"), "rosharma0906@gmail.com");
		clickOn($("//*[@id=\"identifierNext\"]/div/button"));
		typeInto($("//*[@id=\"password\"]/div[1]/div/div[1]/input"), "qwerty");
	}

	@Title(value = "Test1 : with implicit wait defined")
	@Test
	public void test2() {

		driverObj.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		setImplicitTimeout(10, SECONDS);

		typeInto($("//*[@id=\"identifierId\"]"), "rosharma0906@gmail.com");
		clickOn($("//*[@id=\"identifierNext\"]/div/button"));
		typeInto($("//*[@id=\"password\"]/div[1]/div/div[1]/input"), "qwerty");
	}

	@Title(value = "Test3 : with explicit wait defined")
	@Test
	public void test3() {

		driverObj.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		setWaitForTimeout(10000);

		typeInto($("//*[@id=\"identifierId\"]"), "rosharma0906@gmail.com");
		clickOn($("//*[@id=\"identifierNext\"]/div/button"));
		typeInto($("//*[@id=\"password\"]/div[1]/div/div[1]/input"), "qwerty");
	}

	@Title(value = "Test4 : with explicit wait condition for presence")
	@Test
	public void test4() {

		driverObj.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		setWaitForTimeout(10000);

		typeInto($("//*[@id=\"identifierId\"]"), "rosharma0906@gmail.com");
		clickOn($("//*[@id=\"identifierNext\"]/div/button"));
		// waitForCondition().until(ExpectedConditions.presenceOfElementLocated.($("//*[@id=\"password\"]/div[1]/div/div[1]/input"));

		waitForCondition().until(
				ExpectedConditions.presenceOfElementLocated(find("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
	}
	
	@Title(value = "Test5 : with explicit wait condition for clickable")
	@Test
	public void test5() {

		driverObj.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		setWaitForTimeout(10000);

		typeInto($("//*[@id=\"identifierId\"]"), "rosharma0906@gmail.com");
		clickOn($("//*[@id=\"identifierNext\"]/div/button"));
		// waitForCondition().until(ExpectedConditions.presenceOfElementLocated.($("//*[@id=\"password\"]/div[1]/div/div[1]/input"));

		waitForCondition().until(ExpectedConditions.elementToBeClickable(By.xpath(""))); // this is by locator
	}
	
	@Title(value = "Test6 : with fluent wait condition for clickable")
	@Test
	public void test6() {

		driverObj.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		setWaitForTimeout(10000);

		typeInto($("//*[@id=\"identifierId\"]"), "rosharma0906@gmail.com");
		clickOn($("//*[@id=\"identifierNext\"]/div/button"));
		// waitForCondition().until(ExpectedConditions.presenceOfElementLocated.($("//*[@id=\"password\"]/div[1]/div/div[1]/input"));

		//waitForCondition().until(ExpectedConditions.elementToBeClickable(By.xpath(""))); // this is by locator
	
		waitForCondition().withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.alertIsPresent());
	}

}
