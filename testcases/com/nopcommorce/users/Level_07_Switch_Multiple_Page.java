package com.nopcommorce.users;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointPageObject;

public class Level_07_Switch_Multiple_Page extends BaseTest{

	private WebDriver driver;
	private String emailAddress = getEmailAddress(); 
		
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private DownloadableProductPageObject downloadableProduct;
	private AddressesPageObject addresses;
	private RewardPointPageObject rewardPoint;
	
	@Parameters({"browser", "userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGeneratorManager.getHomePage(driver);
	}


	@Test
	public void User_01_Register() {
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
		
		customerPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameTextbox(), "john");
		Assert.assertEquals(customerPage.getLastNameTextbox(), "wick");
		Assert.assertEquals(customerPage.getEmailTextbox(), emailAddress);	

	}
	
	@Test
	public void User_02_Switch_Page() {
		// Customer Infor => Downloadable products
		// downloadableProduct = customerPage.openDownloadableProductPage(driver);
		// downloadableProduct.sleepInSecond(3);
		
		// Downloadable products => Addresses
		// addresses = downloadableProduct.openAddressesPage(driver);
		// addresses.sleepInSecond(3);
		
		// Addresses => Reward points
		// rewardPoint = addresses.openRewardPointPage(driver);
		// rewardPoint.sleepInSecond(3);
		
		// Reward points => Customer Infor
		// customerPage = rewardPoint.openCustomerPage(driver);
		// customerPage.sleepInSecond(3);
		
		// Customer Infor => Addresses
		// addresses = customerPage.openAddressesPage(driver);
		// addresses.sleepInSecond(3);
		
		// Addresses => Downloadable products
		// downloadableProduct = addresses.openDownloadableProductPage(driver);
		// downloadableProduct.sleepInSecond(3);		
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
