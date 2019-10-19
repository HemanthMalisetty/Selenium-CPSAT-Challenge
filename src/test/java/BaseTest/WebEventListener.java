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
        Reporter.log("alert is preseent"+ webDriver.switchTo().alert().getText());
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        Reporter.log("Alert is accepted");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        Reporter.log("Alert is dismissed");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver webDriver) {
        Reporter.log("Navigation to :"+url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver webDriver) {
        Reporter.log("Navigated to :"+url);

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

    }
    public boolean isClickable(WebDriver driver, String xpath){
        try{
            return driver.findElement(By.xpath(xpath)).isEnabled();
        }catch (Exception e){
         return false;
        }finally {

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
        Reporter.log("Finding the element :");
        Reporter.log(by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        Reporter.log("Found the element :");
        Reporter.log(by.toString());
    }
    @Override
    public void beforeClickOn(WebElement element, WebDriver webDriver) {
        Reporter.log("Clicking on :"+element.getText());
        Reporter.log(element.toString());
        try {
            href = element.getAttribute("href");
        }catch (Exception e){

        }
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver webDriver) {
        Reporter.log("Clicked on :" + element);
        Reporter.log(element.toString());

        System.out.println("inside afterClickOn method" + href);
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
        Reporter.log("Value of the:" + element.toString()
                + " before any changes made");

        Reporter.log("Value of the:" + element.toString()
                + keysToSend.toString());
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver webDriver, CharSequence[] keysToSend) {
        Reporter.log("Element value changed to: " + element.toString());
        Reporter.log("Value of the:" + element.toString()
                + keysToSend.toString());
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
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("Exception occured: " + throwable);
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