# SeleniumUITest
## Selenium UI Interview Project

This repository contains Selenium UI tests designed as an interview project to evaluate the functionality of a dummy purchase web page. The project is divided into two main files:

1. UIFailTests: This file focuses on testing the web page's reaction to incorrect inputs. It specifically targets the first page of the purchase process, considering the ease of making mistakes in the input of the birthday or phone number.

2. E2ETest: This file aims to simulate an end-to-end journey through the dummy purchase page until it reaches the payment method section. The test attempts to input a credit card number that is expected to fail, and the assertion is set to verify the appearance of a pop-up error message.

## Design Patterns
### Page Object Pattern
The Page Object Pattern has been employed in the project to enhance reusability and maintainability. Each web page is represented by a dedicated class encapsulating the UI elements and interactions associated with that page. This pattern aids in creating a clear and modular structure for test scripts, promoting code readability and ease of maintenance.

### Factory Method Pattern
The Factory Method Pattern has been chosen to instantiate WebDriver objects. This pattern provides flexibility by allowing subclasses or specific implementations to supply the actual instance of the WebDriver. This approach accommodates variations in browser types or configurations, contributing to a more adaptable and extensible test suite.

## Test Files
1. UIFailTests
This file is dedicated to testing the reaction of the web page to incorrect inputs on the initial purchase page. It specifically targets scenarios where users might input incorrect data for their birthday or phone number.

2. E2ETest
The E2ETest file orchestrates an end-to-end simulation of the purchase process. It navigates through the pages until reaching the payment method section, where it deliberately attempts to input a credit card number that is expected to fail. The assertion is set to validate the appearance of a pop-up error message.

## Running the Tests
1. Clone the repository to your local machine.
2. Ensure you have the necessary dependencies and configurations, including Selenium WebDriver and browser drivers.
3. Open the project in your preferred Java IDE.
4. Run the desired test files individually or collectively to evaluate the behavior of the dummy purchase web page.

## Note
Before running the tests, make sure the dummy purchase web page is accessible at the specified base URL. Additionally, customize the input data or scenarios in the test files as needed for your testing requirements.

Feel free to extend or modify the test suite to cover additional scenarios or enhance existing functionalities. The chosen design patterns aim to provide a scalable and maintainable foundation for Selenium UI testing.
