package stepDefinitions;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.And;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class AccountPageStepDefinitions {

	HomePage home = new HomePage(BaseTest.getDriver());
	LoginPage login = new LoginPage(BaseTest.getDriver());
	AccountPage account = new AccountPage(BaseTest.getDriver());

	@And("User clicks Change your password link")
	public void User_clicks_Change_your_password_link() {
		account.clickPwdChange();
	}

	@And("User clicks Continue button")
	public void User_clicks_Continue_button() {
		account.clickContinue();
	}

	@And("User should be able to see password related error")
	public void User_should_be_able_to_see_password_related_error() {
		Assert.assertTrue(account.verifyPwdErrTxtIsDisplayed());
	}

	@And("User enters {string} as password")
	public void User_enters_password(String password) {
		account.enterPwd(password);
	}

	@And("User should be able to see confirm password related error")
	public void User_should_be_able_to_see_confirm_password_related_error() {
		Assert.assertTrue(account.verifyPwdConfirmErrTxtIsDisplayed());
	}

}
