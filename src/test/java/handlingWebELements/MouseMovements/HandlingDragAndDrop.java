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
public class HandlingDragAndDrop extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "This is to demonstrate the use of dragAndDrop(WebElement source, WebElement target)method of the withAction API")
	@Test
	public void dragAndDropTest() {
		driverObj.get("https://jqueryui.com/droppable/");
		
		driverObj.switchTo().frame(0);

		WebElementFacade source = $("//div[@id = \"draggable\"]");
		WebElementFacade target = $("//div[@id = \"droppable\"]");

		/**
		 * In order to perform the drag and drop in serenity we can use the
		 * dragAndDrop(source , target) method of the withAction API
		 */
		
		withAction().dragAndDrop(source, target).perform();
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Title(value = "This is to demonstrate the use of dragAndDrop(WebElement source, WebElement target)method of the withAction API")
	@Test
	public void dragAndDropTest1() {
		driverObj.get("https://jqueryui.com/droppable/");
		
		driverObj.switchTo().frame(0);

		WebElementFacade source = $("//div[@id = \"draggable\"]");
		WebElementFacade target = $("/html/body");

		/**
		 * In order to perform the drag and drop in serenity we can use the
		 * dragAndDrop(source , target) method of the withAction API
		 */
		
		withAction().dragAndDrop(source, target).perform();
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
