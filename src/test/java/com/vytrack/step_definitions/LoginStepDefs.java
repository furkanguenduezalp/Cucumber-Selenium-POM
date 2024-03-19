package com.vytrack.step_definitions;


import com.vytrack.pages.BasePage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }
    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information(){
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        BasePage.waitUntilLoaderScreenDisappear();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login(){
        DashboardPage.waitUntilLoaderScreenDisappear();
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard", actualTitle);
    }
    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() {
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        BasePage.waitUntilLoaderScreenDisappear();
    }
    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        BasePage.waitUntilLoaderScreenDisappear();
    }

    @When("the user logs in using {string} and {string}")
    public static void theUserLogsInUsingAnd(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        BasePage.waitUntilLoaderScreenDisappear();
    }

    @And("the title contains {string}")
    public void theTitleContains(String expectedTitle) {
        //{string} bring us "Dashboard" als Argument
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }

    @Given("the user logged in as {string}")
    public void theUserLoggedInAs(String userType) {
        the_user_is_on_the_login_page();
        if(userType.equals("driver")){
            the_user_enters_the_driver_information();
        }else if (userType.equals("salesmanager")) {
            the_user_enters_the_sales_manager_information();
        }else if (userType.equals("storemanager")){
            the_user_enters_the_store_manager_information();
        }
    }


}
