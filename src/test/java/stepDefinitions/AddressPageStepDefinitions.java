package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pages.AccountPage;
import pages.AddressPage;
import pages.HomePage;
import pages.LoginPage;

public class AddressPageStepDefinitions {

	HomePage home = new HomePage(BaseTest.getDriver());
	LoginPage login = new LoginPage(BaseTest.getDriver());
	AccountPage account = new AccountPage(BaseTest.getDriver());
	AddressPage address = new AddressPage(BaseTest.getDriver());

	@And("User clicks Modify your address book entries link")
	public void User_clicks_Modify_your_address_book_entries_link() {
		account.clickAddressModify();
	}

	@And("User clicks New Address button")
	public void User_clicks_New_Address_button() {
		address.clickNewAddress();
	}

	@And("User enters address details")
	public void User_enters_address_details(DataTable table) {
		/*
		 * if header is not mentioned under the step in .feature file, then directly use
		 * data from the List of Lists ********************************************
		 * List<List<String>> addressDetails = table.asLists(String.class);
		 * System.out.println(addressDetails.get(0).get(0)); // returns demo1
		 * System.out.println(addressDetails.get(0).get(1)); // returns user1
		 * System.out.println(addressDetails.get(0).get(2)); // returns aundh
		 */

		List<Map<String, String>> addressDetails = table.asMaps(String.class, String.class);
//		[  List of Maps
//			 {"firstname":"demo1","lastname":"user1","address1":"aundh","city":"pune","postcode":"400001","country":"India","region":"Maharashtra","defaultAddress":"No"}
//		]

		address.enterFirstName(addressDetails.get(0).get("firstname").trim());
		address.enterLastName(addressDetails.get(0).get("lastname").trim());
		address.enterAdress1(addressDetails.get(0).get("address1").trim());
		address.enterCity(addressDetails.get(0).get("city").trim());
		address.enterPostcode(addressDetails.get(0).get("postcode").trim());
		address.selectCountry(addressDetails.get(0).get("country").trim());
		address.selectRegion(addressDetails.get(0).get("region").trim());

		if (addressDetails.get(0).get("defaultAddress").equals("Yes")) {
			address.selectDefaultAddressYes();
			System.out.println("inside if ...");
		}
	}

	@And("User clicks on Continue button")
	public void User_clicks_on_Continue_button() {
		address.clickContinue();
	}

	@And("User should be able to see Your address has been successfully added text")
	public void User_should_be_able_to_see_Your_address_has_been_successfully_added_text() {
		Assert.assertTrue(address.verifyAddressAddSuccessTxtIsDisplayed());
	}

	@And("User deletes address entry")
	public void User_deletes_address_entry(DataTable table) {
		List<List<String>> userName = table.asLists(String.class);
		address.clickAddressDeleteButton(userName.get(0).get(0));
	}

	@And("User should be able to see Your address has been successfully deleted text")
	public void User_should_be_able_to_see_Your_address_has_been_successfully_deleted_text() {
		Assert.assertTrue(address.verifyAddressDeleteSuccessTxtIsDisplayed());
	}

	@And("User deletes address entries")
	public void User_deletes_address_entries(DataTable table) {
		List<List<String>> deleteBtns = table.asLists(String.class);
//		[ List of Lists
//	 		["demo1 user1"],
//			["demo2 user2"]
//		]
		for (int i = 0; i < deleteBtns.size(); i++) {
			address.clickAddressDeleteButton(deleteBtns.get(i).get(0).trim());
			Assert.assertTrue(address.verifyAddressDeleteSuccessTxtIsDisplayed());
		}
	}
}
