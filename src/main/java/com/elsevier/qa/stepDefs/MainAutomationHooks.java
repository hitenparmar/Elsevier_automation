package com.elsevier.qa.stepDefs;


import com.elsevier.qa.AppConfig;
import com.elsevier.qa.util.ElsevierDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class MainAutomationHooks {
    WebDriver driver;

    public MainAutomationHooks() {
        AppConfig appConfig = new AppConfig();
        AppConfig.loadAppConfig();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Running Scenario : "+ scenario.getName());
        System.out.println("Running Tag : "+ scenario.getSourceTagNames());
//        driver = ElsevierDriver.getDriver();

    }

    @After
    public void afterScenario(Scenario scenario) {
        ElsevierDriver.quit();
    }
}
