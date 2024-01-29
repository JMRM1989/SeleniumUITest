
# UIFailTests - UI Test Cases
This repository contains UI test cases written in Java using Selenium for a web application. The tests focus on scenarios where user input is expected to fail, and appropriate error messages are verified.

## Test Case 1: incorrectBirthday
This test case validates the behavior when an incorrect birthday is provided during the registration process. The test performs the following steps:

1. Navigates to the application's base URL.
2. Enters an invalid birthday, phone code, and phone number.
3. Selects a province from the dropdown.
4. Waits for the error message to be displayed.
5. Asserts that the correct error message is shown.

## Test Case 2: incorrectProvince
This test case verifies the response when an incorrect province is entered. The test follows these steps:

1. Navigates to the application's base URL.
2. Attempts to select a province that does not exist.
3. Waits for the error message to be displayed.
4. Asserts that the correct error message is shown.

## Test Case 3: incorrectPhone
This test case checks the system's response to an incorrect phone number format. The test executes the following steps:

1. Navigates to the application's base URL.
2. Enters a valid birthday and province but an invalid phone code and phone number.
3. Waits for the error message to be displayed.
4. Asserts that the correct error message is shown.

## Prerequisites
* Java Development Kit (JDK) installed
* Selenium WebDriver configured
* Web browser driver (e.g., ChromeDriver) installed

## Running the Tests
1. Clone the repository.
2. Open the project in your preferred Java IDE.
3. Configure the Selenium WebDriver and browser driver.
4. Run the test cases individually or collectively.

## Note
Ensure that the application is accessible at the specified base URL before running the tests.