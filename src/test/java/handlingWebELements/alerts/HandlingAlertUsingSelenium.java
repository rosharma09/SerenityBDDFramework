package handlingWebELements.alerts;

import org.fluentlenium.core.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlertUsingSelenium {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/windows/chrome/chromedriver.exe");
		WebDriver driverObj = new ChromeDriver();

		driverObj.manage().window().maximize();
		driverObj.get("https://mail.rediff.com/cgi-bin/login.cgi");

		Alert alertObj = new Alert(driverObj);

		driverObj.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]"))
				.click();
		
		Thread.sleep(3000);

		alertObj.accept();

		Thread.sleep(3000);
	}

}
