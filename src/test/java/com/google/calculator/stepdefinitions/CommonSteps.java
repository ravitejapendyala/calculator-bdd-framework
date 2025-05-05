package com.google.calculator.stepdefinitions;

import com.google.calculator.driver.DriverManager;
import com.google.calculator.pages.CalculatorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

    private final WebDriver driver;
    private final CalculatorPage calculatorPage;

    public CommonSteps() {
        driver = DriverManager.getDriver();
        calculatorPage = new CalculatorPage(driver);
    }

    @Given("I navigate to Google calculator")
    public void iNavigateToGoogleCalculator() {
        calculatorPage.visitCalculator();
    }

    @Then("the result should be {string}")
    public void theResultShouldBe(String expectedResult) {
        String actualResult = calculatorPage.getDisplayValue();

        // Handle decimal comparison if needed
        if (actualResult.contains(".") || expectedResult.contains(".")) {
            double actual = Double.parseDouble(actualResult.replace(",", ""));
            double expected = Double.parseDouble(expectedResult.replace(",", ""));
            Assert.assertEquals("Calculator display shows incorrect result", expected, actual, 0.0001);
        } else {
            Assert.assertEquals("Calculator display shows incorrect result", expectedResult, actualResult);
        }
    }

    @Then("the result should contain {string} or {string}")
    public void theResultShouldContainOr(String text1, String text2) {
        String actualResult = calculatorPage.getDisplayValue();
        Assert.assertTrue(
                "Calculator display should contain either '" + text1 + "' or '" + text2 + "'",
                actualResult.contains(text1) || actualResult.contains(text2)
        );
    }
}

