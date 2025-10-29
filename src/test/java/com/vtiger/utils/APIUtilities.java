package com.vtiger.utils;

import com.vtiger.StepDefinitions.BaseSteps;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class APIUtilities extends BaseSteps {

    public Response resp;
    public String EndPoint;

    public static void validateResponse(String expected, String actual) {
        if (expected.equalsIgnoreCase(actual))

            report.pass(expected + " result Match with actual result" + actual);
        else
            report.fail(expected + " expected result  did not Match with actual result" + actual);

    }

    public static void validateResponse(int expected, int actual) {
        if (expected == actual)

            report.pass(expected + " result Match with actual result" + actual);

        else
            report.fail(expected + " expected result  did not Match with actual result" + actual);

    }

    public static String GeneratePostRequest() {

        try {
            String TemplateName = apidt.get(TCName).get("Templates");
            String jsonTemplate = new String(Files.readAllBytes(Paths.get("src/test/resources/Templates/" + TemplateName)));
            jsonTemplate = new String(Files.readAllBytes(Paths.get("src/test/resources/Templates/" + TemplateName)));
            String requestBody = jsonTemplate
                    .replace("%name%", apidt.get(TCName).get("name"))
                    .replace("%job%", apidt.get(TCName).get("job"));
            return requestBody;



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    public static String UpdatePutRequest() {

        try {
            String TemplateName = apidt.get(TCName).get("Templates");
            String jsonTemplate = new String(Files.readAllBytes(Paths.get("src/test/resources/Templates/" + TemplateName)));
            jsonTemplate = new String(Files.readAllBytes(Paths.get("src/test/resources/Templates/" + TemplateName)));
            String requestBody = jsonTemplate
                    .replace("%name%", apidt.get(TCName).get("name"))
                    .replace("%job%", apidt.get(TCName).get("job"));
            return requestBody;



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;

    }
    public void getURL(){
        EndPoint=prop.getProperty("API_Url")+apidt.get(TCName).get("Path");
        report.info("Endpoint Url =" +EndPoint);
    }

    public static String GeneratePostRequestswagger() {
        try {
            // Get template name from Excel data
            String TemplateName = apidt.get(TCName).get("Templates");
            String jsonTemplate = new String(Files.readAllBytes(Paths.get("src/test/resources/Templates/" + TemplateName)));

            // Loop through all columns except "Templates"
            Map<String, String> tcData = apidt.get(TCName);
            for (Map.Entry<String, String> entry : tcData.entrySet()) {
                if (!entry.getKey().equals("Templates")) {
                    jsonTemplate = jsonTemplate.replace("%" + entry.getKey() + "%", entry.getValue());
                }
            }

            return jsonTemplate;

        } catch (Exception e) {
            System.out.println("Error generating POST request: " + e.getMessage());
            return null;
        }
    }

    public void verifyStatusCode() {
        try {
            // Get actual status code from Excel (TC-specific)
            int actualStatusCode = Integer.parseInt(apidt.get(TCName).get("Status code"));

            // Get expected status code from API response
            int expectedStatusCode = resp.getStatusCode();

            // Compare and report
            if(expectedStatusCode == actualStatusCode) {
                report.pass("✅ Status Code Match: Expected = " + expectedStatusCode
                        + ", Actual = " + actualStatusCode);
            } else {
                report.fail("❌ Status Code Mismatch: Expected = " + expectedStatusCode
                        + ", Actual = " + actualStatusCode);
            }
        } catch (NumberFormatException e) {
            report.fail("Invalid status code in Excel for TC: " + TCName);
        } catch (Exception e) {
            report.fail("Error during status code validation: " + e.getMessage());
        }
    }

    public void GET(){
        resp =  RestAssured.given()
                .header("x-api-key",prop.getProperty("API_Key"))
                .get(EndPoint);
        System.out.println(resp.asPrettyString());
        report.info("User perform GET operation");
        report.info(resp.asPrettyString());
    }


}

