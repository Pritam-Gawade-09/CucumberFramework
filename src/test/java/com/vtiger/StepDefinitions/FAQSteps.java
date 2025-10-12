package com.vtiger.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FAQSteps extends BaseSteps {
    @When("user clicks on New FAQ link")
    public void user_clicks_on_new_faq_link() {
       getHomePage().clickNewFAQ();
    }
    @When("user clicks on Change button next to the product name and user switches to product search popup and selects a product name")
    public void user_clicks_on_change_button_next_to_the_product_name_and_user_switches_to_product_search_popup_and_selects_a_product_name() throws InterruptedException {
       getFAQPage().SetProductName();
       Thread.sleep(2000);
    }



    @When("user selects status from options")
    public void user_selects_status_from_options() {
        getFAQPage().SelectStatus(dt.get(TCName).get("Status"));
    }
    @When("user selects category from options")
    public void user_selects_category_from_options() {
       getFAQPage().SelectCategory(dt.get(TCName).get("category"));
    }
    @When("user enters question")
    public void user_enters_question() {
          getFAQPage().SetQuestion(dt.get(TCName).get("Question"));
    }
    @When("user enters answer")
    public void user_enters_answer() {
        getFAQPage().SetAnswer(dt.get(TCName).get("Answer"));
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        getFAQPage().clickSave();
    }
    @Then("FAQ should be submitted successfully")
    public void faq_should_be_submitted_successfully() {

    }

}
