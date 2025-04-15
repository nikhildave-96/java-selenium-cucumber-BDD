package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonActions;

public class LoginPage {
	WebDriver localdriver;

	public LoginPage(WebDriver basedriver) {
		this.localdriver = basedriver;
		PageFactory.initElements(basedriver, this);
	}

	// WEBELEMENTS
	@FindBy(id = "input-email")
	public WebElement emailInput;

	@FindBy(id = "input-password")
	public WebElement passwordInput;

	@FindBy(xpath = "//*[@value='Login']")
	public WebElement loginBtn;

	@FindBy(xpath = "//*[text()='New Customer']")
	public WebElement newCustomerTxt;

	@FindBy(xpath = "//*[text()='Warning: No match for E-Mail Address and/or Password.']")
	public WebElement loginErrTxt;

	// ACTION METHODS
	public void do_login(String username, String password) {
		CommonActions.enterText(emailInput, username);
		CommonActions.enterText(passwordInput, password);
		CommonActions.clickElement(loginBtn);
	}

	public void enterUsernamePassword(String username, String password) {
		CommonActions.enterText(emailInput, username);
		CommonActions.enterText(passwordInput, password);
	}

	public void clickLogIn() {
		CommonActions.clickElement(loginBtn);
	}

	public boolean verifyNewCustTxtIsDisplayed() {
		return CommonActions.isElementDisplayed(newCustomerTxt);
	}

	public boolean verifyErrTxtIsDisplayed() {
		return CommonActions.isElementDisplayed(loginErrTxt);
	}

}
