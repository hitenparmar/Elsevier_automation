package com.elsevier.qa.stepDefs;

import com.elsevier.qa.AppConfig;
import com.elsevier.qa.pages.HomePage;
import com.elsevier.qa.pages.SummerDressPage;
import com.elsevier.qa.util.VerifyUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageSteps {

    private HomePage homePage;
    private SummerDressPage summerDressPage;
    private String homePageUrl;
    private String homePageTitle = "My Store";
    private String summerPageTitle = "Summer Dresses";

    public HomePageSteps() {
        homePage = new HomePage();
    }

    @Given("^I am on HomePage$")
    public void i_am_on_HomePage() throws Throwable {
        homePageUrl = AppConfig.default_URL;
        homePage.gotToHomePage(homePageUrl);
        VerifyUtil.equals(homePageTitle, homePage.getHomePageTitle());
    }

    @When("^I go to summer dress section$")
    public void i_go_to_summer_dress_section() throws Throwable {
        homePage.goToSummerDress();
        summerDressPage = new SummerDressPage();
        VerifyUtil.equals(summerPageTitle, summerDressPage.getSummerDressPageTitle());
    }
}
