package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //After every execution, cucumber will generate a cucumber.json report in target folder
        //And html report
        //And saved the tests, that failed ind rerun.txt
        plugin = {"json:target/cucumber.json",
                    "html:target/default-html-reports.html",
                "rerun:target/rerun.txt"
        },
        //then copy paste <build></build> in pom.xml
        //then: right side> maven> Lifecycle> verify
        //report.html files will be generated under target/cucumber-html-reports file

        //the path of features file (written in gherkin language), wenn that file is not in runners
        features = "src/test/resources/features",

        //the path of class (Step Definitions), which includes methods for given, when, then
        glue = "com/vytrack/step_definitions",

        //dryRun= true: to get only undefined step definitions without executing the codes
        //dryRun = false means java code will be executed
        dryRun = false,

        //it will only the "@tag" scenario(s) be executed:
        //tags = "@store_manager"
        //all scenarios under feature be executed, if there is @tag above features:
        //tags = "@login"
        //run the scenarios, that has both @tags:
        //tags = "@driver and @VYT-123"
        //old syntax: tags = {"@driver","@VYT-123"} (not working on version >5)
        //run the scenarios, that has one of the @tags:
        //tags = "@driver or @VYT-123"
        //old syntax: tags: "@driver, @VYT-123"  (not working on version >5)
        //exclude a few spesific scenario
        //tags = "@login and not @wip and not @sales_manager"
        //old syntax: tags = {“@login“,"~@wip"}
        tags = "@wip"
)
public class CukesRunner {
}
