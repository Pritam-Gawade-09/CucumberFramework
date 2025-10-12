Feature: FAQ Functionality

  Background:
    Given user should be on login page
    When user enters valid userid
    And user enters valid password
    And user click on login button

   @FAQ
  Scenario: Submit Question and Answer successfully_TC07
    When user clicks on New FAQ link
    And user clicks on Change button next to the product name and user switches to product search popup and selects a product name
    And user selects status from options
    And user selects category from options
    And user enters question
    And user enters answer
    And user clicks on save button
    Then FAQ should be submitted successfully
