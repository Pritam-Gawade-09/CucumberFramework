Feature: List of Resources
  @LOR
  Scenario: Verify List Of Resources_TC08
    Given endpoint url for list of resources
    When user perform GET operation for ListOfResources API
    Then user can validate status cade of ListOfResources API
    And  user can also validate response of ListOfResources API