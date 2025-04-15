package stepDefinitions;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageStepDefinitions {

	HomePage home = new HomePage(BaseTest.driver);
	LoginPage login = new LoginPage(BaseTest.driver);
	AccountPage account = new AccountPage(BaseTest.driver);

	@Given("User is on loginpage")
	public void User_is_on_loginpage() {
		home.navigateToLoginPage();
	}

	@When("User enters username and password")
	public void User_enters_username_and_password() {
		login.enterUsernamePassword(BaseTest.readDataPropertyKey("oc_username"),
				BaseTest.readDataPropertyKey("oc_password"));
	}

	@And("User clicks Login button")
	public void User_clicks_Login_button() {
		login.clickLogIn();
	}

	@Then("User should be able to see My Affiliate Account text")
	public void User_should_be_able_to_see_My_Affiliate_Account_text() {
		Assert.assertTrue(account.verifyAffiliateAccTxtIsDisplayed());
	}

	@Then("User should be able to see error")
	public void verifyErrTxtIsDisplayed() {
		Assert.assertTrue(login.verifyErrTxtIsDisplayed());
	}

	@When("User enters invalid {string} and {string}")
	public void enterInvalidCredentials(String username, String password) {
		login.enterUsernamePassword(username, password);
	}
}
