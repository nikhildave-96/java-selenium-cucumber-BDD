package stepDefinitions;

import java.io.IOException;
import java.util.logging.Logger;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.AppLogger;

public class Hooks {
	private static final Logger logger = AppLogger.getLogger();

	@BeforeAll
	public static void start() {
		logger.info(
				"\n========================================================================\n>>>>>>>>>>>>>>>>>>>>>>>>> STARTING LOG CAPTURE <<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	@Before
	public static void setUp(Scenario scenario) {
		logger.info("========================= starting test case execution '" + scenario.getName() + "' ...");
		BaseTest.initBrowser();
		BaseTest.launchApplication();

	}

	@After
	public static void teardown(Scenario scenario) throws IOException, InterruptedException {
		if (scenario.isFailed()) {
			BaseTest.captureScreenshotOnFail(scenario.getName());
			scenario.attach(BaseTest.captureScreenshotOnFailReport(), "image/png", scenario.getName());
		}
		BaseTest.closeBrowser();
		logger.info("========================= ending test case execution '" + scenario.getName() + "' ...");
	}

	@AfterAll
	public static void finish() {
		logger.info(
				"\n======================================================================\n>>>>>>>>>>>>>>>>>>>>>>>>> ENDING LOG CAPTURE <<<<<<<<<<<<<<<<<<<<<<<<<\n");
	}

}
