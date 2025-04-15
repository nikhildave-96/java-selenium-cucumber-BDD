Feature: Test account related operations 

Background: Account page is visible
* User is logged in

Scenario: Verify_password_change_validations
* User clicks Change your password link
* User clicks Continue button
* User should be able to see password related error
* Take screenshot "Verify_password_change_validations_1"
* User enters "DemoBDD@12345" as password
#* Take screenshot "Verify_password_change_validations_2"
* User clicks Continue button
* User should be able to see confirm password related error
