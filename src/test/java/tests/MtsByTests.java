package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MtsMainPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsByTests {
    WebDriver driver;
    MtsMainPage mtsMainPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        mtsMainPage = new MtsMainPage(driver);
        Thread.sleep(1000);
        mtsMainPage.acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void testBlockTitle() {
        assertEquals("Онлайн пополнение без комиссии", mtsMainPage.getBlockTitleText());
    }

    @Test
    public void testPaymentLogo() {
        assertEquals(5, mtsMainPage.getPaymentLogos().size(), "Должно быть 5 логотипов платёжных систем");
        assertTrue(mtsMainPage.isVisaDisplayed());
        assertTrue(mtsMainPage.isVerifiesVisaDisplayed());
        assertTrue(mtsMainPage.isMcDisplayed());
        assertTrue(mtsMainPage.isMcSecureDisplayed());
        assertTrue(mtsMainPage.isBelkartDisplayed());
    }

    @Test
    public void testInfoLink() {
        String originalWindow = driver.getWindowHandle();
        mtsMainPage.clickInfoLink();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        assertTrue(driver.getCurrentUrl().contains("mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    public void testButtonContinue() {
        assertEquals("Услуги связи", mtsMainPage.getServiceDropdownText());
        mtsMainPage.fillPaymentForm("297777777", "1");
        mtsMainPage.clickContinue();
        assertNotNull(mtsMainPage.getPaymentFrame(), "Форма оплаты должна появиться на странице");
    }

    @Test
    public void testPlaceholders() {
        mtsMainPage.selectServiceOption("Услуги связи");
        assertEquals("Номер телефона", mtsMainPage.getConnectionPhonePlaceholder(), "Placeholder для телефона неверный");
        assertEquals("Сумма", mtsMainPage.getConnectionSumPlaceholder(), "Placeholder для суммы неверный");
        assertEquals("E-mail для отправки чека", mtsMainPage.getConnectionEmailPlaceholder(), "Placeholder для E-mail неверный");

        assertEquals("Номер абонента", mtsMainPage.getInternetContractPlaceholder(), "Placeholder для номера неверный");
        assertEquals("Сумма", mtsMainPage.getInternetSumPlaceholder(), "Placeholder для суммы неверный");
        assertEquals("E-mail для отправки чека", mtsMainPage.getInternetEmailPlaceholder(), "Placeholder для E-mail неверный");

        assertEquals("Номер счета на 44", mtsMainPage.getInstalmentAccountPlaceholder(), "Placeholder для счета неверный");
        assertEquals("Сумма", mtsMainPage.getInstalmentSumPlaceholder(), "Placeholder для суммы неверный");
        assertEquals("E-mail для отправки чека", mtsMainPage.getInstalmentEmailPlaceholder(), "Placeholder для E-mail неверный");

        assertEquals("Номер счета на 2073", mtsMainPage.getArrearsAccountPlaceholder(), "Placeholder для счета неверный");
        assertEquals("Сумма", mtsMainPage.getArrearsSumPlaceholder(), "Placeholder для суммы неверный");
        assertEquals("E-mail для отправки чека", mtsMainPage.getArrearsEmailPlaceholder(), "Placeholder для E-mail неверный");
    }

    @Test
    public void testPaymentForm() {
        mtsMainPage.selectServiceOption("Услуги связи");
        driver.findElement(By.xpath("//input[contains(@id,'connection-phone')]")).sendKeys("297777777");
        driver.findElement(By.xpath("//input[contains(@id,'connection-sum')]")).sendKeys("1");
        driver.findElement(By.xpath("//form[@id='pay-connection']//button[contains(text(),'Продолжить')]")).click();
        mtsMainPage.switchToPaymentFrame();
        assertEquals("1.00 BYN", mtsMainPage.getAmountText(), "Сумма должна быть 1.00 BYN");
        assertEquals("Оплатить 1.00 BYN", mtsMainPage.getPayButtonText());
        assertTrue(mtsMainPage.getPhoneText().contains("375297777777"), "Номер телефона должен отображаться корректно");
        assertEquals("Номер карты", mtsMainPage.getCardNumberPlaceholder());
        assertEquals("Срок действия", mtsMainPage.getExpiryPlaceholder());
        assertEquals("CVC", mtsMainPage.getCvcPlaceholder());
        assertEquals("Имя и фамилия на карте", mtsMainPage.getNamePlaceholder());
        assertTrue(mtsMainPage.isVisaIconDisplayed(), "Должна отображаться иконка Visa");
        assertTrue(mtsMainPage.isMcIconDisplayed(), "Должна отображаться иконка MasterCard");
        assertTrue(mtsMainPage.isBelkartIconDisplayed(), "Должна отображаться иконка Белкарт");
        assertTrue(mtsMainPage.isMaestroOrMirDisplayed(), "Должна отображаться иконка Maestro или Мир");
    }
}
