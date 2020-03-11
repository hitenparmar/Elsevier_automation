package com.elsevier.qa.stepDefs;

import com.elsevier.qa.pages.AuthenticationPage;
import com.elsevier.qa.util.VerifyUtil;
import cucumber.api.java.en.Then;

public class AuthenticationPageSteps {

    AuthenticationPage authenticationPage;
    private String pageName = "AUTHENTICATION";

    public AuthenticationPageSteps() {
        authenticationPage = new AuthenticationPage();
    }

    @Then("^I see Authentication page$")
    public void i_see_Authentication_page() throws Throwable {
       VerifyUtil.equals(pageName, authenticationPage.getPageTitle());
    }

}
