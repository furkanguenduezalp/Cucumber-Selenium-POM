package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "(//span[@class='title title-level-1'])[3]")
    public static WebElement Customer;

    @FindBy(xpath = "(//span[.='Contacts'])[1]")
    public static WebElement Contacts;

    @FindBy(css = "span.title.title-level-1")
    public List<WebElement> menuoptions;

    public static void navigateToPage(String Tab, String Button){

        WebElement t = Driver.get().findElement(By.xpath("//span[contains(text(), '"+Tab+"')]"));
        WebElement b = Driver.get().findElement(By.xpath("//span[contains(text(), '"+Button+"')]"));
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(t).perform();
        b.click();

    }

}
