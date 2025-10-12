Feature: Account Functionality
  Background:
    Given user should be on login page
    When user enters valid userid
    And user enters valid password
    And user click on login button

    @AC
    Scenario: Create Account with mandatory_fields_TC04
      When user click on New Account link
      And user enters account name
      And user click on save button
      Then Account should be created successfully
