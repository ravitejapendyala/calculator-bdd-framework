package com.google.calculator.hooks;

import com.google.calculator.driver.DriverManager;
import com.google.calculator.utils.TestUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        // Initialize WebDriver
        driver = DriverManager.getDriver();

        // Log scenario start
        System.out.println("Starting scenario: " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        // Take screenshot after each step if needed
        if (driver != null) {
            scenario.attach(
                    TestUtils.takeScreenshotAsBytes(driver),
                    "image/png",
                    "Screenshot after step"
            );
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        // Take screenshot if scenario fails
        if (scenario.isFailed() && driver != null) {
            scenario.attach(
                    TestUtils.takeScreenshotAsBytes(driver),
                    "image/png",
                    "Screenshot on failure"
            );

            // Attach page source on failure
            scenario.attach(
                    driver.getPageSource().getBytes(),
                    "text/html",
                    "Page source on failure"
            );
        }

        // Close WebDriver
        if (driver != null) {
            DriverManager.quitDriver();
        }

        // Log scenario end
        System.out.println("Finished scenario: " + scenario.getName() + " - " + scenario.getStatus());
    }
}
