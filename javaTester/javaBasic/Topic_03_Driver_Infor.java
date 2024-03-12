package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class Topic_03_Driver_Infor {
	static WebDriver driver;
	private static String projectPath = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session ID = " + sessionId);
		System.out.println("Driver ID = " + driver.toString());
		driver.quit();
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		sessionId = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session ID = " + sessionId);
		System.out.println("Driver ID = " + driver.toString());
		driver.quit();
	}

}
