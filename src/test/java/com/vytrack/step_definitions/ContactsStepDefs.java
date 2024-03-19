package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {
    @Then("the user should see following options")
    public void theUserShouldSeeFollowingOptions(List<String> menuOptions) {

        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuoptions);
        Assert.assertEquals(menuOptions, actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);
    }

    @Then("the user logs in using following credentials")
    public void theUserLogsInUsingFollowingCredentials(Map<String, String> userInfo) {
        LoginStepDefs.theUserLogsInUsingAnd(userInfo.get("username"), userInfo.get("password"));

        String actualName = new DashboardPage().getUserName();
        String expectedName = userInfo.get("firstname") +" "+ userInfo.get("lastname");

        Assert.assertEquals(expectedName,actualName);

        System.out.println("actualName = " + actualName);
        System.out.println("expectedName = " + expectedName);
    }
}
