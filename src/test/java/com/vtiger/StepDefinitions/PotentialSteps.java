package com.vtiger.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PotentialSteps extends BaseSteps {
    @When("user click on New potential link")
    public void user_click_on_new_potential_link() {
       getHomePage().clickNewPotential();
    }
    @When("user enters potential name")
    public void user_enters_potential_name() {
       getPotentialPage().SetPotentialName(dt.get(TCName).get("Potential_Name"));
    }
    @When("user clicks on Change button next to Account Name")
    public void user_clicks_on_change_button_next_to_account_name() {
        getPotentialPage().clickAcName();
    }
    @When("User switches to account selection popup")
    public void user_switches_to_account_selection_popup() {
        getPotentialPage().switchAcWindowPopup();
    }
    @When("User selects  account")
    public void user_selects_account() {
        getPotentialPage().selectAcname();
    }
    @When("user enter date")
    public void user_enter_date() throws InterruptedException {
        //Thread.sleep(2000);
     getPotentialPage().SetDate("2025-09-09");
    }
    @When("User Select Stage")
    public void user_select_stage() {
       getPotentialPage().SelectStage(dt.get(TCName).get("Sales_Stave"));
    }
    @Then("user should be create potential successfully")
    public void user_should_be_create_potential_successfully() {

    }




}
