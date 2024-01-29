# E2ETest - End-to-End Test for Form Auto-Fill
This repository contains an End-to-End (E2E) test written in Java using Selenium. The test automates the process of filling out a multi-page form with data sourced from an Excel spreadsheet.

## Test Overview
The E2ETest performs the following actions:

1. Reads user data from an Excel file (`./src/main/java/userdata/userdata.xlsx`).
2. Iterates through the rows of the spreadsheet to fetch the required data.
3. Navigates through multiple pages of a web form, filling in the form fields with the fetched data.
4. Validates the response for each step of the form submission.
5. Asserts that the final step displays the correct error message when a specific payment method is not supported.

## Excel Data Structure
The Excel spreadsheet (`userdata.xlsx`) is structured with columns representing different user information such as date of birth, phone details, address, personal details, and payment information.

## Prerequisites
* Java Development Kit (JDK) installed
* Selenium WebDriver configured
* Web browser driver (e.g., ChromeDriver) installed
* Apache POI library for Excel file handling

## Running the Test
1. Clone the repository.
2. Open the project in your preferred Java IDE.
3. Ensure Selenium WebDriver and necessary dependencies are set up.
4. Provide valid data in the `userdata.xlsx` Excel file.
5. Run the `autoFillForm` test method in the E2ETest class.

## Note
* Make sure the Excel file is in the correct format, and the sheet name is set to "UserData."
* Update the file path if the Excel file is stored in a different location.