package com.vtiger.pages;

import com.vtiger.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FAQPage extends CommonActions {
    public FAQPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@value='Change']")
    WebElement btn_change;

    @FindBy(xpath = "//table[@class='FormBorder']//a[text()='Vtiger 10 Users Pack']")
    WebElement lnk_Productname;

    @FindBy(name = "faqstatus")
    WebElement drop_status;

    @FindBy(name = "faqcategories")
    WebElement drop_category;

    @FindBy(name = "question")
    WebElement ta_question;

    @FindBy(name = "faq_answer")
    WebElement ta_answer;

    @FindBy(xpath = "//input[@type='submit'][1]")
    WebElement btn_Save;




    public void SetProductName(){
      SwitchWindow(btn_change,lnk_Productname);

    }

    public void SelectStatus(String StatusOption){
         SelectOption(drop_status,StatusOption);
    }
    public void SelectCategory(String CategotyOption){
          SelectOption(drop_category,CategotyOption);
    }
    public void SetQuestion(String Question){
        setInput(ta_question,Question);
    }
    public void SetAnswer(String Answer){
       setInput(ta_answer,Answer);
    }
    public void clickSave(){
        clickElement(btn_Save);
    }
    public void SubmitFAQ(){

    }
}
