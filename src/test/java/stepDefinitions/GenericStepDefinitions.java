package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.And;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonActions;

public class GenericStepDefinitions {

	HomePage home = new HomePage(BaseTest.getDriver());
	LoginPage login = new LoginPage(BaseTest.getDriver());

	@And("Take screenshot {string}")
	public void Take_screenshot(String testName) {
		CommonActions.takeScreenshot(testName);
	}

	/*
	 * Keeping this step here to avoid -
	 * 'cucumber.runtime.DuplicateStepDefinitionException: Duplicate step
	 * definitions'; cucumber searches for a step definition everywhere inside glue
	 * option specified in TestRunner
	 */
	@And("User is logged in")
	public void User_is_logged_in() {
		home.navigateToLoginPage();
		login.do_login(BaseTest.readDataPropertyKey("oc_username"), BaseTest.readDataPropertyKey("oc_password"));
	}
}
