#Author
#Date
#Description
Feature: to test the login functionality

  Scenario: Validate the login is successful with valid credentials
    Given User should navigate to the salesforce web application
    When User should enter the username and password
    Then User should click the login button
    