Feature: Product Functionality
  Background:
    Given user should be on login page
    When user enters valid userid
    And user enters valid password
    And user click on login button

   @product
    Scenario: Create a new Product with  details_TC08
      When user clicks on New Product link
      And user enter product name
      And user check product active status
      And user select manufacture from dropdown options
      And user click on calender icon in front of Sales End Date and select Year,Month,Date
      And user click on calender icon in front of Support expiry date and select Year,Month,Date
      And user clicks on Change button next to the Contact and user switches to Contact List popup and select name
      And user clicks on Change button next to the Vendor and user switches to Vendor List popup and select  Vendor name
      And user click on calender icon in front of Sales Start Date and select Year,Month,Date
      And user click on calender icon in front of Support Start date and select Year,Month,Date
      And user select parent_type from dropdown
      And user clicks on Change button next to the parent_type and user switch to the lead list popup and select lead
      And user choose file from window
      And user click on save button
      Then user should be see all information successfully submitted






