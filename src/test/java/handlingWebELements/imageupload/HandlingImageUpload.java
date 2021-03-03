package handlingWebELements.imageupload;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class HandlingImageUpload extends PageObject {

	@Managed
	WebDriver driverObj;

	@Title(value = "To handle the image upload in facebook application")
	@Test
	public void imageUploadTest1() throws InterruptedException {

		driverObj.get("https://www.facebook.com/");

		$("//input[@id = \"email\"]").sendKeys("");
		$("//input[@id = \"pass\"]").typeAndEnter("");

		$("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[1]/div[4]/a").click();

		$("//div[@aria-label = 'Update profile picture']/i").click();

		/**
		 * In order to achieve the file upload in case of serenity, we can directly use
		 * the upload("file_path").to(WebELement);
		 */

		upload("C:\\Users\\rohan.sharma\\Desktop\\2018-06-21 (1).png")
				.to($("//div[@aria-label = 'Update profile picture']//input"));

		Thread.sleep(3000);

	}

}
