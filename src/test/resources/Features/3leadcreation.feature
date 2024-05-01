Feature: To test the lead creation page functionality


    Scenario Outline: User should be able to create a lead successfully
    Given User is on the Lead page
    And User should click the new button
    Then User enters the sheetname "<Sheetname>" and rownumber <RowNumber>
    And Insert the values into the database
    And User successfully created the lead record
    #Scenario: User should highlight the fields
    #Given User is on the detail page
    Then User should click the detail tab
    Then User should highlight the lead owner
    
    Examples:
    | Sheetname | RowNumber |
    | LeadCreation | 0 |