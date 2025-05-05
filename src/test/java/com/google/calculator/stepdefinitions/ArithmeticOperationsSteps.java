package com.google.calculator.stepdefinitions;

import com.google.calculator.driver.DriverManager;
import com.google.calculator.pages.CalculatorPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ArithmeticOperationsSteps {

    private final WebDriver driver;
    private final CalculatorPage calculatorPage;

    public ArithmeticOperationsSteps() {
        driver = DriverManager.getDriver();
        calculatorPage = new CalculatorPage(driver);
    }

    @When("I enter {string}")
    public void iEnter(String number) {
        calculatorPage.enterNumber(number);
    }

    @When("I click the plus button")
    public void iClickThePlusButton() {
        calculatorPage.clickPlus();
    }

    @When("I click the minus button")
    public void iClickTheMinusButton() {
        calculatorPage.clickMinus();
    }

    @When("I click the multiply button")
    public void iClickTheMultiplyButton() {
        calculatorPage.clickMultiply();
    }

    @When("I click the divide button")
    public void iClickTheDivideButton() {
        calculatorPage.clickDivide();
    }

    @When("I click the equals button")
    public void iClickTheEqualsButton() {
        calculatorPage.clickEquals();
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonType) {
        switch (buttonType.toLowerCase()) {
            case "plus":
                calculatorPage.clickPlus();
                break;
            case "minus":
                calculatorPage.clickMinus();
                break;
            case "multiply":
                calculatorPage.clickMultiply();
                break;
            case "divide":
                calculatorPage.clickDivide();
                break;
            case "equals":
                calculatorPage.clickEquals();
                break;
            default:
                throw new IllegalArgumentException("Unknown button type: " + buttonType);
        }
    }

    @When("I perform a chained operation {string}")
    public void iPerformAChainedOperation(String operation) {
        // Parse and perform the operation
        String[] parts = operation.split(" ");

        // Enter first number
        calculatorPage.enterNumber(parts[0]);

        // Process operations in sequence
        for (int i = 1; i < parts.length; i += 2) {
            String operator = parts[i];
            switch (operator) {
                case "+":
                    calculatorPage.clickPlus();
                    break;
                case "-":
                    calculatorPage.clickMinus();
                    break;
                case "*":
                    calculatorPage.clickMultiply();
                    break;
                case "/":
                    calculatorPage.clickDivide();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operator: " + operator);
            }

            // Enter next number if available
            if (i + 1 < parts.length) {
                calculatorPage.enterNumber(parts[i + 1]);
            }
        }

        // Calculate final result
        calculatorPage.clickEquals();
    }
}
