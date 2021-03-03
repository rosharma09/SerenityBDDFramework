package handlingWebELements.frames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFramesUsingSelenium {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/windows/chrome/chromedriver.exe");
		WebDriver driverObj = new ChromeDriver();

		driverObj.manage().window().maximize();

		driverObj.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

		/**
		 * To get the count of all the iframes in the page
		 */

		List<WebElement> framesOnPage = driverObj.findElements(By.tagName("iframe"));

		System.out.println("No of iFrames on the page: " + framesOnPage.size());

		/**
		 * To print the id and names of all the iframes on the page
		 */

		for (WebElement frame : framesOnPage) {
			System.out.println("Frame id: " + frame.getAttribute("id") + " | Frame name: " + frame.getAttribute("name")
					+ " | Frame Border: " + frame.getAttribute("frameborder"));
		}
		
		driverObj.switchTo().frame("iframeResult");
		driverObj.switchTo().frame(0);
		System.out.println(driverObj.findElement(By.xpath("/html/body/h1")).getText());
	}

}
