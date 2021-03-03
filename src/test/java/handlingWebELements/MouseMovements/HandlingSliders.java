package handlingWebELements.MouseMovements;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class HandlingSliders extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "To illustrate how to handle the sliders using the withActions API method called dragAndDropBy(WebElement,x-axis,y-axis)")
	@Test
	public void slidersTest1() throws InterruptedException {
		driverObj.get("https://jqueryui.com/slider/");

		driverObj.switchTo().frame(0);
		WebElementFacade sliderDiv = $("//*[@id=\"slider\"]");
		WebElementFacade sliderSpan = $("//div[@id = 'slider']//span");

		/**
		 * To get the size of the slider div we can use the below function
		 */

		int totalWidth = sliderDiv.getSize().getWidth();

		System.out.println("Total width:" + totalWidth);
		System.out.println("Width half:" + totalWidth / 2);

		withAction().dragAndDropBy(sliderSpan, totalWidth / 2, 0).perform();

		Thread.sleep(3000);

		withAction().dragAndDropBy(sliderSpan, -totalWidth / 2, 0).perform();
		Thread.sleep(3000);

	}

	@Title(value = "Move the slider to the max")
	@Test
	public void slidersTest2() throws InterruptedException {
		driverObj.get("https://jqueryui.com/slider/");

		driverObj.switchTo().frame(0);
		WebElementFacade sliderDiv = $("//*[@id=\"slider\"]");
		WebElementFacade sliderSpan = $("//div[@id = 'slider']//span");

		/**
		 * To get the size of the slider div we can use the below function
		 */

		int totalWidth = sliderDiv.getSize().getWidth();

		System.out.println("Total width:" + totalWidth);

		withAction().dragAndDropBy(sliderSpan, totalWidth, 0).perform();

		Thread.sleep(3000);

	}

}
