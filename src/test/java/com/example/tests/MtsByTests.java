package com.example.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsByTests {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        try {
            Thread.sleep(1000); // Краткая пауза для появления окна
            WebElement acceptCookies = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("Окно куки не появилось или не было найдено");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        WebElement title = driver.findElement(By.xpath("//h2[normalize-space()='Онлайн пополнение без комиссии']"));
        assertEquals("Онлайн пополнение без комиссии", title.getText().replace("\n", " "));
    }

    @Test
    public void testPaymentLogo() {
        List<WebElement> logo = driver.findElements(By.xpath("//img[contains(@src,'/pay/')]"));
        assertEquals(5, logo.size(), "Должно быть 5 логотипов платёжных систем");
        assertTrue(driver.findElement(By.xpath("//img[@alt='Visa']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//img[@alt='Verified By Visa']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//img[@alt='MasterCard']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//img[@alt='MasterCard Secure Code']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//img[@alt='Белкарт']")).isDisplayed());
    }

    @Test
    public void testInfoLink() {
        WebElement link = driver.findElement(By.xpath("//a[normalize-space(.)='Подробнее о сервисе']"));
        String originalWindow = driver.getWindowHandle();
        link.click();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        assertTrue(driver.getCurrentUrl().contains("mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"), "Ссылка должна вести на страницу с информацией о сервисе");
    }

    @Test
    public void testButtonContinue() {
        WebElement serviceDropdown = driver.findElement(By.xpath("//span[text()='Услуги связи']"));
        String actualText = serviceDropdown.getText();
        assertEquals("Услуги связи", actualText, "По умолчанию должно быть выбрано 'Услуги связи'");
        WebElement phoneField = driver.findElement(By.xpath("//input[contains(@id,'connection-phone')]"));
        WebElement sumField = driver.findElement(By.xpath("//input[contains(@id,'connection-sum')]"));
        //WebElement emailField = driver.findElement(By.xpath("//input[contains(@id,'connection-email')]")); - необязательное поле
        WebElement continueBtn = driver.findElement(By.xpath("//form[@id='pay-connection']//button[contains(text(),'Продолжить')]"));
        phoneField.sendKeys("297777777");
        sumField.sendKeys("1");
        continueBtn.click();
        WebElement paymentForm = driver.findElement(By.xpath("//iframe[contains(@src, 'bepaid.by')]"));
        assertNotNull(paymentForm, "Форма оплаты должна появиться на странице");
    }
}
