package com.elsevier.qa.util;

import com.google.common.base.Stopwatch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitUtil {

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds*1000);

        }
        catch (InterruptedException e)
        {

        }
    }

    public static void waitForPopUp(WebDriver driver, int timeoutInSeconds) {
        final int currentWindows = driver.getWindowHandles().size();
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (d.getWindowHandles().size() != currentWindows);
            }
        });
    }
}
