# Demo:

### Initialize Excel File:

* The test reads data from an Excel file located at ./src/main/java/userdata/userdata.xlsx.

### Iterate Through Data Rows:

* The test iterates through each row of the Excel sheet, extracting data for form filling.

### Form Filling - Page 1:

* Navigates to the specified baseURL.
* Enters date, cell prefix, and phone number.
* Interacts with dropdowns to select a province.
* Clicks the "Save" button on Page 1.

### Form Filling - Page 2:

* Enters height and weight.
* Clicks the "Next" button to move to Page 3.

### Form Filling - Page 3:

* Enters personal details like name, surname, ID number, etc.
* Selects gender and civil status.
* Clicks the "Register" button.

### Form Filling - Page 4:

* Selects nationality.
* Enters place of birth, occupation, and annual income.
* Clicks the "Save" button.

### Form Filling - Page 5:

* Enters credit card details.
* Clicks the "Submit" button.

### Verify Result:

* Waits for a notification to be displayed.
* Asserts that the notification message is "Método de pago no soportado" (Payment method not supported).

### Repeat for Each Data Set:

* The entire process is repeated for each set of data in the Excel sheet.

# Technical Solution:

* Test Framework: The code is written using TestNG, a testing framework for Java.
* WebDriver: The test uses Selenium WebDriver for browser automation.
* Excel Reading: Apache POI library is used for reading data from Excel.
* Explicit Waits: WebDriverWait is used for waiting until specific conditions are met.
* Assertions: TestNG's Assert class is utilized for making assertions.

# Implementation:

### Excel Reading:

* Apache POI is used to read data from the Excel sheet.

### WebDriver Initialization:

* An instance of the WebDriver is initialized, and the browser navigates to the specified baseURL.

### Test Method: autoFillForm:

* A loop iterates through each row of the Excel sheet.
* Elements on the webpage are identified using various locators (e.g., By.id, By.xpath).
* Data is entered into the form on different pages.
* WebDriverWait is used for waiting until specific elements are visible.
* Assertions check if the correct notification message is displayed.