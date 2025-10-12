package com.vtiger.pages;

import com.vtiger.utils.CommonActions;
import io.cucumber.java.de.Wenn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketPage extends CommonActions {

    public TicketPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@type='radio'][1]")
    WebElement rad_assignUser;

    @FindBy(name = "ticketpriorities")
    WebElement dd_Priority;

    @FindBy(name = "ticketseverities")
    WebElement dd_severity;

    @FindBy(name = "ticketcategories")
    WebElement dd_category;

    @FindBy(name = "ticket_title")
    WebElement ta_Title;

    @FindBy(name = "parent_type")
    WebElement dd_ParentType;

    @FindBy(xpath = "//input[@value='Change'][1]")
    WebElement btn_ChangeParentType;

    @FindBy(xpath = "//table[@class='FormBorder']//tr/td/a[normalize-space(text())='Dorothy Taylor']")
    WebElement lnk_PTName;

    @FindBy(xpath = "(//input[@value='Change'])[2]")
    WebElement btn_ChangeProductName;

    @FindBy(xpath = "//table[@class='FormBorder']//tr/td/a[normalize-space(text())='Vtiger 25 Users Pack']")
    WebElement lnk_ProductName;

    @FindBy(name = "ticketstatus")
    WebElement dd_Status;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement btn_Save;

    public void Assign(){
      clickElement(rad_assignUser);
    }
    public void SelectPriority(String value){
       SelectOption(dd_Priority,value);
    }
    public void SelectSeverity(String value){
        SelectOption(dd_severity,value);

    }
    public void SelectCategory(String value){
      SelectOption(dd_category,value);
    }
    public void SetTitle(String value){
      setInput(ta_Title,value);
    }
    public void SelectParentType(String value){
      SelectOption(dd_ParentType,value);
    }
    public void SetParentType(){
      SwitchWindow(btn_ChangeParentType,lnk_PTName);
    }
    public void SetProductName(){
      SwitchWindow(btn_ChangeProductName,lnk_ProductName);
    }
    public void SelectStatus(String value){
      SelectOption(dd_Status,value);
    }
    public void clickSave(){
   clickElement(btn_Save);
    }


}
