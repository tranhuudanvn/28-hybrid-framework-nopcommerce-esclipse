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
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointPageObject;

public class Level_09_Switch_Site_Url extends BaseTest {

	private WebDriver driver;
	private String emailAddress = getEmailAddress();

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private DownloadableProductPageObject downloadableProduct;
	private AddressesPageObject addresses;
	private RewardPointPageObject rewardPoint;
	private AdminLoginPageObject adminLoginPageObject;
	private AdminDashboardPageObject adminDashboardPageObject;

	private String userUrl;
	private String adminUrl;

	@Parameters({ "browser", "userUrl", "adminUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		this.userUrl = userUrl;
		this.adminUrl = adminUrl;
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
		// Customer Page
		// ...

		// Logout ra (tu trang user)
		homePage = customerPage.userAbleToLogout(driver);

		// Qua trang admin
		homePage.openUrl(driver, adminUrl);
		adminLoginPageObject = PageGeneratorManager.getAdminLoginPage(driver);

		// Login vao thanh cong
		adminDashboardPageObject = adminLoginPageObject.loginAsAdmin("admin@yourstore.com", "admin");
		Assert.assertTrue(adminDashboardPageObject.isPageLoadedSuccess(driver));

		// ...

		// Logout ra (tu trang admin)
		adminLoginPageObject = adminDashboardPageObject.adminAbleToLogout(driver);

		// Qua trang user
		adminLoginPageObject.openUrl(driver, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		// Login vao
		loginPage = homePage.clickToLoginLink();

		homePage = loginPage.loginAsUser(emailAddress, "123456");
		// ...

		// Chuyen qua trang admin
		// Dang ki tai khoang o trang User xong qua Admin de verify lai
		// 1 User nao do mua hang thanh toan thanh cong -> qua trang admin de verify

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
