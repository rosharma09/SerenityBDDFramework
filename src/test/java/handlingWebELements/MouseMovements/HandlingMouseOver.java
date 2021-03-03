package handlingWebELements.MouseMovements;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class HandlingMouseOver extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "To demonstrate the mouse over over on the elements on the web page")
	@Test
	public void mouseOverTest1() throws InterruptedException {
		driverObj.get("https://freecrm.co.in/");
		$("//a[text() = \"CRM\"]").shouldBeVisible();
		/**
		 * In order to move the cursor to a particular element in serenity we can make
		 * use of the withActions().moveToELement() method
		 * 
		 * Also we need to specify the perform() method to perform the action
		 */
		withAction().moveToElement($("//a[text() = \"CRM\"]")).perform();

		Thread.sleep(3000);
		WebElementFacade optionList = find(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/li[4]/ul"));

		List<WebElementFacade> crmOptions = optionList.thenFindAll(By.tagName("li"));

		for (WebElementFacade option : crmOptions) {

			withAction().moveToElement(option).perform();
			System.out.println("Mouse hovered over: " + option.getText());
			Thread.sleep(3000);
		}
	}

	@Title(value = "To use mouse over to click on the element")
	@Test
	public void mouseOverTest2() throws InterruptedException {

		driverObj.get("https://freecrm.co.in/");
		$("//a[text() = \"CRM\"]").shouldBeVisible();
		/**
		 * In order to move the cursor to a particular element in serenity we can make
		 * use of the withActions().moveToELement() method
		 * 
		 * Also we need to specify the perform() method to perform the action
		 */
		withAction().moveToElement($("//a[text() = \"CRM\"]")).perform();

		Thread.sleep(3000);
		WebElementFacade optionList = find(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/li[4]/ul"));

		List<WebElementFacade> crmOptions = optionList.thenFindAll(By.tagName("li"));

		for (WebElementFacade option : crmOptions) {
			
			boolean itemFound = false;

			withAction().moveToElement(option).perform();
			System.out.println("Mouse hovered over: " + option.getText());
			Thread.sleep(3000);
			
			if(option.getText().equals("Dental CRM")) {
				itemFound = true;
				option.click();
				break;
			}
			else if(itemFound == false){
				System.out.println("No such option found with text: "+option.getText());
			}
		}
		
		Thread.sleep(3000);

	}
}
