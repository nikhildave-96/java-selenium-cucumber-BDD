package stepDefinitions;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.And;
import pages.HomePage;
import pages.LoginPage;

public class HomePageStepDefinitions {

	HomePage home = new HomePage(BaseTest.getDriver());
	LoginPage login = new LoginPage(BaseTest.getDriver());

	// Launching browser, navigating to URL and closing browser tasks are taken by
	// @Before and @After annotations under Hooks.
	// Step definition is implementation code of the step defined in .feature file.

	@And("User clicks My Account")
	public void User_clicks_My_Account() {
		home.clickMyAccount();
	}

	@And("User selects Login")
	public void User_selects_Login() {
		home.selectLogin();
	}

	@And("User should be able to see New Customer text")
	public void User_should_be_able_to_see_New_Customer_text() {
		Assert.assertTrue(login.verifyNewCustTxtIsDisplayed());
	}
}
