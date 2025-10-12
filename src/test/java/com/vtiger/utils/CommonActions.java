package com.vtiger.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class CommonActions {
    public WebDriver driver;
    public WebDriverWait wait;
    public String parentWindow;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setInput(WebElement elm, String val) {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickElement(WebElement elm) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ElementExist(WebElement elm) {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
        } catch (Exception e) {
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

    }

    public void SwitchWindow(WebElement parentWindowElelemt, WebElement ChildWindowElement) {
        try {
            parentWindow = driver.getWindowHandle();
            parentWindowElelemt.click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> allWindows = driver.getWindowHandles();

            for (String window : allWindows) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    ChildWindowElement.click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.switchTo().window(parentWindow);

    }


    public void DragAndDrop(WebElement source, WebElement target) {
        Actions act = new Actions(driver);
        try {

            act.dragAndDrop(source, target).perform();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void SetYearMonthDate(WebElement calendar, String date) {

        String[] parts = date.split("-");

        if (parts.length != 3) {
            System.out.println("Invalid date format! Expected yyyy-MM-dd");
            return;  // function thambel ithe
        }

        try {
            int Year = Integer.parseInt(parts[0]);
            int Month = Integer.parseInt(parts[1]);
            int Day = Integer.parseInt(parts[2]);

            if (Year < 1000 || Year > 9999) {
                System.out.println("Invalid Year! Must be 4 digits and > 0.");
            } else if (Month < 1 || Month > 12) {
                System.out.println("Invalid Month! Must be between 1 and 12.");
            } else if (Day < 1 || Day > 31) {
                System.out.println("Invalid Day! Must be between 1 and 31.");
            } else {
                calendar.sendKeys(date);
                System.out.println("Entered date: " + date);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric values in date! Expected yyyy-MM-dd");
        }
    }


    public void WindowsChange(WebElement button, String value) {
        String parentWindow = driver.getWindowHandle();
        button.click();

        // Wait for new window to appear
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        shortWait.until(driver -> driver.getWindowHandles().size() > 1);

        // Switch to child window
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);

                try {
                    // Wait for the search input and enter value
                    WebElement searchInput = wait.until(
                            ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))
                    );
                    searchInput.clear();
                    searchInput.sendKeys(value);

                    // Click search
                    WebElement searchBtn = wait.until(
                            ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Search']"))
                    );
                    searchBtn.click();

                    // Wait for the table row containing the value
                    By resultLink = By.xpath("//table[contains(@class,'FormBorder')]//tr/td/a[contains(text(),'" + value + "')]");
                    WebElement link = wait.until(ExpectedConditions.elementToBeClickable(resultLink));
                    link.click();
                    System.out.println("Clicked on name: " + value);

                } catch (TimeoutException e) {
                    System.out.println("Name not found: " + value);
                } finally {
                    // Switch back to parent window
                    driver.switchTo().window(parentWindow);
                }

                break; // Exit loop after handling child window
            }
        }
    }


    public void SelectFile(WebElement ChooseBtn,String path){
        ChooseBtn.sendKeys(path);
    }



}



