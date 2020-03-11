package com.elsevier.qa.stepDefs;

import com.elsevier.qa.pages.ShoppingCartPage;
import com.elsevier.qa.util.VerifyUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingCartPageSteps {

    ShoppingCartPage shoppingCartPage;
    private String pageTitle = "SHOPPING-CART SUMMARY";

    public ShoppingCartPageSteps() {
        shoppingCartPage = new ShoppingCartPage();
    }

    @Then("^I see shopping-cart summary page$")
    public void i_see_shopping_cart_summary_page() throws Throwable {
        String pageName = shoppingCartPage.getPageTitle();
        VerifyUtil.contains(pageTitle, pageName);
    }

    @When("^I select proceed to checkout$")
    public void i_select_proceed_to_checkout() throws Throwable {
        shoppingCartPage.selectProceedToCheckOut();
    }
}
