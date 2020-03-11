package com.elsevier.qa.stepDefs;

import com.elsevier.qa.pages.SummerDressPage;
import com.elsevier.qa.util.VerifyUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SummerDressPageSteps {

    private SummerDressPage summerDressPage;
    private String popUpMessage = "Product successfully added to your shopping cart";

    public SummerDressPageSteps() {
        summerDressPage = new SummerDressPage();
    }

    @When("^I add dress to cart$")
    public void i_add_dress_to_cart() throws Throwable {
        summerDressPage.selectDressAndAddToCart();
    }

    @Then("^I see popup message with dress added to cart$")
    public void i_see_popup_message_with_dress_added_to_cart() throws Throwable {
       String message = summerDressPage.getPopUpMessage();
        VerifyUtil.equals(popUpMessage, message);
    }

    @When("^I select proceed to checkout from popup$")
    public void i_select_proceed_to_checkout_from_popup() throws Throwable {
        summerDressPage.selectProceedToCheckOut();
    }

}
