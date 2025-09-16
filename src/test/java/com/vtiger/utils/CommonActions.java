package com.vtiger.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActions {
    public WebDriver driver;
    public WebDriverWait wait;
    public CommonActions(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setInput(WebElement elm, String val)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(val);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void clickElement(WebElement elm)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
           elm.click();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void ElementExist(WebElement elm)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



        public void SelectOption(WebElement elm, String val) {
            try {
                wait.until(ExpectedConditions.visibilityOf(elm));  // ✅ WebElement directly वापर
                Select sc = new Select(elm);
                sc.selectByVisibleText(val);
            } catch (Exception e) {
                e.printStackTrace();
            }



    }}
