package com.nopcommorce.users;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Register {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void Register_01_Empty_Data() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.cssSelector(".ico-register")).click();

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("#FirstName-error")).getText(),
				"First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(),
				"Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.cssSelector(".ico-register")).click();

		driver.findElement(By.cssSelector("#FirstName")).sendKeys("john");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("wick");
		driver.findElement(By.cssSelector("#Email")).sendKeys("john@wick@gmail");
		driver.findElement(By.cssSelector("#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("#Email-error")).getText(), "Wrong email");

	}

	@Test
	public void Register_03_Invalid_Password() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.cssSelector(".ico-register")).click();

		driver.findElement(By.cssSelector("#FirstName")).sendKeys("john");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("wick");
		driver.findElement(By.cssSelector("#Email")).sendKeys("johnwick@gmail");
		driver.findElement(By.cssSelector("#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123");

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("#Password-error")).getText(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.cssSelector(".ico-register")).click();

		driver.findElement(By.cssSelector("#FirstName")).sendKeys("john");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("wick");
		driver.findElement(By.cssSelector("#Email")).sendKeys("johnwick@gmail");
		driver.findElement(By.cssSelector("#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123654");

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(),
				"The password and confirmation password do not match.");

	}

	@Test
	public void Register_05_Invalid_Email() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.cssSelector(".ico-register")).click();

		driver.findElement(By.cssSelector("#FirstName")).sendKeys("john");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("wick");
		driver.findElement(By.cssSelector("#Email")).sendKeys(getEmailAddress());
		driver.findElement(By.cssSelector("#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String getEmailAddress() {
		Random rand = new Random();
		return "john" + rand.nextInt(99999) + "@gmail.com";
	}

}
