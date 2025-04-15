Feature: Test address book functionality 

Background: Address page is visible
* User is logged in
* User clicks Modify your address book entries link

Scenario Outline: Verify_new_address_addition
* User clicks New Address button
* User enters address details
# usage of datatable helps avoid supplying params inside step instead sophistically separates defining params/data.
# below header is optional in the datatable, but if provided then should exactly match with map's key inside stepDefinition.
| firstname | lastname | address1 | city | postcode | country | region | defaultAddress |
# directly actual data can also be defined here instead of referencing from Examples, data reference should exactly match the header within <> from examples section. 
| <fname> | <lname> | <adr1> | <cty> | <pstcode> | <cntry> | <reg> | <defaultAdr> |
* User clicks on Continue button
* User should be able to see Your address has been successfully added text

Examples:
| fname | lname | adr1 | cty | pstcode | cntry | reg | defaultAdr |
| demo1 | user1 | aundh | pune | 400001 | India | Maharashtra | No |
#| demo2 | user2 | hadapsar | pune | 400002 | India | Maharashtra | No |
# below should be enabled for an additional iteration of the scenario.
#| demo3 | user3 | baner | pune | 400003 | India | Maharashtra | No |

# Design of testcase where address deletion occurs in a single iteration/testcase.
Scenario: Verify_address_deletion
* User clicks Modify your address book entries link
* User deletes address entries
| demo1 user1 |
#| demo2 user2 |
#| demo3 user3 |

# Another design of testcase where address deletion occurs in separate iterations/testcases.
#Scenario Outline: Verify_address_deletion_2
#* User clicks Modify your address book entries link
#* User deletes address entry
#| <firstName_lastName> |
#* User should be able to see Your address has been successfully deleted text
#
#Examples:
#| firstName_lastName |
#| demo1 user1 |
#| demo2 user2 |
#| demo3 user3 |
