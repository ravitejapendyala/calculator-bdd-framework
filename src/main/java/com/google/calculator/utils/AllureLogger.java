package com.google.calculator.utils;

import io.qameta.allure.Allure;

/**
 * Utility class for logging steps in Allure reports for Cucumber tests
 */
public class AllureLogger {

    /**
     * Log info message
     */
    public static void info(String message) {
        Allure.step("INFO: " + message);
    }

    /**
     * Log action
     */
    public static void action(String message) {
        Allure.step("ACTION: " + message);
    }

    /**
     * Log verification step
     */
    public static void verify(String message) {
        Allure.step("VERIFY: " + message);
    }

    /**
     * Log test data
     */
    public static void data(String message) {
        Allure.step("DATA: " + message);
    }
}
