package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.users.AddressesPageUI;

public class AddressesPageObject extends SideBarMyAccountPageObject {
	private WebDriver driver;
	
	public AddressesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public RewardPointPageObject openRewardPointPage() {
		waitForElementClickable(driver, AddressesPageUI.REWARD_POINT_LINK);
		clickToElement(driver, AddressesPageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getRewardPointPage(driver);
	}

	public DownloadableProductPageObject openDownloadableProductPage() {
		waitForElementClickable(driver, AddressesPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		clickToElement(driver, AddressesPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}
	
}
