# Demo:

### Scenario: Incorrect Birthday

* The test navigates to the specified baseURL.
* It identifies elements like birthday input, prefix input, and phone input.
* It enters an incorrect birthday, prefix, and phone number.
* It interacts with dropdowns to select a province.
* It waits for an error message to be displayed and asserts that the expected error message is shown.
* Pauses for demonstration purposes.

### Scenario: Incorrect Province

* The test navigates to the specified baseURL.
* It interacts with the dropdown to select a province, entering an invalid value ("aaaa").
* It waits for the error message and asserts that the expected error message ("No results found") is shown.
* Pauses for demonstration purposes.

### Scenario: Incorrect Phone

* The test navigates to the specified baseURL.
* It enters an incorrect birthday, prefix, and phone number.
* It interacts with dropdowns to select a province.
* It waits for an error message to be displayed and asserts that the expected error message is shown.
* Pauses for demonstration purposes.

# Technical Solution:

* Test Framework: The code is written using TestNG, a testing framework for Java.
* WebDriver: The test uses Selenium WebDriver for browser automation.
* Assertions: TestNG's Assert class is utilized for making assertions.
* Explicit Waits: WebDriverWait is used for waiting until specific conditions are met.
* Error Messages: The tests assert the presence of specific error messages when incorrect input is provided.

## Implementation:

### Dependencies:

* TestNG for testing annotations and assertions.
* Selenium WebDriver for browser automation.
* Appropriate WebDriver binaries (e.g., ChromeDriver).

### WebDriver Initialization:

* An instance of the WebDriver is initialized, and the browser navigates to the specified baseURL.

### Test Methods:

* Each test method represents a specific scenario (Incorrect Birthday, Incorrect Province, Incorrect Phone).
* Elements on the webpage are identified using various locators (e.g.,By.id, By.xpath).
* Actions like sending keys, interacting with dropdowns, and clicking are performed.
* WebDriverWait is used for waiting until specific elements are visible.

### Assertions:
* TestNG's Assert class is used to validate expected outcomes.
* Assertions check if the correct error messages are displayed for each scenario.

### Pauses:
* pause() method is called to introduce pauses for better demonstration and visualization during test execution.