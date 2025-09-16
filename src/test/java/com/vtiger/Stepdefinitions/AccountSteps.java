package com.vtiger.Stepdefinitions;

import com.vtiger.pages.PageObjectManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSteps extends BaseSteps {
    @When("user click on New Account link")
    public void user_click_on_new_account_link() {
       getHomePage().clickNewAccount();
    }
    @When("user enters account name")
    public void user_enters_account_name() {
       getAccountPage().SetAccountName(dt.get(TCName).get("Account"));
    }

    @When("user click on save button")
    public void user_click_on_save_button(){
        getAccountPage().ClickSave();
    }
    @Then("Account should be created successfully")
    public void account_should_be_created_successfully() {

    }

}
