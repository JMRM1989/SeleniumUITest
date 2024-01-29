import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sl.BaseScript;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class E2ETest extends BaseScript {

    @Test
    public void autoFillForm() throws IOException {

        // Initialize Excel file
        FileInputStream file = new FileInputStream("./src/main/java/userdata/userdata.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("UserData");


        // Iterate through the rows and columns to read the data
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            String date = row.getCell(0).getStringCellValue();
            String celprefix = row.getCell(1).getStringCellValue();
            String cellphone = row.getCell(2).getStringCellValue();
            String heigh = row.getCell(3).getStringCellValue();
            String weigh = row.getCell(4).getStringCellValue();
            String name = row.getCell(5).getStringCellValue();
            String lastn = row.getCell(6).getStringCellValue();
            String idnumber = row.getCell(7).getStringCellValue();
            String pass = row.getCell(8).getStringCellValue();
            String street = row.getCell(9).getStringCellValue();
            String streetnum = row.getCell(10).getStringCellValue();
            String postcode = row.getCell(11).getStringCellValue();
            String mail = row.getCell(12).getStringCellValue();
            String birht_place = row.getCell(13).getStringCellValue();
            String work = row.getCell(14).getStringCellValue();
            String money = row.getCell(15).getStringCellValue();
            String card = row.getCell(16).getStringCellValue();

            // Execute the test with the current set of data
            // Page 1
            driver.get(baseURL);
            WebElement birthday = driver.findElement(By.id("BirthdayStep1"));
            WebElement prefix = driver.findElement(By.id("txtPhoneCode"));
            WebElement phone = driver.findElement(By.id("txtPhoneNumber"));


            birthday.sendKeys(date);
            prefix.sendKeys(celprefix);
            phone.sendKeys(cellphone);

            List<WebElement> province = driver.findElements(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/form/div[1]/div[3]/div/div[2]/div[2]/span"));
            province.get(0).click(); // click on first Dropdown, for example

            WebElement provinceSelect = driver.findElement(By.className("select2-search__field"));
            provinceSelect.sendKeys("CABA");
            provinceSelect.sendKeys(Keys.RETURN);

            WebElement contratarButton = driver.findElement(By.id("btnSaveStep1"));

            pause();
            contratarButton.click();

            // Page 2
            WebElement altura = driver.findElement(By.id("txtHeight"));
            WebElement peso = driver.findElement(By.id("txtWeight"));
            WebElement next2 = driver.findElement(By.id("btnSaveStep2"));

            altura.sendKeys(heigh);
            peso.sendKeys(weigh);

            pause();
            next2.click();

            // Page 3
            WebElement nombre = driver.findElement(By.id("Name"));
            WebElement apellido = driver.findElement(By.id("Surname"));
            WebElement dni = driver.findElement(By.id("ID_Number"));
            WebElement email = driver.findElement(By.id("txtEmail"));
            WebElement contra = driver.findElement(By.id("Password"));
            WebElement calle = driver.findElement(By.id("Street"));
            WebElement numero = driver.findElement(By.id("HouseNumber"));
            WebElement postal = driver.findElement(By.id("zipCode"));


            nombre.sendKeys(name);
            apellido.sendKeys(lastn);
            dni.sendKeys(idnumber);


            pause();
            WebElement genero = driver.findElement(By.id("select2-Gender-container"));
            genero.click();
            // for some reason xpath or id was not working for selecting Gender, best alternative was to click ENTER
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.RETURN);
            builder.perform();

            pause();
            WebElement estado = driver.findElement(By.id("select2-CivilStatus-container"));
            estado.click();
            builder.sendKeys(Keys.RETURN);
            builder.perform();

            pause();
            email.sendKeys(mail);
            contra.sendKeys(pass);
            calle.sendKeys(street);
            numero.sendKeys(streetnum);
            postal.sendKeys(postcode);

            pause();
            WebElement register = driver.findElement(By.id("btnRegister"));
            register.click();

            pause();

            // Page 4
            List<WebElement> nacionalidad = driver.findElements(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/form/div[1]/div[2]/div/div[1]/div/div[1]/span/span[1]/span"));
            nacionalidad.get(0).click();

            WebElement nacionalidadSelect = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
            nacionalidadSelect.sendKeys("Argentina");
            nacionalidadSelect.sendKeys(Keys.RETURN);
            pause();

            WebElement lugar_nacimiento = driver.findElement(By.id("PlaceOfBirth"));
            WebElement trabajo = driver.findElement(By.name("Occupation"));
            WebElement sueldo = driver.findElement(By.name("AnnualIncome"));

            lugar_nacimiento.sendKeys(birht_place);
            trabajo.sendKeys(work);
            sueldo.sendKeys(money);
            pause();

            WebElement origin = driver.findElement(By.id("select2-txtAnnualIncome-container"));
            origin.click();
            builder.sendKeys(Keys.RETURN);
            builder.perform();
            pause();

            WebElement save_info = driver.findElement(By.id("btnSaveInfo"));
            save_info.click();

            // Page 5
            pause();
            WebElement tarjeta = driver.findElement(By.id("CardNumber"));
            tarjeta.sendKeys(card);
            pause();

            WebElement submit = driver.findElement(By.id("btnSubmitStep4"));
            submit.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-pnotify-text"))).getText();
            WebElement alert = driver.findElement(By.cssSelector(".ui-pnotify-text"));

            Assert.assertEquals("Método de pago no soportado",alert.getText());
            pause();

        }
    }
}
