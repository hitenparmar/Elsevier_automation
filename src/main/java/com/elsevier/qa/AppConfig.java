package com.elsevier.qa;


import com.google.common.base.Strings;

public class AppConfig {
    private static final String default_environment = "qaEnv";
    private static final String default_browser = "chrome";
    private static final String default_browser_version = "80";
    private static final String default_run_type = "local"; //"http://localhost:4444/wd/hub";
    private static String environment;
    public static String browser;
    public static String browser_version;
    public static String runType;
    public static String default_URL = "http://automationpractice.com/index.php";

    public AppConfig() {

        String testRunBrowser = System.getProperty("test.run.browser");
        String testRunType = System.getProperty("test.run.type");
        String testRunBrowserVersion = System.getProperty("test.run.browser.version");
        String testRunEnvironment = System.getProperty("test.run.env");

        browser = Strings.isNullOrEmpty(testRunBrowser) ? default_browser : testRunBrowser;
        browser_version = Strings.isNullOrEmpty(testRunBrowserVersion) ? default_browser_version : testRunBrowserVersion;
        runType = Strings.isNullOrEmpty(testRunType) ? default_run_type : testRunType;
        environment = Strings.isNullOrEmpty(testRunEnvironment) ? default_environment : testRunEnvironment;

        System.setProperty("test.run.browser", browser);
        System.setProperty("test.run.browser.version", browser_version);
        System.setProperty("test.run.type", runType);
        System.setProperty("test.run.env", environment);

    }

    public static void loadAppConfig() {
        System.out.println("Running Environment : " + environment);
    }


}
