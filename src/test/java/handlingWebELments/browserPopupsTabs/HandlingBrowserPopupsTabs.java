package handlingWebELments.browserPopupsTabs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class HandlingBrowserPopupsTabs {

	@Managed
	WebDriver driverObj;

	@Title(value = "Handle a new browser window in the same browser")
	@Test
	public void handleBroswerPopupsTest1() {
		driverObj.get("http://demo.automationtesting.in/Windows.html");

		System.out.println("Broswer Title of the current page: " + driverObj.getTitle());

		driverObj.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();

		/**
		 * Using the getHandles() method we can get the handle of all the currently
		 * opened tabs in the same session
		 */

		Set<String> tabsHandler = driverObj.getWindowHandles();
		Iterator<String> it = tabsHandler.iterator();

		while (it.hasNext()) {
			System.out.println("Window Handler:" + it.next());
		}

		/**
		 * In order to switch to the new window tab we can use the
		 * switchTo().Window(nameOrHandle)
		 * 
		 * In case if you have a two windows opened in the same browser then you can use
		 * the window handle at the second position to switch the focus to the next
		 * window
		 */

		ArrayList<String> stringHandles = new ArrayList<String>(tabsHandler);
		driverObj.switchTo().window(stringHandles.get(1));

		System.out.println("Browser title of the current page: " + driverObj.getTitle());

	}

	@Title(value = "Handle a new browser window as a pop up ")
	@Test
	public void handleBroswerPopupsTest2() {
		driverObj.get("http://demo.automationtesting.in/Windows.html");

		System.out.println("Broswer Title of the current page: " + driverObj.getTitle());

		driverObj.findElement(By.xpath("//a[text() = 'Open New Seperate Windows']")).click();

		if (driverObj.findElement(By.xpath("//*[@id=\"Seperate\"]/p")).getText()
				.equals("click the button to open a new window with some specifications")) {

			driverObj.findElement(By.xpath("//button[text() = 'click']")).click();

			/**
			 * Using the getHandles() method we can get the handle of all the currently
			 * opened tabs in the same session
			 */

			Set<String> tabsHandler = driverObj.getWindowHandles();
			Iterator<String> it = tabsHandler.iterator();

			while (it.hasNext()) {
				System.out.println("Window Handler:" + it.next());
			}

			/**
			 * In order to switch to the new window tab we can use the
			 * switchTo().Window(nameOrHandle)
			 * 
			 * In case if you have a two windows opened in the same browser then you can use
			 * the window handle at the second position to switch the focus to the next
			 * window
			 */

			ArrayList<String> stringHandles = new ArrayList<String>(tabsHandler);
			driverObj.switchTo().window(stringHandles.get(1));

			System.out.println("Browser title of the current page: " + driverObj.getTitle());

			Assert.assertTrue((driverObj.findElement(By.xpath("/html/body/section[1]/h1[1]"))).getText()
					.equals("Selenium automates browsers. That's it!"));

		}

	}
	
	@Title(value = "Handle a new browser window as a pop up ")
	@Test
	public void handleBroswerPopupsTest3() {
		driverObj.get("http://demo.automationtesting.in/Windows.html");

		System.out.println("Broswer Title of the current page: " + driverObj.getTitle());

		driverObj.findElement(By.xpath("//a[text() = 'Open New Seperate Windows']")).click();

		if (driverObj.findElement(By.xpath("//*[@id=\"Seperate\"]/p")).getText()
				.equals("click the button to open a new window with some specifications")) {

			driverObj.findElement(By.xpath("//button[text() = 'click']")).click();

			/**
			 * Using the getHandles() method we can get the handle of all the currently
			 * opened tabs in the same session
			 */

			Set<String> tabsHandler = driverObj.getWindowHandles();
			Iterator<String> it = tabsHandler.iterator();

			while (it.hasNext()) {
				System.out.println("Window Handler:" + it.next());
			}

			/**
			 * In order to switch to the new window tab we can use the
			 * switchTo().Window(nameOrHandle)
			 * 
			 * In case if you have a two windows opened in the same browser then you can use
			 * the window handle at the second position to switch the focus to the next
			 * window
			 */

			ArrayList<String> stringHandles = new ArrayList<String>(tabsHandler);
			driverObj.switchTo().window(stringHandles.get(1));

			System.out.println("Browser title of the current page: " + driverObj.getTitle());

			Assert.assertTrue((driverObj.findElement(By.xpath("/html/body/section[1]/h1[1]"))).getText()
					.equals("Selenium automates browsers. That's it!"));

		}

	}

}
