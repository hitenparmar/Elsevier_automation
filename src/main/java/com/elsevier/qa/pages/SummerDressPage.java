package com.elsevier.qa.pages;

import com.elsevier.qa.util.ElsevierDriver;
import com.elsevier.qa.util.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class SummerDressPage extends BasePage {


    @FindBy(xpath = "//*[@class='category-name']")
    WebElement summerDressPageTitle;

    @FindBy(xpath = "//*[@class='product_list grid row']/li")
    WebElement firstDress;

    @FindBy(xpath = "//*[@data-id-product='5']")
    WebElement addToCartFirstDress;

    @FindBy(xpath = "//*[@id='cart_title']")
    WebElement summaryPageElement;

    public SummerDressPage() {
        PageFactory.initElements(driver, this);
    }

    public String getSummerDressPageTitle() {
        String pageTitle = ElsevierDriver.findElement(By.xpath("//*[@class='category-name']")).getText();
        return pageTitle;
    }

    public void selectDressAndAddToCart() {
        ElsevierDriver.mouseHoverOver(firstDress);
        ElsevierDriver.click(addToCartFirstDress);
        WaitUtil.waitFor(2);
    }

    public String getPopUpMessage() {
        String message = null;
        try
        {
            String parentWindow = driver.getWindowHandle();
            String subWindow= null;
            Set<String> handles = driver.getWindowHandles();
            Iterator<String> iterator = handles.iterator();
            while(iterator.hasNext()){
                subWindow =iterator.next();
            }
            driver.switchTo().window(subWindow);
            message = driver.findElement(By.xpath("//*[@id='layer_cart']/div/div[1]/h2")).getText();
            driver.switchTo().window(parentWindow);
        }
        catch ( NoAlertPresentException n) {
            System.out.println("Popup is Not Present");
            n.printStackTrace();
        }
        return message;
    }

    public void selectProceedToCheckOut() {
        try
        {
            String parentWindow = driver.getWindowHandle();
            String subWindow= null;
            Set<String> handles = driver.getWindowHandles();
            Iterator<String> iterator = handles.iterator();
            while(iterator.hasNext()){
                subWindow =iterator.next();
            }
            driver.switchTo().window(subWindow);
            driver.findElement(By.xpath("//*[@title='Proceed to checkout']")).click();
            ElsevierDriver.waitForElement(summaryPageElement);

        }
        catch ( NoAlertPresentException n) {
            System.out.println("Popup is Not Present");
        }
    }
}
