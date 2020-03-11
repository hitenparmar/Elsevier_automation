package com.elsevier.qa.pages;

import com.elsevier.qa.AppConfig;
import com.elsevier.qa.util.BrowserFactory;
import com.elsevier.qa.util.ElsevierDriver;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    public BasePage() {
        driver = ElsevierDriver.getDriver();
    }

}
