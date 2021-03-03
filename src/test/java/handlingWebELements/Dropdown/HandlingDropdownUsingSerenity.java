package handlingWebELements.Dropdown;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class HandlingDropdownUsingSerenity extends PageObject{
	
	@Managed
	WebDriver driverObj;
	
	@Title(value = "Handle Dropdown - send keys method")
	@Test
	public void handleDropdownTest1() throws InterruptedException {
		driverObj.get("https://www.wikipedia.org/");
		
		find(By.xpath("//select[@id = 'searchLanguage']")).sendKeys("Dansk");
		Thread.sleep(3000);
	}
	
	
	@Title(value = "Handle Dropdown - select by visible text")
	@Test
	public void handleDropdownTest2() throws InterruptedException {
		driverObj.get("https://www.wikipedia.org/");
		
		find(By.xpath("//select[@id = 'searchLanguage']")).selectByVisibleText("Eesti");
		Thread.sleep(3000);
	}
	
	@Title(value = "Handle Dropdown - select by Value ")
	@Test
	public void handleDropdownTest3() throws InterruptedException {
		driverObj.get("https://www.wikipedia.org/");
		
		find(By.xpath("//select[@id = 'searchLanguage']")).selectByValue("ka");
		Thread.sleep(3000);
	}
	
	@Title(value = "Handle Dropdown - select by Index ")
	@Test
	public void handleDropdownTest4() throws InterruptedException {
		driverObj.get("https://www.wikipedia.org/");
		
		find(By.xpath("//select[@id = 'searchLanguage']")).selectByIndex(5);
		Thread.sleep(3000);
	}
	
	

}
