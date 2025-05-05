package com.google.calculator.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtils {

    public static double parseDisplayValue(String displayValue) {
        // Remove any commas and convert to double
        return Double.parseDouble(displayValue.replace(",", ""));
    }

    public static boolean isApproximatelyEqual(double actual, double expected, double tolerance) {
        return Math.abs(actual - expected) <= tolerance;
    }

    /**
     * Take screenshot as bytes
     * @param driver WebDriver instance
     * @return byte[] Screenshot as bytes
     */
    public static byte[] takeScreenshotAsBytes(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}