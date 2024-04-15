Feature: To test the home page functionality

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