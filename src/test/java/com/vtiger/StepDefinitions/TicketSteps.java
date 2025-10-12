package com.vtiger.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketSteps extends BaseSteps{
    @When("user click on New Ticket link")
    public void user_click_on_new_ticket_link() {
       getHomePage().clickNewTicket();
    }
    @When("user click assign radio button")
    public void user_click_assign_radio_button() {
      getTicketPage().Assign();
    }
    @When("user select priority from dropdown")
    public void user_select_priority_from_dropdown() throws InterruptedException {
        Thread.sleep(2000);
      getTicketPage().SelectPriority(dt.get(TCName).get("Priority"));
    }
    @When("user select severity from dropdown")
    public void user_select_severity_from_dropdown() {
     getTicketPage().SelectSeverity(dt.get(TCName).get("Severity"));
    }
    @When("user select category from dropdown")
    public void user_select_category_from_dropdown() {
      getTicketPage().SelectCategory(dt.get(TCName).get("Category"));
    }
    @When("user enters Title into TextArea")
    public void user_enters_title_into_text_area() {
       getTicketPage().SetTitle(dt.get(TCName).get("Title"));
    }
    @When("And user select parent_type from dropdown")
    public void user_select_parent_type_from_dropdown(){
      getTicketPage().SelectParentType(dt.get(TCName).get("ParentType"));
    }
    @When("user click on change button and user switch to parent_type popup and click on parent_type name")
    public void user_click_on_change_button_and_user_switch_to_parent_type_popup_and_click_on_parent_type_name() throws InterruptedException {
      getTicketPage().SetParentType();
      Thread.sleep(2000);
    }
    @When("user click on Change button next to the Product Name and user switches to Product List popup and click on Product name")
    public void user_click_on_change_button_next_to_the_product_name_and_user_switches_to_product_list_popup_and_click_on_product_name() throws InterruptedException {
        getTicketPage().SetProductName();
        Thread.sleep(2000);
    }
    @When("user select Status from dropdown")
    public void user_select_status_from_dropdown() throws InterruptedException {
     getTicketPage().SelectStatus(dt.get(TCName).get("Status "));
     Thread.sleep(2000);
    }
    @When(" And user click on save button")
    public void  And_user_click_on_save_button(){
      getTicketPage().clickSave();
    }
    @Then("user should be successfully create ticket")
    public void user_should_be_successfully_create_ticket() {

    }

}
