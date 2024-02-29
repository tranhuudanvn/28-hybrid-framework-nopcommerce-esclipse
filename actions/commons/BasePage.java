package commons;

import java.sql.Driver;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	// Chua nhung ham dung chung cho ca layer page objects
	
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void acceptToAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelToAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String valueToSendkey) {
		waitForAlertPresence(driver).sendKeys(valueToSendkey);
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	}
	
	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allIDs = driver.getWindowHandles();
		
		for (String id : allIDs) {
			if(!id.equals(windowID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
				break;
			}
		}
	}
	
	private void sleepInSecond(long timeoutInSeconds) {
		try {
			Thread.sleep(timeoutInSeconds * 1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allIDs = driver.getWindowHandles();
		
		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if(actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}
	
}
































