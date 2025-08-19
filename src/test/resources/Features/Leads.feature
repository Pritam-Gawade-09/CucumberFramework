Feature: Leads functionality

  Background:
    Given user should be on login page
    When user enters valid userid
    And user enters valid password
    And user click on login button

  @ldp
  Scenario: Create_Lead_with mandatory_fields_TC03
    When user click on new lead link
    And user enters the lastname and company and click on save button
    Then lead should be created successfully
