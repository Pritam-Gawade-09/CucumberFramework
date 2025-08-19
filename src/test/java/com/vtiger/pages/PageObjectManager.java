package com.vtiger.pages;


import org.openqa.selenium.WebDriver;


public class PageObjectManager {

    public static WebDriver driver;

    // Declare all page objects
    private LoginPage lp;
    private HomePage hp;
    private LeadPage ldp;



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
}
