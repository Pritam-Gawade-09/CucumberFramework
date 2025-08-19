@regression
Feature: login

Background:
  Given user should be on login page

  @sanity
Scenario: valid_login_TC01
When user enters valid userid
And user enters valid password
And user click on login button
Then user should be navigated to home page
And user can see the logout link on home page

@smoke
Scenario: Invalid_login_TC02
When user enters invalid userid
And user enters invalid password
And user click on login button
Then user should be navigated to login page
And user can see the error message on login page

  @sanity @smoke
Scenario: Invalid login 2
When user enters invalid userid
And user click on login button
Then user should be navigated to login page
And user can see the error message on login page

    @defect123
Scenario: Invalid login 3
And user click on login button
Then user should be navigated to login page
And user can see the error message on login page

  @xyz
  Scenario Outline: Invalid login datadriven
    When user enters username as "<userid>"
    And user enters password as "<password>"
    And user click on login button
    Then user should be navigated to login page
    And user can see the error message on login page
    Examples:
    |userid | password |
  #  |admin12|pwd1      |
    |       |admin      |
  #  |admin  |admin111   |
  #  |admin  |null       |

