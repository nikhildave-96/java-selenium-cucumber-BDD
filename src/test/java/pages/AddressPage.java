package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonActions;

public class AddressPage {
	static WebDriver localdriver;

	public AddressPage(WebDriver basedriver) {
		localdriver = basedriver;
		PageFactory.initElements(basedriver, this);
	}

	// WEBELEMENTS
	@FindBy(linkText = "New Address")
	public WebElement newAddressLink;

	@FindBy(name = "firstname")
	public WebElement firstNameInput;

	@FindBy(name = "lastname")
	public WebElement lastNameInput;

	@FindBy(name = "address_1")
	public WebElement address1Input;

	@FindBy(name = "city")
	public WebElement cityInput;

	@FindBy(name = "postcode")
	public WebElement postInput;

	@FindBy(id = "input-country")
	public WebElement countryDropdown;

	@FindBy(id = "input-zone")
	public WebElement regionDropdown;

	@FindBy(xpath = "//*[text()='Yes']")
	public WebElement defaultAddressYesRadio;

	@FindBy(xpath = "//*[text()='No']")
	public WebElement defaultAddressNoRadio;

	@FindBy(xpath = "//*[@value='Continue']")
	public WebElement continueBtn;

	@FindBy(xpath = "//*[text()='Your address has been successfully added']")
	public WebElement addAddressSuccessTxt;

	@FindBy(xpath = "//*[text()='Your address has been successfully deleted']")
	public WebElement deleteAddressSuccessTxt;

	// ACTION METHODS
	public void clickNewAddress() {
		CommonActions.clickElement(newAddressLink);
	}

	public void enterFirstName(String fname) {
		CommonActions.enterText(firstNameInput, fname);
	}

	public void enterLastName(String lname) {
		CommonActions.enterText(lastNameInput, lname);
	}

	public void enterAdress1(String addr1) {
		CommonActions.enterText(address1Input, addr1);
	}

	public void enterCity(String city) {
		CommonActions.enterText(cityInput, city);
	}

	public void enterPostcode(String post) {
		CommonActions.enterText(postInput, post);
	}

	public void selectDefaultAddressYes() {
		CommonActions.clickElement(defaultAddressYesRadio);
	}

	public void selectCountry(String country) {
		CommonActions.selectDropdownValue(countryDropdown, country);
	}

	public void selectRegion(String region) {
		CommonActions.selectDropdownValue(regionDropdown, region);
	}

	public void clickContinue() {
		CommonActions.clickElement(continueBtn);
	}

	public boolean verifyAddressAddSuccessTxtIsDisplayed() {
		return CommonActions.isElementDisplayed(addAddressSuccessTxt);
	}

	public boolean verifyAddressDeleteSuccessTxtIsDisplayed() {
		return CommonActions.isElementDisplayed(deleteAddressSuccessTxt);
	}

	public void clickAddressDeleteButton(String username) {
		CommonActions.clickElement(localdriver
				.findElement(By.xpath("//*[text()='" + username + "']/following-sibling::td/*[text()='Delete']")));
	}
}
