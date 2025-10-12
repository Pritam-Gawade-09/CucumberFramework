Feature: Note Functionality
  Background:
    Given user should be on login page
    When user enters valid username
    And user enters valid password
    And user clicks on save button

    @Note
    Scenario:Create_Note_With_valid_credentials_TC12
      When user click on New Note Link
      And user click on change button next to the contact name and user switch to the contact list popup and user select contact name
      And user enter subject
      And user choose the file
      And user enter Note
      And user Select parent_type from parent_type list
      And user click on change button next to paret_type and user switch to the popup and select option
      And user click on save button of Note page
      Then user should be successfully add new note