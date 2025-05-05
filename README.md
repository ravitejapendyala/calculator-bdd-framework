This is a simple BDD automation framework built for testing the calculator that shows up in Google search results.

### Prerequisites
- Java 11 or higher
- Maven

### Configuration
Edit src/main/resources/configuration.properties to set:
- Browser type (chrome, firefox, edge)
- Headless mode (true/false)
- Timeouts

- ### Running Tests

# Run all tests
mvn clean test

# Run with specific browser
mvn clean test -Dbrowser=firefox

# Run in headless mode
mvn clean test -Dheadless=true

# Run specific feature file
mvn clean test -Dcucumber.features="src/test/resources/features/arithmetic_operations.feature"

# Run with specific tags
mvn clean test -Dcucumber.filter.tags="@smoke"

### Generating Reports

# Generate Allure report after tests
mvn allure:report

# Serve Allure report
mvn allure:serve
