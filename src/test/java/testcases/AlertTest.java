package testcases;

import java.time.Duration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class AlertTest extends PageObject {

	@Managed(driver = "firefox")
	WebDriver driverObj;

	@Title(value = "Accept alert : Test for wait")
	@Test
	public void test1() {
		driverObj.get("https://demoqa.com/alerts");
		driverObj.findElement(By.xpath("//*[@id=\"timerAlertButton\"]")).click();

		Alert alert = driverObj.switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
		alert.accept();
	}

	@Title(value = "dismiss alert : Test for wait")
	@Test
	public void test2() {
		driverObj.get("https://demoqa.com/alerts");
		driverObj.findElement(By.xpath("//*[@id=\"timerAlertButton\"]")).click();

		Alert alert = driverObj.switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
		alert.dismiss();
	}

	@Title(value = "Accept alert : Test for explicit wait")
	@Test
	public void test3() {
		driverObj.get("https://demoqa.com/alerts");
		driverObj.findElement(By.xpath("//*[@id=\"timerAlertButton\"]")).click();

		waitForCondition().withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
				.until(ExpectedConditions.alertIsPresent());
		Alert alert = driverObj.switchTo().alert();

		System.out.println("Alert Text: " + alert.getText());
		alert.accept();
	}

	@Title(value = "Dismiss alert : Test for explicit wait")
	@Test
	public void test4() {
		driverObj.get("https://demoqa.com/alerts");
		driverObj.findElement(By.xpath("//*[@id=\"timerAlertButton\"]")).click();

		waitForCondition().withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
				.until(ExpectedConditions.alertIsPresent());
		Alert alert = driverObj.switchTo().alert();

		System.out.println("Alert Text: " + alert.getText());
		alert.dismiss();
	}

	@Title(value = "Accept alert : Test for explicit wait")
	@Test
	public void test5() {
		driverObj.get("https://demoqa.com/alerts");
		// driverObj.findElement(By.xpath("//*[@id=\"timerAlertButton\"]")).click();

		waitForCondition()
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("Exception while trying to get the alert, tried for 10 seconds, but no alert displayed")
				.until(ExpectedConditions.alertIsPresent());
		Alert alert = driverObj.switchTo().alert();

		System.out.println("Alert Text: " + alert.getText());
		alert.dismiss();
	}

}
