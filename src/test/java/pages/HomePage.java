package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonActions;

public class HomePage {
	static WebDriver localdriver;

	public HomePage(WebDriver basedriver) {
		localdriver = basedriver;
		PageFactory.initElements(basedriver, this);
	}

	// WEBELEMENTS
	@FindBy(xpath = "//span[text()='My Account']")
	public WebElement myAccountBtn;

	@FindBy(xpath = "//a[text()='Login']")
	public WebElement loginOpt;

	// ACTION METHODS
	public void clickMyAccount() {
		CommonActions.clickElement(myAccountBtn);
	}

	public void selectLogin() {
		CommonActions.clickElement(loginOpt);
	}

	public void navigateToLoginPage() {
		CommonActions.clickElement(myAccountBtn);
		CommonActions.clickElement(loginOpt);
	}

}
