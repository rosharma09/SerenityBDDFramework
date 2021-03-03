package handlingWebELements.Links;

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
public class HandlingMultipleLinks extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "To check the number of links displayed on the page")
	@Test
	public void getLinkCount() {
		driverObj.get("https://www.wikipedia.org/");

		/**
		 * To get all the links on the page
		 */
		List<WebElementFacade> linkList = findAll(By.tagName("a"));

		System.out.println("The number of links present on the page: " + linkList.size());
	}

	@Title(value = "To print the link text of all the links displayed on the page")
	@Test
	public void getLinkText() {
		driverObj.get("https://www.wikipedia.org/");

		/**
		 * To get all the links on the page
		 */
		List<WebElementFacade> linkList = findAll(By.tagName("a"));

		System.out.println("Printing the text for all the links");

		for (WebElementFacade link : linkList) {
			System.out.println("Link Text: " + link.getText());
			System.out.println();
		}

		System.out.println("The number of links present on the page: " + linkList.size());
	}

	@Title(value = "To print the link URL of all the links displayed on the page")
	@Test
	public void getLinkURL() {
		driverObj.get("https://www.wikipedia.org/");

		/**
		 * To get all the links on the page
		 */
		List<WebElementFacade> linkList = findAll(By.tagName("a"));

		System.out.println("Printing the URL for all the links");

		for (WebElementFacade link : linkList) {
			System.out.println("Link URL: " + link.getAttribute("href"));
			System.out.println();
		}

		System.out.println("The number of links present on the page: " + linkList.size());
	}

	@Title(value = "To print the link text and URL of all the links displayed on the page")
	@Test
	public void getLinkTextwithURL() {
		driverObj.get("https://www.wikipedia.org/");

		/**
		 * To get all the links on the page
		 */
		List<WebElementFacade> linkList = findAll(By.tagName("a"));

		System.out.println("Printing the URL for all the links");

		for (WebElementFacade link : linkList) {
			System.out.println("Link Text: " + link.getText() + "| Link Url: " + link.getAttribute("href"));
			System.out.println();
		}

		System.out.println("The number of links present on the page: " + linkList.size());
	}

	@Title(value = "To print the link text and URL of all the links in the center")
	@Test
	public void getLinkTextwithURLCenter() {
		driverObj.get("https://www.wikipedia.org/");

		/**
		 * To get all the links on the center
		 */
		WebElementFacade centralFeatured = find(By.cssSelector("div.central-featured"));

		List<WebElementFacade> linkList = centralFeatured.thenFindAll(By.tagName("a"));
		System.out.println("Printing the URL for all the links");

		for (WebElementFacade link : linkList) {
			System.out.println("Link Text: " + link.getText() + "| Link Url: " + link.getAttribute("href"));
			System.out.println();
		}

		System.out.println("The number of links present on the page: " + linkList.size());
	}

	@Title(value = "To print the link text and URL of all the links in the footer")
	@Test
	public void getLinkTextwithURLFooter() {
		driverObj.get("https://www.wikipedia.org/");

		/**
		 * To get all the links on the page footer
		 */
		WebElementFacade centralFeatured = find(By.cssSelector("div.footer"));

		List<WebElementFacade> linkList = centralFeatured.thenFindAll(By.tagName("a"));
		System.out.println("Printing the URL for all the links");

		for (WebElementFacade link : linkList) {
			System.out.println("Link Text: " + link.getText() + "| Link Url: " + link.getAttribute("href"));
			System.out.println();
		}

		System.out.println("The number of links present on the page: " + linkList.size());
	}

	@Title(value = "To print the link text and URL of all the license links in the footer")
	@Test
	public void getLinkTextwithURLsitelicense() {
		driverObj.get("https://www.wikipedia.org/");

		/**
		 * To get all the links for the site license
		 */
		WebElementFacade centralFeatured = find(By.cssSelector("p.site-license"));

		List<WebElementFacade> linkList = centralFeatured.thenFindAll(By.tagName("a"));
		System.out.println("Printing the URL for all the links");

		for (WebElementFacade link : linkList) {
			System.out.println("Link Text: " + link.getText() + "| Link Url: " + link.getAttribute("href"));
			System.out.println();
		}

		System.out.println("The number of links present on the page: " + linkList.size());
	}
}
