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
    private FAQPage faq;
    private ProductPage pp;
    private TicketPage tp;
    private CustomizeTabsPage custom;
    private TaskPage task;
    private NotePage note;



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

    public FAQPage getFAQPage(){
        return (faq==null) ? faq=new FAQPage(driver):faq;
    }
    public ProductPage getProductPage(){
        return (pp==null) ? pp=new ProductPage(driver):pp;
    }

    public  TicketPage getTicketPage(){
        return (tp==null)? tp=new TicketPage(driver):tp;
    }

    public CustomizeTabsPage getCustomizeTabsPage(){
        return (custom==null) ? custom=new CustomizeTabsPage(driver):custom;}

    public TaskPage getTaskPage(){
        return (task==null) ? task=new TaskPage(driver):task;
    }

    public NotePage getNotePage(){
        return (note==null) ? note=new NotePage(driver):note;

    }
    }

