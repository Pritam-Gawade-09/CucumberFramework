Feature: API Testing
  @ls
  Scenario: List_Users_Testing_TC01
    Given url
    When user perform GET operation
    Then user can validate status cade
    And  user can also validate response

    @ls
    Scenario: Single_User_API_Testing_TC02
      Given url
      When user perform GET operation
      Then user can validate status cade
      And  user can  validate response of single user

      @ls
      Scenario: Create_User_TC03
        Given url
        When user perform POST operation
        Then user can validate status cade
        And user can  validate response of create user

       @ls

        Scenario: Update_User_TC04
          Given url
          When user perform PUT operation
          Then  user can validate status cade of update user
          And user can also validate response of update user

         @ls
         Scenario: Delete_User_TC05
           Given url
           When user perform DELETE operation
           Then user can validate status code of update user