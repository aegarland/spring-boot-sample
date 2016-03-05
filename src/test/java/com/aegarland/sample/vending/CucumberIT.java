package com.aegarland.sample.vending;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by aeg on 3/4/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(  monochrome = true,
        features = "src/test/resources/features/",
        format = { "pretty","html:cucumber-html-reports",
                "json:cucumber-html-reports/cucumber.json" },
        dryRun = false,
        glue = {"features.step_definitions", "cucumber.api.spring" } )
public class CucumberIT {
}

