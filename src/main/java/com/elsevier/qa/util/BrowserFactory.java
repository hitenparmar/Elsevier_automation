package com.elsevier.qa.util;

import com.elsevier.qa.AppConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

public class BrowserFactory {

    private static String browserName;
    private static String testRunType;
    private static String LOCAL_SELENIUM_GRID_URL = "http://localhost:4444/wd/hub";

    public static WebDriver getBrowser(String browser) {
        WebDriver driver = null;
        browserName = browser;
        testRunType = AppConfig.runType;

        if(browserName.equalsIgnoreCase("chrome")) {
            driver = getChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = getFirefoxDriver();
        }

        return driver;

    }

    public static String getDriversPath() {
        String driverPath = null;
        if(System.getProperty("os.name").contains("linux") || System.getProperty("os.name").contains("Mac")) {
            driverPath = "/src/main/resources/drivers/";
        } else {
            driverPath = "\\src\\main\\resources\\drivers\\";
        }
        return driverPath;
    }

    public static WebDriver getChromeDriver() {
        WebDriver driver = null;
        String driverPath = getDriversPath();

        try {
            if(! testRunType.equalsIgnoreCase("local")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath+"chromedriver.exe");
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", System.getProperty("user.home"));

                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);

                DesiredCapabilities chrome = DesiredCapabilities.chrome();
                chrome.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
                chrome.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
                chrome.setCapability(ChromeOptions.CAPABILITY, options);

                driver = new ScreenShotRemoteWebDriver(new URL(LOCAL_SELENIUM_GRID_URL), chrome);
            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-gpu");
                options.addArguments("disable-features=NetworkService");
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+driverPath+"chromedriver");
                driver = new ChromeDriver(options);
            }
            driver.manage().window().maximize();
        }catch (Exception e) {
            System.out.println("Error With Initializing Chrome Driver");
            e.printStackTrace();
        }
        return driver;
    }

    public static class ScreenShotRemoteWebDriver extends RemoteWebDriver implements TakesScreenshot {
        public ScreenShotRemoteWebDriver(URL url, DesiredCapabilities dc) {
            super(url, dc);
        }


        public <X> X getScreenshotAs(OutputType<X> target)
                throws WebDriverException {
            if ((Boolean) getCapabilities().getCapability(CapabilityType.TAKES_SCREENSHOT)) {
                return target.convertFromBase64Png(execute(DriverCommand.SCREENSHOT).getValue().toString());
            }
            return null;
        }
    }

    private static WebDriver getFirefoxDriver() {
        WebDriver driver = null;
        String driverPath = getDriversPath();

        try {
            if (!testRunType.equalsIgnoreCase("local")) {
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+driverPath+"geckodriver.exe");
                FirefoxProfile profile = new FirefoxProfile();
                DesiredCapabilities firefox = DesiredCapabilities.firefox();
                firefox.setPlatform(Platform.ANY);
                firefox.setCapability("marionette", true);
                firefox.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
                firefox.setCapability(FirefoxDriver.PROFILE,profile);
                driver = new ScreenShotRemoteWebDriver(new URL(LOCAL_SELENIUM_GRID_URL), firefox);

            } else {
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+driverPath+"geckodriver.exe");
                FirefoxProfile profile = new FirefoxProfile();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("marionette", true);
                firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);
                driver = new FirefoxDriver(firefoxOptions);
            }
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Error with Initializing Firefox Driver");
            e.printStackTrace();
        }
        return driver;
    }

}
