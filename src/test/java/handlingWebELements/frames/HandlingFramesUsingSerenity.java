package handlingWebELements.frames;

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
public class HandlingFramesUsingSerenity extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "How to handle the frames on a given page")
	@Test
	public void handleFramesTest1() {

		driverObj.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

		/**
		 * To print the number of frames available on the page
		 */

		List<WebElementFacade> frames = findAll(By.tagName("iframe"));
		System.out.println("Before Switching to the main page");

		for (WebElementFacade frame : frames) {
			System.out.println("id: " + frame.getAttribute("id"));
			System.out.println("name: " + frame.getAttribute("name"));
		}

		/**
		 * To switch to the frame for the first time
		 */
		driverObj.switchTo().frame("iframeResult");

		// As per the page we have a frame inside the frame

		driverObj.switchTo().frame(0);
		System.out.println("The heading inside the frame: " + $("/html/body/h1").getText());

		/**
		 * This will get all the frames inside the current frame, will display 0 in case
		 * no frames are available inside the current frame
		 */
		frames = findAll(By.tagName("iframe"));

		System.out.println("After Switching to the iframe");
		for (WebElementFacade frame : frames) {
			System.out.println("id: " + frame.getAttribute("id"));
			System.out.println("name: " + frame.getAttribute("name"));
		}

		/**
		 * In order to move back to the main page, we can use the
		 * switchTo().defaultContent()
		 */

		driverObj.switchTo().defaultContent();
		// `driverObj.switchTo().parentFrame();

		frames = findAll(By.tagName("iframe"));

		System.out.println("After Switching to the main page");
		for (WebElementFacade frame : frames) {
			System.out.println("id: " + frame.getAttribute("id"));
			System.out.println("name: " + frame.getAttribute("name"));
		}
	}

	@Title(value = "Using different ways to switch to frames on a page")
	@Test
	public void handleFramesTest2() {
		driverObj.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

		List<WebElementFacade> frames = findAll(By.tagName("frame"));
		System.out.println("Frames count: " + frames.size());

		for (int i = 0; i < frames.size(); i++) {
			System.out.println("Switching to frame with id:" + frames.get(i).getAttribute("id"));
			System.out.println("Switching to frame with name:" + frames.get(i).getAttribute("name"));

			driverObj.switchTo().frame(i);
			if ($("//button[@id = \"w3loginbtn\"]").isDisplayed()) {
				$("//button[@id = \"w3loginbtn\"]").click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	@Title(value = "Using different ways to switch to frames on a page")
	@Test
	public void handleFramesTest3() {
		driverObj.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

		List<WebElementFacade> frames = findAll(By.tagName("frame"));
		System.out.println("Frames count: " + frames.size());

		driverObj.switchTo().frame(driverObj.findElement(By.xpath("//button[@id = \"w3loginbtn\"]")));

		if ($("//button[@id = \"w3loginbtn\"]").isDisplayed()) {
			$("//button[@id = \"w3loginbtn\"]").click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
