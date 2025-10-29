Feature: UserNotFound
  @NotFound
  Scenario: User Not found_TC07
    Given url of UserNotFound API
    When user perform GET operation for UserNotFound
    Then user can validate status cade of UserNotFoundAPI
    And  user can also validate response of UerNotFound