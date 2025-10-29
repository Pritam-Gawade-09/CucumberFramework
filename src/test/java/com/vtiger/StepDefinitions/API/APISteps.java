package com.vtiger.StepDefinitions.API;

import com.vtiger.utils.APIUtilities;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;


public class APISteps extends APIUtilities {





    @Given("url")
    public void url() {

        getURL();
    }
    @When("user perform GET operation")
    public void user_perform_get_operation() {
       GET();
    }
    @Then("user can validate status cade")
    public void user_can_validate_status_cade() {
        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(),Integer.parseInt(apidt.get(TCName).get("Status code")));
        validateResponse(Integer.parseInt(apidt.get(TCName).get("Status code")),resp.getStatusCode());
      //  Assert.assertTrue(resp.getStatusLine().contains("OK"));
        Assert.assertEquals(resp.getContentType(),"application/json; charset=utf-8");

    }
    @Then("user can also validate response")
    public void user_can_also_validate_response()
    {
        int page= resp.jsonPath().getInt("page");
        int perPage= resp.jsonPath().getInt("per_page");
        int total= resp.jsonPath().getInt("total");
        int totalpages= resp.jsonPath().getInt("total_pages");

        Assert.assertEquals(page,2);
        validateResponse(page,2);
        Assert.assertEquals(perPage,6);
        validateResponse(perPage,6);
        Assert.assertEquals(total,12);
        Assert.assertEquals(totalpages,2);

        List<Map<String,Object>> data= resp.jsonPath().getList("data");
        Assert.assertEquals(data.size(),6,"Data size check");

        Assert.assertEquals(data.get(0).get("id"),7);
        Assert.assertEquals(data.get(0).get("email"),"michael.lawson@reqres.in");
        validateResponse(data.get(0).get("email").toString(),"michael.lawson@reqres.in");
        Assert.assertEquals(data.get(0).get("first_name"),"Michael");

        Assert.assertEquals(data.get(0).get("last_name"),"Lawson");
        Assert.assertTrue(data.get(0).get("avatar").toString().contains("7-image.jpg"));
    }
    @Then("user can  validate response of single user")
    public void user_can_validate_response_of_single_user() {
        int id = resp.jsonPath().getInt("data.id");
        String email = resp.jsonPath().getString("data.email");
        String firstName = resp.jsonPath().getString("data.first_name");
        String lastName = resp.jsonPath().getString("data.last_name");
        String avatar = resp.jsonPath().getString("data.avatar");

        Assert.assertEquals(id, 2);
        Assert.assertEquals(email, "janet.weaver@reqres.in");
        Assert.assertEquals(firstName, "Janet");
        Assert.assertEquals(lastName, "Weaver");
        Assert.assertTrue(avatar.contains("2-image.jpg"), "Avatar should contain user id in image name");

        // support object
        String supportUrl = resp.jsonPath().getString("support.url");
        String supportText = resp.jsonPath().getString("support.text");

        Assert.assertEquals(supportUrl, "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral");
        Assert.assertEquals(supportText, "Tired of writing endless social media content? Let Content Caddy generate it for you.");

    }
    @When("user perform POST operation")
    public void user_perform_post_operation() {
        String requestBody=GeneratePostRequestswagger();
        report.info("Request=" + requestBody.toString());
        resp =  RestAssured.given()
                .header("x-api-key",prop.getProperty("API_Key"))
                .header("Content-Type","application/json")
                .body(requestBody)
                .when()
                .post(EndPoint);
        System.out.println(resp.asPrettyString());
        report.info("User perform POST operation");
        report.info(resp.asPrettyString());
        report.info("Response ="+ resp.asPrettyString());
    }
    @Then("user can  validate response of create user")
    public void user_can_validate_response_of_create_user() {

        validateResponse(resp.getStatusCode(),201);
        validateResponse(resp.jsonPath().getString("name").toString(),apidt.get(TCName).get("name"));
        validateResponse(resp.jsonPath().getString("job").toString(),apidt.get(TCName).get("job"));

        String createdAt=resp.jsonPath().getString("createdAt");
        assertThat(createdAt,matchesPattern("^\\d{4}-\\d{2}-\\d{2}T.*Z$"));

    }

    @When("user perform PUT operation")
    public void user_perform_put_operation() {
        String requestBody=UpdatePutRequest();
        report.info("Request=" + requestBody.toString());
        resp =  RestAssured.given()
                .header("x-api-key",prop.getProperty("API_Key"))
                .header("Content-Type","application/json")
                .body(requestBody)
                .when()
                .put(EndPoint);
        System.out.println(resp.asPrettyString());
        report.info("User perform PUT operation");
        report.info(resp.asPrettyString());
        report.info("Response ="+ resp.asPrettyString());
    }
    @Then("user can validate status cade of update user")
    public void user_can_validate_status_cade_of_update_user() {
        Assert.assertEquals(resp.getStatusCode(),Integer.parseInt(apidt.get(TCName).get("Status code")));
        validateResponse(Integer.parseInt(apidt.get(TCName).get("Status code")),resp.getStatusCode());
    }
    @Then("user can also validate response of update user")
    public void user_can_also_validate_response_of_update_user() {
        validateResponse(resp.jsonPath().getString("name").toString(),apidt.get(TCName).get("name"));
        validateResponse(resp.jsonPath().getString("job").toString(),apidt.get(TCName).get("job"));

    }
}




