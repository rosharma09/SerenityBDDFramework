package handlingWebELements.MouseMovements;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class HandleMouseRightClick extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "This test is to illustrate the right click on webelement")
	@Test
	public void rightClickTest1() throws InterruptedException {
		driverObj.get("https://deluxe-menu.com/popup-mode-sample.html");

		/**
		 * In order to right click on any of the web element we can use the
		 * contextClick() method and pass the webelement as the argument
		 */
		
		$("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img").isDisplayed();
		withAction().contextClick($("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"))
				.perform();
		
		Thread.sleep(2000);
		
		withAction().moveToElement($("//*[@id=\"dm2m1i1tdT\"]")).perform();
		System.out.println("Mouse Over element : " + $("//*[@id=\"dm2m1i1tdT\"]").getText());
		Thread.sleep(2000);

		withAction().moveToElement($("//*[@id=\"dm2m2i1tdT\"]")).perform();
		System.out.println("Mouse Over element : " +$("//*[@id=\"dm2m2i1tdT\"]").getText());
		Thread.sleep(2000);
		
		System.out.println("Mouse click on element : " +$("//*[@id=\"dm2m3i0tdT\"]").getText());
		withAction().click($("//*[@id=\"dm2m3i0tdT\"]")).perform();

		Thread.sleep(4000);

		
	}

}
