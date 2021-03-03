package handlingWebELements.alerts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class HandlingAlertUsingSerenity extends PageObject{

	@Managed
	WebDriver driverObj;
	
	@Title(value = "Test to handle the alert pop up -- Accept the alert")
	@Test
	public void alertTest1() {
		driverObj.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		$("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]").click();
		
		Alert alertObj = getAlert();
		
		System.out.println("The alert pop up text: "+alertObj.getText());
		alertObj.accept();
	}
	
	

	
	@Title(value = "Test to handle the alert pop up -- Reject the alert")
	@Test
	public void alertTest2() {
		driverObj.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		$("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]").click();
		
		Alert alertObj = getAlert();
		
		System.out.println("The alert pop up text: "+alertObj.getText());
		alertObj.dismiss();
	}
}
