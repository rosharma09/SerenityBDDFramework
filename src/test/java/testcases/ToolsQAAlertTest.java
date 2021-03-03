/**
 * We are going to use selenium in the below case to automate the google sign in page
 */

package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolsQAAlertTest {

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/windows/chrome/chromedriver.exe");
		WebDriver driverObj = new ChromeDriver();

		driverObj.get("https://demoqa.com/alerts");
		driverObj.findElement(By.xpath("//*[@id=\"timerAlertButton\"]")).click();
		Thread.sleep(5000);
		System.out.println(driverObj.switchTo().alert().getText());
	}

}
