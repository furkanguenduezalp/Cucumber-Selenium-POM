package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected static WebDriverWait wait;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement pageSubtitle;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[3]")
    public WebElement activitiesBtn;

    @FindBy(xpath = "//span[.='Calendar Events']")
    public WebElement calenderEventsBtn;

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public WebElement createCalenderEventBtn;

    @FindBy(css = "#recurrence-repeat-view141")
    public WebElement repeatCheckBox;

    @FindBy(xpath = "//h3[.='Loading...']")
    protected static WebElement loadingText;

    @FindBy(css = "div[class='loader-mask-shown']")
    @CacheLookup
    protected static WebElement loaderMask;

    @FindBy(css = "#user-menu>a")
    protected WebElement userName;

    public String getUserName(){
        return userName.getText();
    }

    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
        //Driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
//    public static void waitUntilLoaderMaskAppear(){
//        try {
//            wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.visibilityOf(loaderMask));
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public static void waitUntilLoaderMaskDisappear(){
//        try {
//            wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }


    public static void waitUntilLoaderScreenDisappear(){
            try {
                wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
                wait.until(ExpectedConditions.invisibilityOf(loadingText));
            } catch (Exception e){
                e.printStackTrace();
            }
    }

}
