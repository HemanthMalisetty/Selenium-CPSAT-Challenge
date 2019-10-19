package BaseTest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebEventListener extends BaseTest implements WebDriverEventListener {
    String href = "";
    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver webDriver) {

    }

    @Override
    public void afterNavigateTo(String url, WebDriver webDriver) {
        try{
            String noThanks_alertMessage = "//*[@id = 'onesignal-popover-cancel-button']",
                    close_button = "//*[starts-with(@class, 'styles_closeButton')]",
                    close = "//*[@class = 'closeBtn']",
                    acceptCookies = "//*[@class = 'btn-primary cookies-notice-accept']";
            if (isDisplayed(webDriver, noThanks_alertMessage)){
                waitForElementToBeClickable(webDriver, noThanks_alertMessage);
                webDriver.findElement(By.xpath(noThanks_alertMessage)).click();
                waitForElementToBeDisappear(webDriver, noThanks_alertMessage);
            }
            if (isDisplayed(webDriver, close)){
                waitForElementToBeClickable(webDriver, close);
                webDriver.findElement(By.xpath(close)).click();
            }
            if (isDisplayed(webDriver, acceptCookies)){
                waitForElementToBeClickable(webDriver, acceptCookies);
                webDriver.findElement(By.xpath(acceptCookies)).click();
            }
        }catch (Exception e){

        }
    }
    public boolean isClickable(WebDriver driver, String xpath){
        try{
            return driver.findElement(By.xpath(xpath)).isEnabled();
        }catch (Exception e){
         return false;
        }
    }
    /*public boolean isDisplayed(WebDriver driver, String xpath){
        if(driver.findElements(By.xpath(xpath)).size()>0) {
            return driver.findElement(By.xpath(xpath)).isDisplayed();
        }else {
            return false;
        }
    }*/

    public boolean isDisplayed(WebDriver driver, String xpath){
        try {
            return driver.findElement(By.xpath(xpath)).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void waitForElementToBeClickable(WebDriver driver, String xpath){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    public void waitForElementToBeDisappear(WebDriver driver, String xpath){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }
    @Override
    public void beforeClickOn(WebElement element, WebDriver webDriver) {
        try {
            href = element.getAttribute("href");
        }catch (Exception e){

        }
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver webDriver) {
        try{
            if (href.contains("http")) {
                String close = "//*[@class = 'closeBtn']",
                        acceptCookies = "//*[@class = 'btn-primary cookies-notice-accept']";
                if (isDisplayed(webDriver, close)) {
                    waitForElementToBeClickable(webDriver, close);
                    webDriver.findElement(By.xpath(close)).click();
                }
                if (isDisplayed(webDriver, acceptCookies)) {
                    waitForElementToBeClickable(webDriver, acceptCookies);
                    webDriver.findElement(By.xpath(acceptCookies)).click();
                }
            }
        }catch (Exception e){

        }

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver webDriver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver webDriver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        try {
            String close = "//*[@class = 'closeBtn']",
                    acceptCookies = "//*[@class = 'btn-primary cookies-notice-accept']";
            if (isDisplayed(webDriver, close)){
                waitForElementToBeClickable(webDriver,close);
                webDriver.findElement(By.xpath(close)).click();
            }
            if (isDisplayed(webDriver, acceptCookies)){
                waitForElementToBeClickable(webDriver,acceptCookies);
                webDriver.findElement(By.xpath(acceptCookies)).click();
            }
        }catch (Exception e){

        }
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}