package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class CommonActions {

	public static WebElement element;
	static TakesScreenshot screenshot;
	private static final Logger logger = AppLogger.getLogger();

	public static WebDriverWait waitForElement() {
		return new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
	}

	public static void clickElement(WebElement elementToBeClicked) {
		try {
			element = waitForElement().until(ExpectedConditions.elementToBeClickable(elementToBeClicked));
			element.click();
			logger.info("clicked element: " + elementToBeClicked);
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
	}

	public static void enterText(WebElement inputBox, String textTobeEntered) {
		try {
			element = waitForElement().until(ExpectedConditions.elementToBeClickable(inputBox));
			element.clear();
			element.sendKeys(textTobeEntered);
			logger.info("entered text inside inputbox - " + inputBox + " ...");
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
	}

	public static boolean isElementDisplayed(WebElement elementToBeChecked) {
		try {
			element = waitForElement().until(ExpectedConditions.visibilityOf(elementToBeChecked));
			logger.info("Element: '" + elementToBeChecked + "' is displayed ...");
			return element.isDisplayed();
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return false;
		}
	}

	public static void selectDropdownValue(WebElement dropdown, String dropdownValue) {
		try {
			element = waitForElement().until(ExpectedConditions.visibilityOf(dropdown));
			clickElement(element); // optional, helps refresh dropdown list if its fetching data from any API
			Select sel = new Select(element);
			sel.selectByVisibleText(dropdownValue);
			logger.info("Selected: '" + dropdownValue + "' from dropdown: " + dropdown + " ...");
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
	}

	public static void takeScreenshot(String testCaseName) {
		String ssDest = System.getProperty("user.dir") + "/screenshots/" + testCaseName + ".png";
		screenshot = (TakesScreenshot) BaseTest.getDriver();
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(ssDest));
		} catch (IOException e) {
			logger.severe(e.getMessage());
		}
		logger.info("screenshot captured -> '" + testCaseName + "' ...");
	}
}
