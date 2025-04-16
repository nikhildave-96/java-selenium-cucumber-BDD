package base;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import utils.AppLogger;
import utils.PropertiesReader;

public class BaseTest {
	public static WebDriver driver;
	static TakesScreenshot screenshot;
	private static final Logger logger = AppLogger.getLogger();

	public static WebDriver getDriver() {
		return driver;
	}

	public static void initBrowser() {
		String browserName = PropertiesReader.readKey("oc_browser").toLowerCase();
		logger.info("launching '" + browserName + "' browser ...");
		if (driver == null) {
			switch (browserName) {
			case "chrome":
//				 options can be added to capabilities using .setCapability() method and the
//				 DesiredCapabilities's object can be passed as an argument while creating
//				 driver's object
				ChromeOptions chOptions = new ChromeOptions();
//				only headless works for GitHub Actions, else 'org.openqa.selenium.SessionNotCreatedException' is thrown; remove headless when running test locally if required
				chOptions.addArguments("headless");
				driver = new ChromeDriver(chOptions);
				logger.info("launched chrome browser ...");
				break;
			case "firefox":
				FirefoxOptions ffOptions = new FirefoxOptions();
				ffOptions.addArguments("headless"); // "incognito", "start-maximized"
				driver = new FirefoxDriver(ffOptions);
				logger.info("launched firefox browser ...");
				break;
			case "edge":
				EdgeOptions edOptions = new EdgeOptions();
				edOptions.addArguments("headless");
				driver = new EdgeDriver(edOptions);
				logger.info("launched edge browser ...");
				break;
			default:
				logger.severe("incorrect browser value provided ...");
			}
		}
		driver.manage().window().setSize(new Dimension(1920, 1080));
	}

	public static String readDataPropertyKey(String key) {
		return PropertiesReader.readKey(key);
	}

	public static void captureScreenshotOnFail(String testCaseName) throws IOException {
		String ssDest = System.getProperty("user.dir") + "/screenshots/onFail/" + testCaseName + ".png";
		screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(ssDest));
		logger.severe("screenshot captured for failed test -> '" + testCaseName + "' ...");
	}

	public static byte[] captureScreenshotOnFailReport() throws IOException {
		logger.severe("attaching screenshot in report ...");
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public static void launchApplication() {
		driver.get(PropertiesReader.readKey("oc_url"));
		logger.info("navigated to the application url ...");
	}

	public static void closeBrowser() {
		if (driver != null) {
			driver.quit();
			logger.info("closed browser ...");
			driver = null;
		}
	}
}
