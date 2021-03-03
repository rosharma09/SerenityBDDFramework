package handlingWebELements.Checkboxes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.webelements.Checkbox;

@RunWith(SerenityRunner.class)
public class HandlingCheckBoxesUsingSerenity extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "Handle a single check box")
	@Test
	public void checkBoxTest1() throws InterruptedException {
		driverObj.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		/**
		 * In order to handle the check boxes we need to create an object of the check
		 * box class
		 */

		find(By.cssSelector("input#isAgeSelected")).click();

		Checkbox checkBoxObj = new Checkbox(find(By.cssSelector("input#isAgeSelected")));
		System.out.println("Is check box checked: " + checkBoxObj.isChecked());

		if (!checkBoxObj.isChecked()) {
			checkBoxObj.setChecked(true);
			System.out.println("Is check box checked: " + checkBoxObj.isChecked());
		}

		Thread.sleep(3000);
	}

	@Title(value = "Count of the check boxes available on the page")
	@Test
	public void checkBoxTest2() throws InterruptedException {
		driverObj.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		/**
		 * We can get all the check boxes on the page
		 */

		List<WebElementFacade> inputTags = findAll(By.tagName("input"));

		List<WebElementFacade> checkBoxes = new ArrayList<WebElementFacade>();

		for (WebElementFacade input : inputTags) {
			if (input.getAttribute("type").toLowerCase().equals("checkbox")) {
				checkBoxes.add(input);
			}
		}

		System.out.println("Total Check boxes on the page: " + checkBoxes.size());

	}

	@Title(value = "make all the check boxes available on the page as checked")
	@Test
	public void checkBoxTest3() throws InterruptedException {
		driverObj.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		/**
		 * We can get all the check boxes on the page
		 */

		Checkbox checkBoxObj;

		List<WebElementFacade> inputTags = findAll(By.tagName("input"));

		List<WebElementFacade> checkBoxes = new ArrayList<WebElementFacade>();

		for (WebElementFacade input : inputTags) {
			if (input.getAttribute("type").toLowerCase().equals("checkbox")) {
				checkBoxes.add(input);
			}
		}

		System.out.println("Total Check boxes on the page: " + checkBoxes.size());

		for (WebElementFacade checkbox : checkBoxes) {
			checkBoxObj = new Checkbox(checkbox);
			System.out.println("Is Checked: " + checkBoxObj.isChecked());

			if (!checkBoxObj.isChecked()) {
				checkBoxObj.setChecked(true);
				System.out.println("Check box checked");
				System.out.println("Is Checked: " + checkBoxObj.isChecked());
				Thread.sleep(3000);
			}
		}
	}

	@Title(value = "make all the check boxes available in the page and display the label for the check box which is checked")
	@Test
	public void checkBoxTest4() throws InterruptedException {
		driverObj.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		/**
		 * We can get all the check boxes on the page
		 */

		Checkbox checkBoxObj;

		List<WebElementFacade> inputTags = findAll(By.tagName("input"));

		List<WebElementFacade> checkBoxes = new ArrayList<WebElementFacade>();

		for (WebElementFacade input : inputTags) {
			if (input.getAttribute("type").toLowerCase().equals("checkbox")) {
				checkBoxes.add(input);
			}
		}

		System.out.println("Total Check boxes on the page: " + checkBoxes.size());

		for (WebElementFacade checkbox : checkBoxes) {
			checkBoxObj = new Checkbox(checkbox);
			System.out.println("Is Checked: " + checkBoxObj.isChecked());

			if (!checkBoxObj.isChecked()) {
				checkBoxObj.setChecked(true);

				/**
				 * Here we have used the parent::label to get the parent tag for each of the
				 * check box so that we can get the text of the check box that we are clicking
				 */
				System.out.println("Check box checked : " + checkbox.thenFind("parent::label").getText()
						+ " checkbox checked status:" + checkBoxObj.isChecked());
				Thread.sleep(3000);
			}
		}
	}

	@Title(value = "make all the check boxes available in the section and display the label for the check box which is checked")
	@Test
	public void checkBoxTest5() throws InterruptedException {
		driverObj.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		/**
		 * We can get all the check boxes on the page
		 */

		Checkbox checkBoxObj;

		WebElementFacade section = find(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]"));

		List<WebElementFacade> inputTags = section.thenFindAll(By.tagName("input"));

		List<WebElementFacade> checkBoxes = new ArrayList<WebElementFacade>();

		for (WebElementFacade input : inputTags) {
			if (input.getAttribute("type").toLowerCase().equals("checkbox")) {
				checkBoxes.add(input);
			}
		}

		System.out.println("Total Check boxes on the page: " + checkBoxes.size());

		for (WebElementFacade checkbox : checkBoxes) {
			checkBoxObj = new Checkbox(checkbox);
			System.out.println("Is Checked: " + checkBoxObj.isChecked());

			if (!checkBoxObj.isChecked()) {
				checkBoxObj.setChecked(true);

				/**
				 * Here we have used the parent::label to get the parent tag for each of the
				 * check box so that we can get the text of the check box that we are clicking
				 */

				/*
				 * System.out.println("Check box checked : " +
				 * checkbox.thenFind("parent::label").getText() + " checkbox checked status:" +
				 * checkBoxObj.isChecked());
				 */

				System.out.println("Changed the status of checkbox:{" + checkbox.thenFind("parent::label").getText()
						+ "} to {" + checkBoxObj.isChecked() + "}");
				Thread.sleep(3000);
			}
		}
	}

	@Title(value = "make all the check boxes available in the section and display the label for the check box which is checked"
			+ "and then uncheck all the check boxes that are checked")
	@Test
	public void checkBoxTest6() throws InterruptedException {
		driverObj.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		/**
		 * We can get all the check boxes on the page
		 */

		Checkbox checkBoxObj;

		WebElementFacade section = find(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]"));

		List<WebElementFacade> inputTags = section.thenFindAll(By.tagName("input"));

		List<WebElementFacade> checkBoxes = new ArrayList<WebElementFacade>();

		for (WebElementFacade input : inputTags) {
			if (input.getAttribute("type").toLowerCase().equals("checkbox")) {
				checkBoxes.add(input);
			}
		}

		System.out.println("Total Check boxes on the page: " + checkBoxes.size());

		for (WebElementFacade checkbox : checkBoxes) {
			checkBoxObj = new Checkbox(checkbox);
			System.out.println("Is Checked: " + checkBoxObj.isChecked());

			if (!checkBoxObj.isChecked()) {
				checkBoxObj.setChecked(true);

				/**
				 * Here we have used the parent::label to get the parent tag for each of the
				 * check box so that we can get the text of the check box that we are clicking
				 */

				/*
				 * System.out.println("Check box checked : " +
				 * checkbox.thenFind("parent::label").getText() + " checkbox checked status:" +
				 * checkBoxObj.isChecked());
				 */

				System.out.println("Changed the status of checkbox:{" + checkbox.thenFind("parent::label").getText()
						+ "} to {" + checkBoxObj.isChecked() + "}");
				Thread.sleep(3000);
			}
		}

		for (WebElementFacade checkbox : checkBoxes) {
			checkBoxObj = new Checkbox(checkbox);
			System.out.println("Is Checked: " + checkBoxObj.isChecked());

			if (checkBoxObj.isChecked()) {
				checkBoxObj.setChecked(false);

				/**
				 * Here we have used the parent::label to get the parent tag for each of the
				 * check box so that we can get the text of the check box that we are clicking
				 */

				/*
				 * System.out.println("Check box checked : " +
				 * checkbox.thenFind("parent::label").getText() + " checkbox checked status:" +
				 * checkBoxObj.isChecked());
				 */

				System.out.println("Changed the status of checkbox:{" + checkbox.thenFind("parent::label").getText()
						+ "} to {" + checkBoxObj.isChecked() + "}");
				Thread.sleep(3000);
			}
		}
	}

	@Title(value = "Click on 'Check All' to check all checkboxes at once.")
	@Test
	public void checkBoxTest7() throws InterruptedException {

		Checkbox checkBoxObj;

		driverObj.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		List<WebElementFacade> checkBoxesList = findAll(By.xpath(
				"//div[text() = 'Multiple Checkbox Demo']/following-sibling::div//div//input[@type = 'checkbox']"));

		for (WebElementFacade checkBox : checkBoxesList) {
			checkBoxObj = new Checkbox(checkBox);
			Assert.assertFalse(checkBoxObj.isChecked());
		}

		clickOn(find(By.xpath("//input[@id = 'check1']")));
		Thread.sleep(3000);

		for (WebElementFacade checkBox : checkBoxesList) {
			checkBoxObj = new Checkbox(checkBox);
			Assert.assertTrue(checkBoxObj.isChecked());
		}

	}

	@Title(value = "Print all the main menu options")
	@Test
	public void printMenuOptions() {

		driverObj.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		//// ul[@id = 'treemenu']/li/ul/li/a

		Map<String, String> menuOptionMap = new HashMap<String, String>();

		List<WebElementFacade> menuOptionList = findAll(By.xpath("//ul[@id = 'treemenu']/li/ul/li/a"));

		for (WebElementFacade menuOption : menuOptionList) {

			System.out.println("Menu Option: [" + menuOption.getText() + "]| Menu Option URL: ["
					+ menuOption.getAttribute("href") + "]");
			menuOptionMap.put(menuOption.getText(), menuOption.getAttribute("href"));

		}

		System.out.println(menuOptionMap);
	}

	@Title(value = "Print all the main menu options in the header and Hover/Click on them")
	@Test
	public void printMenuOptionsHeader() throws InterruptedException {

		driverObj.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		//// ul[@id = 'treemenu']/li/ul/li/a

		Map<String, String> menuOptionMap = new HashMap<String, String>();

		List<WebElementFacade> menuOptionList = findAll(By.cssSelector("#navbar-brand-centered > ul > li"));

		for (WebElementFacade menuOption : menuOptionList) {

			System.out.println("Menu Option Clicked: [" + menuOption.getText() + "]");
			menuOptionMap.put(menuOption.getText(), menuOption.getAttribute("href"));

			menuOption.click();

			Thread.sleep(3000);
		}

		System.out.println(menuOptionMap);

		Actions actionObj = new Actions(driverObj);
		
		for (WebElementFacade menuOption : menuOptionList) {

			actionObj.moveToElement(menuOption);

			Thread.sleep(3000);
		}
	}
}
