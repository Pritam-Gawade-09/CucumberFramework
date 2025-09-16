package com.vtiger.pages;

import com.vtiger.utils.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;


public class PotentialPage extends CommonActions {
    String parentWindow;
    public PotentialPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "potentialname")
    WebElement tb_Pname;

    @FindBy(xpath = "//input[@value='Change']")
    WebElement btn_Change;

    @FindBy(xpath = "/html/body/table[5]/tbody/tr[9]")
    WebElement lnk_SBI;

    @FindBy(name = "closingdate")
    WebElement tb_date;

    @FindBy(name = "sales_stage")
    WebElement drop_sales_stage;



    public void SetPotentialName(String pname){
        setInput(tb_Pname,pname);

    }
    public void clickAcName(){
        clickElement(btn_Change);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public void switchAcWindowPopup(){

        parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String win : allWindows) {
            if (!win.equals(parentWindow)) {
                driver.switchTo().window(win);   // नवीन window मध्ये shift झालो
            }
        }


    }


    public void selectAcname() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lnk_SBI));

            Thread.sleep(2000); // 👀 2 सेकंद थांब (popup मध्ये link दिसेल)

            lnk_SBI.click();

            Thread.sleep(2000); // 👀 2 सेकंद थांब (click झाल्याचं दिसेल)

            driver.switchTo().window(parentWindow);

            Thread.sleep(2000); // 👀 2 सेकंद थांब (parent window दिसेल)

            wait.until(ExpectedConditions.visibilityOf(tb_date));

           // System.out.println("✅ SBI clicked and switched back to parent window.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    public void SetDate(String Date){
         setInput(tb_date,Date);
    }
    public void SelectStage(String Option){
        SelectOption(drop_sales_stage,Option);
    }

}
