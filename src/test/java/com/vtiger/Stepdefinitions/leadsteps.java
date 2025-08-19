package com.vtiger.Stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class leadsteps extends basesteps {




    @When("user click on new lead link")
    public void user_click_on_new_lead_link() {
     getHomePage().clickNewLead();
    }
    @When("user enters the lastname and company and click on save button")
    public void user_enters_the_lastname_and_company_and_click_on_save_button() {
        getLeadPage().createLead(dt.get(TCName).get("Lastname"),dt.get(TCName).get("Company"));
    }
    @Then("lead should be created successfully")
    public void lead_should_be_created_successfully() {

    }
    @When("user click on new lead and enters the lastname and company and click on save button")
    public void abc(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> ls = dataTable.asMaps();
        for(int i= 0;i<ls.size();i++) {
            getHomePage().clickNewLead();
            getLeadPage().createLead(ls.get(i).get("lname"),ls.get(i).get("comp"));

        }
    }




    @When("click logout")
    public void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }
}
