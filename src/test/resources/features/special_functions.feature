# src/test/resources/features/special_functions.feature
Feature: Google Calculator Special Functions
  As a user
  I want to use the Google calculator special functions
  So that I can perform more complex calculations

  Background:
    Given I navigate to Google calculator

  Scenario: Clearing the calculator with AC button
    When I enter "123"
    And I click the CE button
    Then the result should be "12"

  @smoke
  Scenario: Clearing the calculator with CE button after operation
    When I enter "5"
#    And I click the plus button
    And I click the CE button
    Then the result should be "0"

  Scenario: Handling negative numbers
    When I enter "10"
    And I click the minus button
    And I enter "15"
    And I click the equals button
    Then the result should be "-5"

  Scenario: Preventing multiple decimal points
    When I enter "5"
    And I click the decimal point button
    And I click the decimal point button again
    And I enter "25"
    Then the result should be "5.25"

  Scenario: Handling consecutive operation buttons
    When I enter "5"
    And I click the plus button
    And I click the multiply button
    And I enter "3"
    And I click the equals button
    Then the result should be "15"

  Scenario: Chained operations with precedence
    When I perform a chained operation "5 + 3 * 2 - 4"
    Then the result should be "7"