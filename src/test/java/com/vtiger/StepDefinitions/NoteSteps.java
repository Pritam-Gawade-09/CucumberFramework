package com.vtiger.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NoteSteps extends BaseSteps {

    @When("user click on New Note Link")
    public void user_click_on_new_note_link() {
        getHomePage().clickNewNote();
    }

    @When("user click on change button next to the contact name and user switch to the contact list popup and user select contact name")
    public void user_click_on_change_button_next_to_the_contact_name_and_user_switch_to_the_contact_list_popup_and_user_select_contact_name() throws InterruptedException {

        getNotePage().SetContactName();
    }

    @When("user enter subject")
    public void user_enter_subject() {
        if (dt.get(TCName) == null) {
            throw new RuntimeException("❌ Test data missing for: " + TCName);
        }
        getNotePage().SetSubject(dt.get(TCName).get("Subject"));
    }

    @When("user choose the file")
    public void user_choose_the_file() throws InterruptedException {
        if (dt.get(TCName) == null) {
            throw new RuntimeException("❌ Test data missing for: " + TCName);
        }
        getNotePage().ChooseFile(dt.get(TCName).get("Path"));
        Thread.sleep(2000);
    }

    @When("user enter Note")
    public void user_enter_note() {
        if (dt.get(TCName) == null) {
            throw new RuntimeException("❌ Test data missing for: " + TCName);
        }
        getNotePage().SetNoteContect(dt.get(TCName).get("Note_Contect"));
    }

    @When("user Select parent_type from parent_type list")
    public void user_select_parent_type_from_parent_type_list() {
        if (dt.get(TCName) == null) {
            throw new RuntimeException("❌ Test data missing for: " + TCName);
        }
        getNotePage().SelectParetType(dt.get(TCName).get("Products"));
    }

    @When("user click on change button next to paret_type and user switch to the popup and select option")
    public void user_click_on_change_button_next_to_paret_type_and_user_switch_to_the_popup_and_select_option() throws InterruptedException {
        if (dt.get(TCName) == null) {
            throw new RuntimeException("❌ Test data missing for: " + TCName);
        }
        getNotePage().SetParentTypeChange();
        Thread.sleep(2000);
    }

    @When("user click on save button of Note page")
    public void user_click_on_save_button_of_note_page() {
        getNotePage().clickSaveNote();
    }

    @Then("user should be successfully add new note")
    public void user_should_be_successfully_add_new_note() {
        System.out.println("✅ Note added successfully for: " + TCName);
    }
}
