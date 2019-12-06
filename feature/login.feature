Feature: Test Salesforce login functionality
i want to use this feature file to test the login functionality of our salesforce application.

Scenario Outline: login using valid credentials
Given i open chrome browser
And i go to salesforce home page
 When I enter username "<username>" and password "<password>"
When i click the login button
Then i see the dashboard



  Examples:
 |username                  |password          |
 |test.user@gmail.com.test  |Welcome1          |