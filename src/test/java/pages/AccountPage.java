package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonActions;

public class AccountPage {
	static WebDriver localdriver;

	public AccountPage(WebDriver basedriver) {
		localdriver = basedriver;
		PageFactory.initElements(basedriver, this);
	}

	// WEBELEMENTS
	@FindBy(xpath = "//*[text()='My Affiliate Account']")
	public WebElement affiliateAccTxt;

	@FindBy(linkText = "Change your password")
	public WebElement pwdChangeLink;

	@FindBy(linkText = "Modify your address book entries")
	public WebElement addressModifyLink;

	@FindBy(name = "password")
	public WebElement pwdInput;

	@FindBy(name = "confirm")
	public WebElement pwdConfirmInput;

	@FindBy(xpath = "//*[@value='Continue']")
	public WebElement continueBtn;

	@FindBy(xpath = "//*[text()='Password must be between 4 and 20 characters!']")
	public WebElement pwdErrTxt;

	@FindBy(xpath = "//*[text()='Password confirmation does not match password!']")
	public WebElement pwdConfirmErrTxt;

	// ACTION METHODS
	public boolean verifyAffiliateAccTxtIsDisplayed() {
		return CommonActions.isElementDisplayed(affiliateAccTxt);
	}

	public void clickPwdChange() {
		CommonActions.clickElement(pwdChangeLink);
	}

	public void clickAddressModify() {
		CommonActions.clickElement(addressModifyLink);
	}

	public void enterPwd(String password) {
		CommonActions.enterText(pwdInput, password);
	}

	public void enterConfirmPwd(String pwdConfirm) {
		CommonActions.enterText(pwdConfirmInput, pwdConfirm);
	}

	public boolean verifyPwdErrTxtIsDisplayed() {
		return CommonActions.isElementDisplayed(pwdErrTxt);
	}

	public boolean verifyPwdConfirmErrTxtIsDisplayed() {
		return CommonActions.isElementDisplayed(pwdConfirmErrTxt);
	}

	public void clickContinue() {
		CommonActions.clickElement(continueBtn);
	}
}
