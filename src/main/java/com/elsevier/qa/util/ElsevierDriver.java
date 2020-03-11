package com.elsevier.qa.util;

import com.elsevier.qa.AppConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ElsevierDriver {

    public static WebDriver driver;

    public ElsevierDriver() {
    }

    public static boolean driverNotSet() {
        if( driver == null ) {
            return true;
        }
        return false;

    }

    public static WebDriver getDriver() {
        try {
            if (driverNotSet()) {
                driver = BrowserFactory.getBrowser(AppConfig.browser);
            }
        }catch (WebDriverException e) {
            System.out.println("Browser is not Initialized");
            e.printStackTrace();
        }

        return driver;
    }

    public static void openURL(String url) {
        driver.get(url);
    }

    public static void quit() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    public static void mouseHoverOver(WebElement webElement) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(webElement).build().perform();
    }

    public static WebElement findElement(By by) {
        return findElement(by, 30);
    }

    public static WebElement findElement(By by, long waitInSeconds) {
        FluentWait<WebDriver> webDriverFluentWait = new WebDriverWait(driver, waitInSeconds).pollingEvery(1, TimeUnit.SECONDS).withMessage("Could not find Element");
        return webDriverFluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public static void click(WebElement element) {

        try {
//            fluentWait(element);
            waitForElement(element);
            if (element.isDisplayed()) {
                element.click();
            }
        } catch(NoSuchElementException e) {
            System.out.println("Element Not Found ");
            e.printStackTrace();
        }
    }

    public static void fluentWait(WebElement element) {
        FluentWait wait = new FluentWait<WebDriver>(driver).withTimeout(60,TimeUnit.SECONDS).ignoring(WebDriverException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElement(WebElement element) {
        FluentWait wait = new FluentWait<WebDriver>(driver).withTimeout(60,TimeUnit.SECONDS).ignoring(WebDriverException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
