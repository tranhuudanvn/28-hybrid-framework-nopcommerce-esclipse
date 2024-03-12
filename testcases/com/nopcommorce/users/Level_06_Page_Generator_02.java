package com.nopcommorce.users;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Level_06_Page_Generator_02 extends BaseTest{

	private WebDriver driver;
	private String emailAddress = getEmailAddress(); 
		
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
	}

	@Test
	public void Register_01_Empty_Data() {
		homePage = new HomePageObject(driver);

		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToRegisterButton();
		
		System.out.print("registerPage.getFirstNameErrorMessage()");

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		homePage = registerPage.clickToHomePageLogo();

		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox("john");
		registerPage.enterToLastNameTextbox("wick");
		registerPage.enterToEmailTextbox("john@wick@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void Register_03_Invalid_Password() {
		homePage = registerPage.clickToHomePageLogo();

		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox("john");
		registerPage.enterToLastNameTextbox("wick");
		registerPage.enterToEmailTextbox("johnwick@gmail.com");
		registerPage.enterToPasswordTextbox("123");
		registerPage.enterToConfirmPasswordTextbox("123");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {
		homePage = registerPage.clickToHomePageLogo();

		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox("john");
		registerPage.enterToLastNameTextbox("wick");
		registerPage.enterToEmailTextbox("johnwick@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123654");
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");

	}

	@Test
	public void Register_05_Register_Success() {
		homePage = registerPage.clickToHomePageLogo();

		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox("john");
		registerPage.enterToLastNameTextbox("wick");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	
		homePage = registerPage.clickToHomePageLogo();
		
		loginPage = homePage.clickToLoginLink();
		
		homePage = loginPage.loginAsUser(emailAddress, "123456");
		
		homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameTextbox(), "john");
		Assert.assertEquals(customerPage.getLastNameTextbox(), "wick");
		Assert.assertEquals(customerPage.getEmailTextbox(), emailAddress);	

	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

	public String getEmailAddress() {
		Random rand = new Random();
		return "john" + rand.nextInt(99999) + "@gmail.com";
	}

}
