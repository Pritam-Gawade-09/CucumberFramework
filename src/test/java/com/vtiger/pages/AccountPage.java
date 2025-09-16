package com.vtiger.pages;

import com.vtiger.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage  extends CommonActions {
    public AccountPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(name = "accountname")
    WebElement tb_AccName;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement btn_Save;


    public void CreateAccount(String AcName){
        SetAccountName(AcName);
        ClickSave();
        AcSuccessfullyCreate();
    }
    public void SetAccountName(String AcName){

        setInput(tb_AccName,AcName);
    }
    public void ClickSave(){
       clickElement(btn_Save);
    }
    public void AcSuccessfullyCreate(){

    }
}
