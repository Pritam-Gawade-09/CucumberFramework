package com.vtiger.pages;

import com.vtiger.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Year;

public class TaskPage extends CommonActions {
   public TaskPage(WebDriver driver){
        super(driver);
        this.driver=driver;
       PageFactory.initElements(driver,this);
    }

    @FindBy(name = "subject")
    WebElement tb_subName;

   @FindBy(name = "date_start")
    WebElement tb_startdate;

   @FindBy(name = "due_date")
    WebElement tb_duedate;

   @FindBy(xpath = "//input[@type='submit']")
    WebElement btn_save;

   public void setSubject(String SubjectName){
      setInput(tb_subName,SubjectName);
   }
   public void setStartDate(String date){
      SetYearMonthDate(tb_startdate,date);
   }
   public void setDueDate(String date){
      SetYearMonthDate(tb_duedate,date);
   }
   public void clickSave(){
     clickElement(btn_save);
   }
}
