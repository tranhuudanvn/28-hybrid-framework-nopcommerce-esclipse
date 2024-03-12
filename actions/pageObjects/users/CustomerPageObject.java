package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.users.CustomerPageUI;

public class CustomerPageObject extends SideBarMyAccountPageObject{
	private WebDriver driver;
	
	public CustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getFirstNameTextbox() {
		waitForElementVisible(driver, CustomerPageUI.FIRT_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.FIRT_NAME_TEXTBOX, "value");
	}
	
	public String getLastNameTextbox() {
		waitForElementVisible(driver, CustomerPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.LAST_NAME_TEXTBOX, "value");
	}
	
	public String getEmailTextbox() {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
	}
}
