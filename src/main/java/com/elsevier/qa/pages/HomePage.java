package com.elsevier.qa.pages;

import com.elsevier.qa.AppConfig;
import com.elsevier.qa.util.ElsevierDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='header_logo']/a")
    private WebElement headerLogo;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/a")
    private WebElement womenElement;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/a")
    private WebElement dressesElement;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[3]/a")
    private WebElement tshirtElement;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/ul/li[3]/a")
    private WebElement summerDressElement;

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    public void gotToHomePage(String homePageUrl) {
        System.out.println("Navigating to HomePage !");
        ElsevierDriver.openURL(homePageUrl);

    }

    public String getHomePageTitle() {
        String logoName = headerLogo.getAttribute("title");
        return logoName;
    }

    public void goToSummerDress() {
        ElsevierDriver.mouseHoverOver(dressesElement);
        ElsevierDriver.click(summerDressElement);
    }
}
