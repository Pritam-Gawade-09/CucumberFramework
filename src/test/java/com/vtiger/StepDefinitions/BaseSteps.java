package com.vtiger.StepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.PageObjectManager;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static io.cucumber.shaded.gherkin.messages.internal.gherkin.Parser.RuleType.Scenario;

public class BaseSteps extends PageObjectManager {

    public static Properties prop;
    public static Map<String, Map<String,String>> dt;
    public static Map<String, Map<String,String>> apidt;
    public static String TCName;

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest report;

public void initation(){
    if(extent==null)
    createExtentReport();
    if(prop==null)
    readproperties();
    if(dt==null)
    dt=readExcel("UI");
    if (apidt==null)
    apidt=readExcel("API");

}




    public void LaunchApp()  {

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

    public Map<String, Map<String,String>> readExcel(String sheet) {
        Map<String, Map<String,String>> data = new HashMap<>();
        Connection connection = null;
        Recordset recordset = null;

        try {
            Fillo fillo = new Fillo();
            connection = fillo.getConnection(System.getProperty("user.dir") + "/src/test/resources/TestData/data.xlsx");
            String strQuery = "Select * from " + sheet;
            recordset = connection.executeQuery(strQuery);

            ArrayList<String> ls = recordset.getFieldNames();

            while (recordset.next()) {
                Map<String,String> map = new HashMap<>();
                String TCName = recordset.getField("TCName");

                // पहिला कॉलम TCName आहे म्हणून i=1 पासून सुरू
                for (int i = 1; i < ls.size(); i++) {
                    String colname = ls.get(i);
                    String colmvalue = recordset.getField(colname);
                    map.put(colname, colmvalue);
                }
                data.put(TCName, map);
            }

            System.out.println(data);

        } catch (Exception e) {
            System.err.println("Error while reading Excel sheet: " + sheet);
            e.printStackTrace();
        } finally {
            try {
                if (recordset != null) recordset.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    public void createExtentReport()
    {
        //report_13042025104034.html
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/Reports/ExtentReport_"+fileName+".html");
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Automation Test Hub");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User Name", "Rajesh U");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here ");
        // Name of the report
        htmlReporter.config().setReportName("Name of the Report Comes here ");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);

    }

}
