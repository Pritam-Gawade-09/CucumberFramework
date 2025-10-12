Feature: Task functionality
  Background:
    Given user should be on login page
    When user enters valid userid
    And user enters valid password
    And user click on login button

    @task
    Scenario: Add new task_TC11
      When user click on New Task Link
      And user enters subject to subjectbox
      And user enter Start date and time
      And user enter Due date
      And user click on save button in Task Page
      Then user should be successfully add new tasks