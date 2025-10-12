package com.vtiger.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskSteps extends BaseSteps{
    @When("user click on New Task Link")
    public void user_click_on_new_task_link() {
       getHomePage().clickNewTask();
    }
    @When("user enters subject to subjectbox")
    public void user_enters_subject_to_subjectbox() {
        getTaskPage().setSubject(dt.get(TCName).get("Subject"));
    }
    @When("user enter Start date and time")
    public void user_enter_start_date_and_time() throws InterruptedException {

       getTaskPage().setStartDate(dt.get(TCName).get("Date-start"));
       Thread.sleep(2000);
    }
    @When("user enter Due date")
    public void user_enter_due_date() throws InterruptedException {
        Thread.sleep(200);
     getTaskPage().setDueDate(dt.get(TCName).get("Date-End"));
    }
    @When("user click on save button in Task Page")
    public void user_click_on_save_button_in_Task_Page() {
        getTaskPage().clickSave();
    }

    @Then("user should be successfully add new tasks")
    public void user_should_be_successfully_add_new_tasks() {

    }

}
