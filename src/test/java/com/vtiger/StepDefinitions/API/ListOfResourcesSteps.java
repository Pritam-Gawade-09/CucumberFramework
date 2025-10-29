package com.vtiger.StepDefinitions.API;

import com.vtiger.utils.APIUtilities;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ListOfResourcesSteps extends APIUtilities {
    @Given("endpoint url for list of resources")
    public void endpoint_url_for_list_of_resources() {
       getURL();
    }
    @When("user perform GET operation for ListOfResources API")
    public void user_perform_get_operation_for_list_of_resources_api() {
        GET();
    }
    @Then("user can validate status cade of ListOfResources API")
    public void user_can_validate_status_cade_of_list_of_resources_api() {
        verifyStatusCode();
    }
    @Then("user can also validate response of ListOfResources API")
    public void user_can_also_validate_response_of_list_of_resources_api() {
        // Extract top-level values
        int page = resp.jsonPath().getInt("page");
        int perPage = resp.jsonPath().getInt("per_page");
        int total = resp.jsonPath().getInt("total");
        int totalPages = resp.jsonPath().getInt("total_pages");

// Validate top-level values
        Assert.assertEquals(page, 1, "Page number check");
        validateResponse(page, 1);

        Assert.assertEquals(perPage, 6, "Per page check");
        validateResponse(perPage, 6);

        Assert.assertEquals(total, 12, "Total records check");
        Assert.assertEquals(totalPages, 2, "Total pages check");

// Extract 'data' list
        List<Map<String, Object>> data = resp.jsonPath().getList("data");

// Validate size of 'data' array
        Assert.assertEquals(data.size(), 6, "Data size check");

// Validate first object in 'data'
        Map<String, Object> firstUser = data.get(0);

        Assert.assertEquals(firstUser.get("id"), 1, "ID check");
        Assert.assertEquals(firstUser.get("name"), "cerulean", "Name check");
        Assert.assertEquals(firstUser.get("year"), 2000, "Year check");
        Assert.assertEquals(firstUser.get("color"), "#98B2D1", "Color check");
        Assert.assertEquals(firstUser.get("pantone_value"), "15-4020", "Pantone value check");

// Example for multiple users: loop through all
        for (Map<String, Object> user : data) {
            Assert.assertNotNull(user.get("id"), "User ID should not be null");
            Assert.assertNotNull(user.get("name"), "User name should not be null");
        }

    }

}
