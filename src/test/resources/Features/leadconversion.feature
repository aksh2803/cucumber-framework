Feature: To test the lead conversion page functionality
@smoketest
Scenario: Validate the login is successful with valid credentials
    Given User should navigate to the salesforce web application
    When User should enter the username as "akshayab1328@gmail.com" and password as "Akshayamnji1998"
    Then User should click the login button
    #Scenario: User should navigate to the lead creation page
    #Given User is on the salesforce home page
    Then User should click the app launcher
    And User should click the search box
    And User should click the leads
    #Scenario: User should be able to create a lead successfully
    #Given User is on the Lead page
    And User should click the new button
    And User enters the firstname as "Akshaya" and lastname as "Manoj"
    And User enters the company as "Mastek" and title as "Test"
    And User successfully created the lead record
    #Scenario: User should highlight the fields
    #Given User is on the detail page
    Then User should click the detail tab
    Then User should highlight the lead owner
	  #Scenario: User should be able to convert the lead successfully
    #Given User is on the lead conversion page
    And User should click the dropdown
    And User should click the convert button
    And User should click the convert lead button