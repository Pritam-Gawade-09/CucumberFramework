package com.vtiger.Stepdefinitions;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import com.vtiger.pages.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class basesteps extends PageObjectManager {

    public static Properties prop;
    public static Map<String, Map<String,String>> dt;
    public static String TCName;






    public void LaunchApp()  {
        readproperties();
        readExcel();
        //System.exit(1);
        if(prop.getProperty("browser").equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("headless"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
        }
        else {
            driver = new ChromeDriver();
        }
        driver.get(prop.getProperty("url"));

    }

    public void readproperties()  {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/configData.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readExcel()  {
        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(System.getProperty("user.dir") + "/src/test/resources/TestData/data.xlsx");
            String strQuery = "Select * from Sheet1";
            Recordset recordset = connection.executeQuery(strQuery);
            ArrayList<String> ls = recordset.getFieldNames();
            dt = new HashMap<>();
            while (recordset.next()) {
                Map<String,String> map = new HashMap<>();
               String TCName =  recordset.getField("TCName");
               for(int i=1;i<ls.size();i++)
               {
                   String colname = ls.get(i);
                   String colmvalue = recordset.getField(colname);
                   map.put(colname,colmvalue);
               }
                dt.put(TCName,map);
            }
            System.out.println(dt);
            recordset.close();
            connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
