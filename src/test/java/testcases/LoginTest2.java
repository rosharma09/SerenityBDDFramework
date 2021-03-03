
package testcases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class LoginTest2 extends PageObject {

	/**
	 * Below is the page factory for the login page
	 */

	@FindBy(xpath = "//input[@id = 'search_query_top']")
	WebElementFacade searchInput;

	@Managed
	private WebDriver driverObj;

	@Title(value = "To check the Login page is loading- load using driverObj")

	@Test
	public void lauchGoogleSearchEngine() {

		driverObj.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@Title(value = "To check the Login page is loading or not - load using open()")

	@Test
	public void lauchGoogleSearchEngine1() {

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		/**
		 * In order to load the base url configured in the serenity.propeties
		 * file[webdriver.base.url], we can use the open() method to load the specified
		 * base URL
		 */
		open();
	}

	@Title(value = "To check the Login page is loading or not - load using getDriver()")

	@Test
	public void lauchGoogleSearchEngine2() {
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();

		getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@Title(value = "To check if the search bar is displayed - use the driver object")

	@Test
	public void isSearchBarDisplayed() {

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		open(); // load the base URL
		Assert.assertTrue(driverObj.findElement(By.xpath("//input[@id = \"search_query_top\"]")).isDisplayed());
	}

	@Title(value = "To check if the search bar is displayed - use find")
		  
		  @Test public void isSearchBarDisplayed2() {
		  
		  getDriver().manage().window().maximize();
		  getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		  getDriver().manage().deleteAllCookies(); open(); // load the base URL //
		  Assert.assertTrue(driverObj.findElement(By.xpath("//input[@id = \"search_query_top\"]")).isDisplayed());
		  Assert.assertTrue(find(By.cssSelector("input#search_query_top")).isDisplayed(
		  )); }

	@Title(value =
		  "To check if the search bar is displayed - use $(css_selector) to get the webElement Facade"
		  )
		  
		  @Test public void isSearchBarDisplayed3() {
		  getDriver().manage().window().maximize();
		  getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		  getDriver().manage().deleteAllCookies(); open(); // load the base URL //
		  Assert.assertTrue(driverObj.findElement(By.xpath("//input[@id = \"search_query_top\"]")).isDisplayed());
		  Assert.assertTrue($("input#search_query_top").isDisplayed()); }

	@Title(value = "To check if the search bar is displayed - use $(xpath) to get the webElement Facade")

	@Test
	public void isSearchBarDisplayed4() {

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		open(); // load the base URL //
		Assert.assertTrue(driverObj.findElement(By.xpath("//input[@id = \"search_query_top\"]")).isDisplayed());
		Assert.assertTrue($("//input[@id = \"search_query_top\"]").isDisplayed());
	}

	@Title(value = "To type into the search field using the send keys method")

	@Test
	public void searchBoxTypeTest() {

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		open();
		$("//input[@id = \"search_query_top\"]").sendKeys("Dresses");
	}

	@Title(value = "To type into the search field using the type into method - xpath")

	@Test
	public void searchBoxTypeTest1() {

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		open();
		typeInto($("//input[@id = \"search_query_top\"]"), "T-shirt");
		System.out.println("The text in the search bar: " + $("input#search_query_top").getText());

	}

	@Title(value = "To type into the search field using the type into method - css selector")

	@Test
	public void searchBoxTypeTest2() {

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		open();
		typeInto($("input#search_query_top"), "T-shirt");
		System.out.println("The text in the search bar: " + $("input#search_query_top").getText());
	}

	@Title(value = "To type into the search field PageFactory Element created")

	@Test
	public void searchBoxTypeTest3() {

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		open();
		searchInput.shouldBeVisible();
		System.out.println("Place Holder Value: " + searchInput.getAttribute("placeholder"));
		typeInto(searchInput, "T-shirt");

	}

	@Title(value = "To get the title of the page using the driverObject")

	@Test
	public void getTitleTest1() {

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		open();
		searchInput.shouldBeVisible();

		String expectedTitle = "Login - My Store";
		System.out.println("Expected Title of the page is: " + expectedTitle);
		System.out.println("Actual Title of the page is: " + driverObj.getTitle());
		Assert.assertTrue(driverObj.getTitle().equals(expectedTitle));

	}

	@Title(value = "To get the title of the page using the getDriver()")

	@Test
	public void getTitleTest2() {

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		open();
		searchInput.shouldBeVisible();

		String expectedTitle = "Login - My Store";
		System.out.println("Expected Title of the page is: " + expectedTitle);
		System.out.println("Actual Title of the page is: " + getDriver().getTitle());
		Assert.assertTrue(getDriver().getTitle().equals(expectedTitle));

	}

	@Title(value = "To get the title of the page using the getDriver()")

	@Test
	public void getTitleTest3() {

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		open();
		searchInput.shouldBeVisible();

		String expectedTitle = "Login - My Store";
		System.out.println("Expected Title of the page is: " + expectedTitle);
		System.out.println("Actual Title of the page is: " + getTitle());
		Assert.assertTrue(getTitle().equals(expectedTitle));

	}
}
