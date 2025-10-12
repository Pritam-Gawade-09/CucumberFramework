package com.vtiger.pages;

import com.vtiger.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Year;

public class ProductPage extends CommonActions {
    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "productname")
    WebElement tb_productname;

    @FindBy(name = "discontinued")
    WebElement checkbox_PStatus;

   @FindBy(name = "manufacturer")
   WebElement dd_manu;

   @FindBy(id = "jscal_trigger_sales_end_date")
   WebElement icon_calender;

   @FindBy(xpath = "(//input[@value='Change'])[2]")
   WebElement btn_changeContact;

   @FindBy(xpath = "//table[@class='FormBorder']//tr/td/a[normalize-space(text())='Maria Miller']")
   WebElement lnk_contactName;

   @FindBy(xpath = "//input[@name='imagename']")
   WebElement file_Path;

   @FindBy(xpath = "(//input[@value='Change' and @class='button'])[3]")
   WebElement btn_changeVendor;

   @FindBy(xpath = "//table[@class='FormBorder']//tr/td/a[normalize-space(text())='Margaret']")
   WebElement lnk_vendorName;

   @FindBy(name = "parent_type")
   WebElement dd_parenttype;

   @FindBy(xpath = "(//input[@value='Change'])[1]")
   WebElement btn_changeLead;

   @FindBy(xpath = "//table[@class='FormBorder']//tr/td/a[normalize-space(text())='Yash Singh']")
   WebElement lnk_LeadName;

    public void SetProductName(String proname){
      setInput(tb_productname,proname);
    }
    public void SetProductStatus(){

    }
    public void SelectManufacture(String manufacture){
       SelectOption(dd_manu,manufacture);
    }
//    public void SetSalesEndDate(String year,String Month,String Day ){
//        clickElement(icon_calender);
//         Calender(year,Month,Day);
//
//
//    }
    public void SetSupportExpiryDate(){

    }
    public void SetContactName(){
       SwitchWindow(btn_changeContact,lnk_contactName);

    }
    public void SetVendorName(){
        SwitchWindow(btn_changeVendor,lnk_vendorName);

    }
    public void SetSalesStartDate(String Year,String Month,String Date){
//      Calender(Year,Month,Date);
////      clickElement(Year(year));
////      clickElement(Month(month));
////      clickElement(Date(date));

    }
    public void SetSupportStartDate(){

    }
    public void SelectParentName(String parentType){
        SelectOption(dd_parenttype,parentType);

    }
    public void SetLead(){
        SwitchWindow(btn_changeLead,lnk_LeadName);

    }
    public void SetFile(String Path){

        setInput(file_Path,Path);
    }






}
