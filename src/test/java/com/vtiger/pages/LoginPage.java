package com.vtiger.pages;

import com.vtiger.utils.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonActions {


    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

   // String username = "user_name";
   // By username = By.name("user_name");
    @FindBy(name="user_name")
    WebElement tb_username;

    @FindBy(name="user_password")
    WebElement tb_userpassword;

    @FindBy(name="Login")
    WebElement btn_login;

    @FindBy(xpath="//*[contains(text(),'You must specify a valid username and password')]")
    WebElement msg_Error;




    public void login(String uid, String pwd)
    {
        SetUserName(uid);
        SetUserPassword(pwd);
        clickLogin();
    }

    public void SetUserName(String uid)
    {
      setInput(tb_username,uid);
    }

    public void SetUserPassword(String pwd)
    {
       setInput(tb_userpassword,pwd);
    }

    public void PasswordDisplay()
    {
        ElementExist(tb_userpassword);

    }

    public void clickLogin()
    {
       clickElement(btn_login);
    }

    public void ErrorMsgDisplay()
    {

        ElementExist(msg_Error);

    }

}
