package com.elsevier.qa.pages;

import com.elsevier.qa.util.ElsevierDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage {


    @FindBy(xpath = "//*[@class='page-heading']")
    WebElement pageTitleElement;

    @FindBy(id = "email_create")
    WebElement emailAddressCreate;

    public AuthenticationPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        String pageTitle = null;
        pageTitle = ElsevierDriver.findElement(By.xpath("//*[@class='page-heading']")).getText();
        return pageTitle;

    }
}
