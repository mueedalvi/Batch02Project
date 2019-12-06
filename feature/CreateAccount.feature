Feature: Test Salesforce Create Account functionality
i want to use this feature file to test the create Account functionality of our salesforce application.

Scenario Outline: login using valid credentials
Given i open chrome browser
And i go to salesforce home page
 When I enter username "<username>" and password "<password>"
When i click the login button
Then i see the dashboard
And i Create an account 
		|Account Name |Phone        |Parent Account         |                    Fax        |  Type    |
		|Citibank     |703-765-2301 | Aethna Home Products  |                 703-988-0000  |Prospect  |
		|Wells Fargo  |703-764-0000 | At&t                  |                 703-090-0011  |Other   |

  Examples:
 |username                  |password          |
 |test.user@gmail.com.test  |Welcome1          |
