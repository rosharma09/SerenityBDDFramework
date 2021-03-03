package handlingWebELements.MouseMovements;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class HandlingResizeableElement extends PageObject{
	
	@Managed
	WebDriver driverObj;
	
	@Title(value = "To resize an element")
	@Test
	public void resizeableTest1() throws InterruptedException {
		driverObj.get("https://jqueryui.com/resizable/");
		
		driverObj.switchTo().frame(0);

		int width = $("/html/body").getSize().getWidth();
		int height = $("/html/body").getSize().getHeight();

		
		withAction().dragAndDropBy($("//*[@id=\"resizable\"]/div[3]"),width/2, height/2).perform();
		Thread.sleep(3000);
	}
}
