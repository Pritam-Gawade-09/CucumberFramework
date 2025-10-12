Feature: Potential functionality
  Background:
    Given user should be on login page
    When user enters valid username
    And user enters valid password
    And user click on login button


  @Potential
    Scenario: Create potential with mandatory fields_TC06
      When user click on New potential link
      And user enters potential name
      And user clicks on Change button next to Account Name
      And User switches to account selection popup
      And User selects  account
      And user enter date
      And User Select Stage
      And user click on save button
      Then user should be create potential successfully




