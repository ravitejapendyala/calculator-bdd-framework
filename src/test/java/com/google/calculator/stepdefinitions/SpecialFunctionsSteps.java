package com.google.calculator.stepdefinitions;

import com.google.calculator.driver.DriverManager;
import com.google.calculator.pages.CalculatorPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SpecialFunctionsSteps {

    private final WebDriver driver;
    private final CalculatorPage calculatorPage;

    public SpecialFunctionsSteps() {
        driver = DriverManager.getDriver();
        calculatorPage = new CalculatorPage(driver);
    }

    @When("I click the clear button")
    public void iClickTheClearButton() {
        // This will handle both AC and CE buttons based on the state
        try {
            calculatorPage.clearCalculator(); // Try AC first
        } catch (Exception e) {
            calculatorPage.clearCalculatorCE(); // If AC not found, try CE
        }
    }

    @When("I click the AC button")
    public void iClickTheACButton() {
        calculatorPage.clearCalculator();
    }

    @When("I click the CE button")
    public void iClickTheCEButton() {
        calculatorPage.clearCalculatorCE();
    }

    @When("I click the decimal point button")
    public void iClickTheDecimalPointButton() {
        calculatorPage.clickDecimalPoint();
    }

    @When("I click the decimal point button again")
    public void iClickTheDecimalPointButtonAgain() {
        calculatorPage.clickDecimalPoint();
    }
}