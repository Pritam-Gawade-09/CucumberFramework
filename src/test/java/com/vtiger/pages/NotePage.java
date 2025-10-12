package com.vtiger.pages;

import com.vtiger.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotePage extends CommonActions {
    public NotePage( WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@value='Change'][1]")
    WebElement btn_ContactNameChange;

    @FindBy(xpath = "//input[@name='title']")
    WebElement tb_Subject;

    @FindBy(xpath = "//input[@name='filename' and @type='file']")
    WebElement btn_file;

    @FindBy(name = "notecontent")
    WebElement ta_Notecontenct;

    @FindBy(name = "parent_type")
    WebElement dd_ParentType;

    @FindBy(name = "(//input[@value='Change'])[2]")
    WebElement btn_ParetTypeChange;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement btn_SaveNote;

    @FindBy(xpath = "//table[@class='FormBorder']//tr/td/a[normalize-space(text())='Maria Miller']")
    WebElement lnk_contactname;

    @FindBy(xpath = "//table[@class='FormBorder']//tr/td/a[text()=' Vtiger 50 Users Pack']")
    WebElement lnk_productitem;

    public void SetContactName(){
       SwitchWindow(btn_ContactNameChange,lnk_contactname);
    }

    public void SetSubject(String subject){
     setInput(tb_Subject,subject);
    }

    public void ChooseFile(String path){
      SelectFile(btn_file,path);
    }
    public void SetNoteContect(String NoteContect){
      setInput(ta_Notecontenct,NoteContect);
    }
    public void SelectParetType(String parentType){
     SelectOption(dd_ParentType,parentType);
    }
    public void SetParentTypeChange(){

        SwitchWindow(btn_ParetTypeChange,lnk_productitem);

    }
    public void clickSaveNote(){
      clickElement(btn_SaveNote);
    }


}
