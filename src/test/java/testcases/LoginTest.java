
package testcases;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;

@RunWith(SerenityRunner.class)
public class LoginTest {

	@Managed
	private WebDriver driverObj;

	@Test
	public void doLogin() {

		// To launch the URL
		driverObj.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		// Enter the user name and password
		driverObj.findElement(By.id("email")).sendKeys("automationuser01@gmail.com");
		driverObj.findElement(By.id("passwd")).sendKeys("password01");

		// Click on the login button
		driverObj.findElement(By.id("SubmitLogin")).click();
	}

	@Test
	public void loginFieldsDisplayed() {

		// To launch the URL
		driverObj.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		Assert.assertTrue(driverObj.findElement(By.id("email")).isDisplayed());
		Assert.assertTrue(driverObj.findElement(By.id("passwd")).isDisplayed());
	}

	@Test
	public void failLoginInvalidUsername() {

		// To launch the URL
		driverObj.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		// Enter the user name and password
		driverObj.findElement(By.id("email")).sendKeys("automationuser@gmail.com");
		driverObj.findElement(By.id("passwd")).sendKeys("password01");

		// Click on the login button
		driverObj.findElement(By.id("SubmitLogin")).click();

		Assert.assertTrue(driverObj.findElement(By.xpath("//div[@class = \"alert alert-danger\"]//p")).getText()
				.equals("There is 1 error"));

		Assert.assertTrue(driverObj.findElement(By.xpath("//div[@class = \"alert alert-danger\"]//li")).getText()
				.equals("Authentication failed."));

	}

	@Test
	public void failLoginInvalidPassword() {

		// To launch the URL
		driverObj.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		// Enter the user name and password
		driverObj.findElement(By.id("email")).sendKeys("automationuser01@gmail.com");
		driverObj.findElement(By.id("passwd")).sendKeys("password0");

		// Click on the login button
		driverObj.findElement(By.id("SubmitLogin")).click();

		Assert.assertTrue(driverObj.findElement(By.xpath("//div[@class = \"alert alert-danger\"]//p")).getText()
				.equals("There is 1 error"));

		Assert.assertTrue(driverObj.findElement(By.xpath("//div[@class = \"alert alert-danger\"]//li")).getText()
				.equals("Authentication failed."));

	}

	@Test
	public void loginWithUsernamePassword() { // To launch the URL
		driverObj.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		// Click on the login button
		driverObj.findElement(By.id("SubmitLogin")).click();

		Assert.assertTrue(driverObj.findElement(By.xpath("//div[@class = \"alert alert-danger\"]//p")).getText()
				.equals("There is 1 error"));

		Assert.assertTrue(driverObj.findElement(By.xpath("//div[@class = \"alert alert-danger\"]//li")).getText()
				.equals("An email address required."));
	}

	@Test
	public void isFogotPasswordLinkDisplayed() { // To launch the URL
		driverObj.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		Assert.assertTrue(driverObj.findElement(By.xpath("//a[text() = \"Forgot your password?\"]")).isDisplayed());
	}

	@Test
	public void isCreateAccButtonDisplayed() { // To launch the URL
		driverObj.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		Assert.assertTrue(driverObj.findElement(By.xpath("//button[@id = \"SubmitCreate\"]")).isDisplayed());
	}

	@Test
	public void isSearchBarDisplayed() {

		// To launch the URL
		driverObj.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		Assert.assertTrue(driverObj.findElement(By.cssSelector("input#search_query_top")).isDisplayed());
	}

	@Test
	public void isCartLabelDisplayed() {

		// To launch the URL
		driverObj.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		System.out
				.println("Label Displayed: " + driverObj.findElement(By.cssSelector("div.shopping_cart b")).getText());
		Assert.assertTrue(driverObj.findElement(By.cssSelector("div.shopping_cart b")).getText().equals("Cart"));
	}

	@Test
	public void clickOnTheHeader() {

	}
}
