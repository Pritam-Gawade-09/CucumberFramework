package com.vtiger.pages;

import com.vtiger.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage extends CommonActions {


    public LeadPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(name="lastname")
    WebElement tb_lastname;

    @FindBy(name="company")
    WebElement tb_company;

    @FindBy(name="button")
    WebElement btn_save;


    public void createLead(String lname, String comp)
    {
        SetLastName(lname);
        SetCompany(comp);
        clickSave();
    }

    public void SetLastName(String lname)
    {
       setInput(tb_lastname,lname);
    }

    public void SetCompany(String comp)
    {
      setInput(tb_company,comp);
    }



    public void clickSave()
    {

        clickElement(btn_save);
    }



}
