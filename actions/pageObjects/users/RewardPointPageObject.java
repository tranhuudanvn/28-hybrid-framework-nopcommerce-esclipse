package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.users.RewardPointUI;

public class RewardPointPageObject extends SideBarMyAccountPageObject {
	private WebDriver driver;
	
	public RewardPointPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public CustomerPageObject openCustomerPage() {
		waitForElementClickable(driver, RewardPointUI.CUSTOMER_INFO_PAGE_LINK);
		clickToElement(driver, RewardPointUI.CUSTOMER_INFO_PAGE_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	
}
