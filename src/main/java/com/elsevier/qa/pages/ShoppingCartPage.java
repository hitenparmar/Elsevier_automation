package com.elsevier.qa.pages;

import com.elsevier.qa.util.ElsevierDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage{


    @FindBy(xpath = "//*[@id='cart_title']")
    WebElement shoppingCartPageTitle;

    @FindBy(xpath = "//*[@class='cart_navigation clearfix']/a")
    WebElement proceedToCheckOut;

    @FindBy(xpath = "//*[@class='page-heading']")
    WebElement authenticatPage;

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        String pageTitle = ElsevierDriver.findElement(By.xpath("//*[@id='cart_title']")).getText();
        return pageTitle;
    }

    public void selectProceedToCheckOut() {
        ElsevierDriver.click(proceedToCheckOut);
        ElsevierDriver.waitForElement(authenticatPage);
    }
}
