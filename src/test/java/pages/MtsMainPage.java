package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsMainPage {
    private WebDriver driver;
    private By cookiesAcceptBtn = By.xpath("//button[contains(text(), 'Принять')]");
    private By blockTitle = By.xpath("//h2[normalize-space()='Онлайн пополнение без комиссии']");
    private By paymentLogos = By.xpath("//img[contains(@src,'/pay/')]");
    private By visaLogo = By.xpath("//img[@alt='Visa']");
    private By verifiedVisaLogo = By.xpath("//img[@alt='Verified By Visa']");
    private By mcLogo = By.xpath("//img[@alt='MasterCard']");
    private By mcSecureLogo = By.xpath("//img[@alt='MasterCard Secure Code']");
    private By belkartLogo = By.xpath("//img[@alt='Белкарт']");
    private By infoLink = By.xpath("//a[normalize-space(.)='Подробнее о сервисе']");
    private By serviceDropdown = By.xpath("//span[text()='Услуги связи']");
    private By phoneField = By.xpath("//input[contains(@id,'connection-phone')]");
    private By sumField = By.xpath("//input[contains(@id,'connection-sum')]");
    private By continueBtn = By.xpath("//form[@id='pay-connection']//button[contains(text(),'Продолжить')]");
    private By paymentFrame = By.xpath("//iframe[contains(@class, 'bepaid-iframe')]");

    public MtsMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        try {
            driver.findElement(cookiesAcceptBtn).click();
        } catch (Exception e) {
            System.out.println("Окно куки не появилось или не было найдено");
        }
    }

    public String getBlockTitleText() {
        return driver.findElement(blockTitle).getText().replace("\n", " ");
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(paymentLogos);
    }

    public boolean isVisaDisplayed() {
        return driver.findElement(visaLogo).isDisplayed();
    }

    public boolean isVerifiesVisaDisplayed() {
        return driver.findElement(verifiedVisaLogo).isDisplayed();
    }

    public boolean isMcDisplayed() {
        return driver.findElement(mcLogo).isDisplayed();
    }

    public boolean isMcSecureDisplayed() {
        return driver.findElement(mcSecureLogo).isDisplayed();
    }

    public boolean isBelkartDisplayed() {
        return driver.findElement(belkartLogo).isDisplayed();
    }

    public void clickInfoLink() {
        driver.findElement(infoLink).click();
    }

    public String getServiceDropdownText() {
        return driver.findElement(serviceDropdown).getText();
    }

    public void fillPaymentForm(String phone, String sum) {
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(sumField).sendKeys(sum);
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public WebElement getPaymentFrame() {
        return driver.findElement(paymentFrame);
    }

    private By serviceDropBtn = By.xpath("//button[contains(@class,'select__header')]");
    private By serviceOptions = By.xpath("//ul[contains(@class,'select__list')]//p[@class='select__option']");
    private By connectionPhoneField = By.xpath("//form[@id='pay-connection']//input[contains(@id,'phone')]");
    private By connectionSumField = By.xpath("//form[@id='pay-connection']//input[contains(@id,'sum')]");
    private By connectionEmailField = By.xpath("//form[@id='pay-connection']//input[contains(@id,'email')]");
    private By internetContractField = By.xpath("//form[@id='pay-internet']//input[contains(@id,'internet-phone')]");
    private By internetSumField = By.xpath("//form[@id='pay-internet']//input[contains(@id,'internet-sum')]");
    private By internetEmailField = By.xpath("//form[@id='pay-internet']//input[contains(@id,'internet-email')]");
    private By installmentAccountField = By.xpath("//form[@id='pay-instalment']//input[contains(@id,'score-instalment')]");
    private By installmentSumField = By.xpath("//form[@id='pay-instalment']//input[contains(@id,'instalment-sum')]");
    private By installmentEmailField = By.xpath("//form[@id='pay-instalment']//input[contains(@id,'instalment-email')]");
    private By arrearsAccountField = By.xpath("//form[@id='pay-arrears']//input[contains(@id,'score-arrears')]");
    private By arrearsSumField = By.xpath("//form[@id='pay-arrears']//input[contains(@id,'arrears-sum')]");
    private By arrearsEmailField = By.xpath("//form[@id='pay-arrears']//input[contains(@id,'arrears-email')]");

    public void selectServiceOption(String optionText) {
        driver.findElement(serviceDropBtn).click();
        List<WebElement> options = driver.findElements(serviceOptions);
        for (WebElement option : options) {
            if (option.getText().trim().equals(optionText)) {
                option.click();
                break;
            }
        }
    }

    public String getConnectionPhonePlaceholder() {
        return driver.findElement(connectionPhoneField).getAttribute("placeholder");
    }

    public String getConnectionSumPlaceholder() {
        return driver.findElement(connectionSumField).getAttribute("placeholder");
    }

    public String getConnectionEmailPlaceholder() {
        return driver.findElement(connectionEmailField).getAttribute("placeholder");
    }

    public String getInternetContractPlaceholder() {
        return driver.findElement(internetContractField).getAttribute("placeholder");
    }

    public String getInternetSumPlaceholder() {
        return driver.findElement(internetSumField).getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholder() {
        return driver.findElement(internetEmailField).getAttribute("placeholder");
    }

    public String getInstalmentAccountPlaceholder() {
        return driver.findElement(installmentAccountField).getAttribute("placeholder");
    }

    public String getInstalmentSumPlaceholder() {
        return driver.findElement(installmentSumField).getAttribute("placeholder");
    }

    public String getInstalmentEmailPlaceholder() {
        return driver.findElement(installmentEmailField).getAttribute("placeholder");
    }

    public String getArrearsAccountPlaceholder() {
        return driver.findElement(arrearsAccountField).getAttribute("placeholder");
    }

    public String getArrearsSumPlaceholder() {
        return driver.findElement(arrearsSumField).getAttribute("placeholder");
    }

    public String getArrearsEmailPlaceholder() {
        return driver.findElement(arrearsEmailField).getAttribute("placeholder");
    }

    private By amountText = By.xpath("//div[span[contains(text(), 'BYN')]]");
    private By payButton = By.xpath("//button[contains(text(),'Оплатить')]");
    private By phoneText = By.xpath("//span[contains(text(), 'Оплата: Услуги связи')]");
    private By cardNumberField = By.xpath("//label[contains(text(),'Номер карты')]");
    private By expiryField = By.xpath("//label[contains(text(),'Срок действия')]");
    private By cvcField = By.xpath("//label[contains(text(),'CVC')]");
    private By nameField = By.xpath("//label[contains(text(),'Имя')]");
    private By visaIcon = By.xpath("//img[contains(@src,'visa-system')]");
    private By mcIcon = By.xpath("//img[contains(@src,'mastercard-system')]");
    private By belkartIcon = By.xpath("//img[contains(@src,'belkart-system')]");
    private By maestroIcon = By.xpath("//img[contains(@src,'maestro-system')]");
    private By mirIcon = By.xpath("//img[contains(@src,'mir-system')]");

    public void switchToPaymentFrame() {
        driver.switchTo().frame(driver.findElement(paymentFrame));
    }

    public String getAmountText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(amountText));
        return el.getText().replace("\u00A0", " ").trim();
    }

    public String getPayButtonText() {
        return driver.findElement(payButton).getText();
    }

    public String getPhoneText() {
        return driver.findElement(phoneText).getText();
    }

    public String getCardNumberPlaceholder() {
        return driver.findElement(cardNumberField).getText();
    }

    public String getExpiryPlaceholder() {
        return driver.findElement(expiryField).getText();
    }

    public String getCvcPlaceholder() {
        return driver.findElement(cvcField).getText();
    }

    public String getNamePlaceholder() {
        return driver.findElement(nameField).getText();
    }

    public boolean isVisaIconDisplayed() {
        return driver.findElement(visaIcon).isDisplayed();
    }

    public boolean isMcIconDisplayed() {
        return driver.findElement(mcIcon).isDisplayed();
    }

    public boolean isBelkartIconDisplayed() {
        return driver.findElement(belkartIcon).isDisplayed();
    }

    public boolean isMaestroOrMirDisplayed() {
        return driver.findElements(maestroIcon).size() > 0 || driver.findElements(mirIcon).size() > 0;
    }
}
