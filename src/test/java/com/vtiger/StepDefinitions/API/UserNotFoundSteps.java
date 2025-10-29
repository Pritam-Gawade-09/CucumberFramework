package com.vtiger.StepDefinitions.API;

import com.vtiger.utils.APIUtilities;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import org.testng.Assert;

public class UserNotFoundSteps extends APIUtilities {
    @Given("url of UserNotFound API")
    public void url_of_user_not_found_api() {
      getURL();
    }
    @When("user perform GET operation for UserNotFound")
    public void user_perform_get_operation_for_user_not_found() {
       GET();
    }
    @Then("user can validate status cade of UserNotFoundAPI")
    public void user_can_validate_status_cade_of_user_not_found_api() {
        verifyStatusCode();}
    @Then("user can also validate response of UerNotFound")
    public void user_can_also_validate_response_of_uer_not_found() {

    }
}
