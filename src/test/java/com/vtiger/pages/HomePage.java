package com.vtiger.pages;

import com.vtiger.utils.CommonActions;
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

}
