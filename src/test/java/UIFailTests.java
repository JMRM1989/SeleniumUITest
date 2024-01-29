import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sl.BaseScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class UIFailTests extends BaseScript {
    @Test
    public void incorrectBirthday() {
        driver.get(baseURL);
        WebElement birthday = driver.findElement(By.id("BirthdayStep1"));
        WebElement prefix = driver.findElement(By.id("txtPhoneCode"));
        WebElement phone = driver.findElement(By.id("txtPhoneNumber"));
        
        birthday.sendKeys("29081875");
        prefix.sendKeys("11");
        phone.sendKeys("12345678");

        List<WebElement> province = driver.findElements(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/form/div[1]/div[3]/div/div[2]/div[2]/span"));
        province.get(0).click(); // click on first Dropdown, for example

        WebElement provinceSelect = driver.findElement(By.className("select2-search__field"));
        provinceSelect.sendKeys("CABA");
        provinceSelect.sendKeys(Keys.RETURN);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-pnotify-text"))).getText();
        WebElement alert = driver.findElement(By.cssSelector(".ui-pnotify-text"));

        Assert.assertEquals("La fecha que ingresaste es inválida",alert.getText());
        pause();
    }
    @Test
    public void incorrectProvince(){
        driver.get(baseURL);
        List<WebElement> province = driver.findElements(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/form/div[1]/div[3]/div/div[2]/div[2]/span"));
        province.get(0).click(); // click on first Dropdown, for example

        WebElement provinceSelect = driver.findElement(By.className("select2-search__field"));
        provinceSelect.sendKeys("aaaa");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/span/span/span[2]/ul/li"))).getText();
        WebElement results = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li"));

        Assert.assertEquals("No results found",results.getText());
        pause();
    }
    @Test
    public void incorrectPhone(){
        driver.get(baseURL);
        WebElement birthday = driver.findElement(By.id("BirthdayStep1"));
        WebElement prefix = driver.findElement(By.id("txtPhoneCode"));
        WebElement phone = driver.findElement(By.id("txtPhoneNumber"));

        birthday.sendKeys("29081990");
        prefix.sendKeys("aaaa");
        phone.sendKeys("aaaaaaaa");

        List<WebElement> province = driver.findElements(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/form/div[1]/div[3]/div/div[2]/div[2]/span"));
        province.get(0).click(); // click on first Dropdown, for example

        WebElement provinceSelect = driver.findElement(By.className("select2-search__field"));
        provinceSelect.sendKeys("CABA");
        provinceSelect.sendKeys(Keys.RETURN);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-pnotify-text"))).getText();
        WebElement alert = driver.findElement(By.cssSelector(".ui-pnotify-text"));

        pause();
        Assert.assertEquals("Por favor, ingresá solo números.",alert.getText());
    }
}
