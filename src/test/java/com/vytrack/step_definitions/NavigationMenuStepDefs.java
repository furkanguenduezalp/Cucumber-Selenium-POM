package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

public class NavigationMenuStepDefs {
    @When("the user navigates to Fleet, Vehicles")
    public void theUserNavigatesToFleetVehicles() {
        System.out.println("the user navigates to Fleet, Vehicles");
    }

    @Then("the title should be Vehicles")
    public void theTitleShouldBeVehicles() {
        System.out.println("Expected and Actual title are matching");
    }

    @When("the user navigates to Marketing, Campaigns")
    public void theUserNavigatesToMarketingCampaigns() {
        System.out.println("the user navigates to Marketing, Campaigns");
    }

    @Then("the title should be Campaigns")
    public void theTitleShouldBeCampaigns() {
        System.out.println("Expected and Actual title are matching");
    }

    @When("the user navigates to Activities, Calendar Events")
    public void theUserNavigatesToActivitiesCalendarEvents() {
        System.out.println("the user navigates to Activities, Calendar Events");
    }

    @Then("the title should be Calendars")
    public void theTitleShouldBeCalendars() {
        System.out.println("Expected and Actual title are matching");
    }

    @When("the user navigates to {string} {string}")
    public void theUserNavigatesTo(String tab, String module) {
        DashboardPage.waitUntilLoaderScreenDisappear();
        DashboardPage.navigateToPage(tab, module);
        BasePage.waitUntilLoaderScreenDisappear();
    }

    @Then("default page number should be {int}")
    public void defaultPageNumberShouldBe(int expectedPageNum) throws InterruptedException {
        ContactsPage contactsPage = new ContactsPage();
        Thread.sleep(5000);
        int actualNumber = Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));
        Assert.assertEquals(expectedPageNum, actualNumber);
    }
}
