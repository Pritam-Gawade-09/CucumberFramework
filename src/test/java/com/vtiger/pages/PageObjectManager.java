package com.vtiger.pages;


import org.openqa.selenium.WebDriver;


public class PageObjectManager {

    public static WebDriver driver;

    // Declare all page objects
    private LoginPage lp;
    private HomePage hp;
    private LeadPage ldp;
    private AccountPage ac;
    private PotentialPage potpage;



    // Lazy initialization for LoginPage
    public LoginPage getLoginPage() {
        return (lp == null) ? lp = new LoginPage(driver) : lp;
    }

    // Lazy initialization for HomePage
    public HomePage getHomePage() {
        return (hp == null) ? hp = new HomePage(driver) : hp;
    }

    public LeadPage getLeadPage() {

        return (ldp == null) ? ldp = new LeadPage(driver) : ldp;
    }

    public PotentialPage getPotentialPage(){
        return (potpage==null) ? potpage =new PotentialPage(driver) : potpage;
    }


    public AccountPage getAccountPage(){
        return (ac==null) ? ac=new AccountPage(driver):ac;
    }
}
