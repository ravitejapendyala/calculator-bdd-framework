package com.google.calculator.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.google.calculator.stepdefinitions", "com.google.calculator.hooks"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json"
        },
        tags = "@smoke",  // <-- specify your tag here
        monochrome = true
)
public class TestRunner {
    // This class serves as an entry point for running Cucumber tests
}