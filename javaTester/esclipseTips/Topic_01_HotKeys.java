package esclipseTips;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Topic_01_HotKeys {

	static WebDriver driver;

	static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.cssSelector(".ico-register")).click();

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("#FirstName-error")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(), "Password is required.");

	}

}
