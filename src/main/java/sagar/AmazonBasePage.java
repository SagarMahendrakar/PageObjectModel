package sagar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.w2a.zoho.ExtentListeners.ExtentListeners;
import com.w2a.zoho.utilities.DriverManager;

public abstract class AmazonBasePage {

	protected WebDriver driver;

	private long LOAD_TIMEOUT = 30;
	private int AJAX_ELEMENT_TIMEOUT = 10;

	Assertion asert = new Assertion();
	WebDriverWait explicitWait;

	public AmazonBasePage() {
		this.driver = DriverManager.getDriver();
	}

	public void openUrl(String url, String pageName) {

		driver.get(url);

		ExtentListeners.testReport.get().info("Opening page" + pageName);

	}

	public void waitExplicitlyForElementVisibility(String locator, int timeOutInSeconds) {

		explicitWait = new WebDriverWait(driver, timeOutInSeconds);

		explicitWait.until(ExpectedConditions.visibilityOf(getLocator(locator)));

	}

	public void waitExplicitlyTillElementclickable(String locator, int timeOutInSeconds) {

		explicitWait = new WebDriverWait(driver, timeOutInSeconds);

		explicitWait.until(ExpectedConditions.elementToBeClickable(getLocator(locator)));

	}

	public void assertTextFromLocator(String locator, String expectedText) {

		String actualText = getLocator(locator).getText();
		asert.assertEquals(actualText, expectedText);
		ExtentListeners.testReport.get().info("Opening page" + "");

	}

	public void verifyTextFromLocator(String locator, String expectedText) {

		try {

			String actualText = getLocator(locator).getText();
			asert.assertEquals(actualText, expectedText);
			ExtentListeners.testReport.get().info("Opening page" + "");

		} catch (Throwable e) {

			ExtentListeners.testReport.get().info("Opening page" + "");
		}

	}

	public void verifyElementisPresent(String locator, String expectedText) {

		try {

			getLocator(locator);

		} catch (Throwable e) {

			ExtentListeners.testReport.get().info("Opening page" + "");
		}

	}

	public void click(String locator, String locatorName) {

		getLocator(locator).click();

		ExtentListeners.testReport.get().info("Clicking on : " + locator);

	}

	public void enterText(String locator, String text, String textboxNname) {

		getLocator(locator).sendKeys(text);

		ExtentListeners.testReport.get().info("Enetering '" + text + "' to textbox" + textboxNname);

	}

	public void clearText(String locator) {

		getLocator(locator).clear();

	}

	public void isElementPrest(String locator) {

		getLocator(locator).isDisplayed();

	}

	public void isElementEnabled(String locator) {

		getLocator(locator).isEnabled();

	}

	public void isElementSelected(String locator) {

		getLocator(locator).isSelected();

	}

	public void selectByVisibleText(String locator, String visibleText) {

		Select select = new Select(getLocator(locator));

		select.selectByVisibleText(visibleText);

	}

	public void selectByValue(String locator, String value) {

		Select select = new Select(getLocator(locator));

		select.selectByVisibleText(value);

	}

	public void selectByIndex(String locator, int index) {

		Select select = new Select(getLocator(locator));

		select.selectByIndex(index);

	}

	public void mouseHover(String locator) {

		Actions action = new Actions(driver);

		action.moveToElement(getLocator(locator)).build().perform();
	

	}

	public void mouseHoverAndClick(String locator, String elementTobeclicked) {

		Actions action = new Actions(driver);

		action.moveToElement(getLocator(locator)).click(getLocator(locator)).build().perform();

	}

	public WebElement getLocator(String locator) {

		if (locator.startsWith("//")) {

			return driver.findElement(By.xpath(locator));

		} else if (locator.startsWith("#")) {

			return driver.findElement(By.cssSelector(locator));

		} else if ((locator).toLowerCase().contains("link=")) {

			return driver.findElement(By.linkText(locator.substring(5)));

		} else if ((locator).toLowerCase().contains("partiallink=")) {

			return driver.findElement(By.linkText(locator.substring(5)));

		}
		return null;

	}
}
