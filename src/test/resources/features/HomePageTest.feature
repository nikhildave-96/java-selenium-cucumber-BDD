Feature: Test login navigation

@oc_device_Windows11x64 @oc_author_NikhilDave
Scenario: Verify_loginPageNavigation
#When User clicks My Account
#And User clicks Login
#Then User should be able to see New Customer text

* User clicks My Account
* User selects Login
* User should be able to see New Customer text

# using * instead of Given-When-Then keywords offers more flexibility and marks as a step and 
# corresponding implementation for that step inside stepdefinition file can use any annotation (@And/@When/@Then)
