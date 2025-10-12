package com.vtiger.pages;

import com.vtiger.utils.CommonActions;
import groovy.xml.StreamingDOMBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonActions {


    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(linkText="Home")
    WebElement lnk_Home;

    @FindBy(linkText="Logout")
    WebElement lnk_Logout;

    @FindBy(linkText="New Lead")
    WebElement lnk_NewLead;

    @FindBy(linkText = "New Account")
    WebElement lnk_Account;

    @FindBy(linkText = "New Potential")
    WebElement lnk_Potential;

    @FindBy(linkText = "New FAQ")
    WebElement lnk_FAQ;

    @FindBy(linkText = "New Product")
    WebElement lnk_Product;

    @FindBy(linkText = "New Ticket")
    WebElement lnk_Ticket;

    @FindBy(linkText = "My Account")
    WebElement lnk_MyAccount;

    @FindBy(linkText = "New Task")
    WebElement lnk_Task;

    @FindBy(linkText = "New Note")
    WebElement lnk_Note;

    public void HomeDisplay()
    {

        ElementExist(lnk_Home);
    }

    public void LogoutDisplay()
    {
       ElementExist(lnk_Logout);
    }

    public void clickNewLead()
    {
        clickElement(lnk_NewLead);
    }

    public void clickNewAccount(){
       clickElement(lnk_Account);
    }

    public void clickNewPotential(){
        clickElement(lnk_Potential);
    }

    public void clickNewFAQ(){
      clickElement(lnk_FAQ);
    }

    public void clickNewProduct(){
      clickElement(lnk_Product);
    }

    public void clickNewTicket(){
     clickElement(lnk_Ticket);
    }

    public void clickMyAccount(){
       clickElement(lnk_MyAccount);

    }
    public void clickNewTask(){
        clickElement(lnk_Task);
    }
    public void clickNewNote(){
        clickElement(lnk_Note);
    }

}
