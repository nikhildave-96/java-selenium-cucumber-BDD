# @LoginTests is the tagName that can be mentioned in @CucumberOptions under tags in TestRunner for running only this feature.
@LoginTests
Feature: Test login functionality

# Background defined gets set before executing every Scenario within this feature file.
# Background defined gets set before executing every Scenario Outline execution.
Background: Login page is visible
Given User is on loginpage

# multiple tags are also allowed but they should be space separated
@smoke @Positive
Scenario: Verify_login_for_valid_credentials
When User enters username and password
And User clicks Login button
Then User should be able to see My Affiliate Account text

@regression @Negative
Scenario Outline: Verify_login_error_for_invalid_credentials
When User enters invalid "<username>" and "<password>"
And User clicks Login button
Then User should be able to see error

Examples:
| username | password |
| admin@spacex.com	| test123 |
#| super.user@gmail.com |	Demo456 |
#| demo.user@yahoo.com	| Datamt789 |
