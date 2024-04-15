#Author
#Date
#Description
Feature: to test the login functionality

  @smoketest
  Scenario: Validate the login is successful with valid credentials
    Given User should navigate to the salesforce web application
    When User should enter the username as "akshayab1328@gmail.com" and password as "Akshayamnji1998"
    Then User should click the login button
    