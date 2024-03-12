package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.users.DownloadableProductPageUI;

public class DownloadableProductPageObject extends SideBarMyAccountPageObject {
	private WebDriver driver;
	
	public DownloadableProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public AddressesPageObject openAddressesPage() {
		waitForElementClickable(driver, DownloadableProductPageUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, DownloadableProductPageUI.ADDRESSES_PAGE_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}
	
}
