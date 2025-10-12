Feature: Ticket Functionality



  Background:
    Given user should be on login page
    When user enters valid username
    And user enters valid password
    And user click on login button

    @TC
    Scenario: Verify Ticket Information_TC09
      When user click on New Ticket link
      And user click assign radio button
      And user select priority from dropdown
      And user select severity from dropdown
      And user select category from dropdown
      And user enters Title into TextArea
      And user select parent_type from dropdown
      And user click on change button and user switch to parent_type popup and click on parent_type name
      And user click on Change button next to the Product Name and user switches to Product List popup and click on Product name
      And user select Status from dropdown
      And user click on save button
      Then user should be successfully create ticket


