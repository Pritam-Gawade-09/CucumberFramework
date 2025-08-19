package com.vtiger.runner;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/Features/Login.feature",
        glue = "com.vtiger.Stepdefinitions",
        dryRun = false,
        tags = "@smoke",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html-report.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }


)

public class TestRunner1 extends AbstractTestNGCucumberTests {

     /*   @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
*/
}
