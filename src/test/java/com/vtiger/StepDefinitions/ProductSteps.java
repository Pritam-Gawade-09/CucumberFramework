package com.vtiger.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps extends BaseSteps{
    @When("user clicks on New Product link")
    public void user_clicks_on_new_product_link() {
     getHomePage().clickNewProduct();
    }
    @When("user enter product name")
    public void user_enter_product_name() {
      getProductPage().SetProductName(dt.get(TCName).get("ProductName"));
    }
    @When("user check product active status")
    public void user_check_product_active_status() {
       getProductPage().SetProductStatus();
    }
    @When("user select manufacture from dropdown options")
    public void user_select_manufacture_from_dropdown_options() {
      getProductPage().SelectManufacture(dt.get(TCName).get("Manufacturer"));
    }
    @When("user click on calender icon in front of Sales End Date and select Year,Month,Date")
    public void user_click_on_calender_icon_in_front_of_sales_end_date_and_select_year_month_date() {
    //getProductPage().Calender(dt.get(TCName).get("Year"));
    }
    @When("user click on calender icon in front of Support expiry date and select Year,Month,Date")
    public void user_click_on_calender_icon_in_front_of_support_expiry_date_and_select_year_month_date() {

    }
    @When("user clicks on Change button next to the Contact and user switches to Contact List popup and select name")
    public void user_clicks_on_change_button_next_to_the_contact_and_user_switches_to_contact_list_popup_and_select_name() {
    getProductPage().SetContactName();
    }
    @When("user clicks on Change button next to the Vendor and user switches to Vendor List popup and select  Vendor name")
    public void user_clicks_on_change_button_next_to_the_vendor_and_user_switches_to_vendor_list_popup_and_select_vendor_name() {
     getProductPage().SetVendorName();
    }

    @When("user click on calender icon in front of Sales Start Date and select Year,Month,Date")
    public void user_click_on_calender_icon_in_front_of_sales_start_date_and_select_year_month_date() {

    }
    @When("user click on calender icon in front of Support Start date and select Year,Month,Date")
    public void user_click_on_calender_icon_in_front_of_support_start_date_and_select_year_month_date() {

    }
    @When("user select parent_type from dropdown")
    public void user_select_parent_type_from_dropdown() {
    getProductPage().SelectParentName(dt.get(TCName).get("ParentName"));
    }
    @When("user clicks on Change button next to the parent_type and user switch to the lead list popup and select lead")
    public void user_clicks_on_change_button_next_to_the_parent_type_and_user_switch_to_the_lead_list_popup_and_select_lead() {
    getProductPage().SetLead();
    }
    @When("user choose file from window")
    public void user_choose_file_from_window() throws InterruptedException {
        Thread.sleep(2000);
     getProductPage().SetFile(dt.get(TCName).get("Product_Img"));
    }


    @Then("user should be see all information successfully submitted")
    public void user_should_be_see_all_information_successfully_submitted() {

    }

}
