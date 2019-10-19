package utilities

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.Color
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait

class DriverHelper {
    var driver: WebDriver = LocalDriverManager.getDriver()
    private val webDriverWait = WebDriverWait(driver, 30)

    fun findElement(by: By): WebElement {
        return driver.findElement(by)
    }
    fun findElement(xpath: String): WebElement {
        return driver.findElement(By.xpath(xpath))
    }
    fun findElements(by: By): List<WebElement> {
        return driver.findElements(by)
    }
    fun findElements(xpath: String): List<WebElement> {
        return driver.findElements(By.xpath(xpath))
    }
    fun click(xpath: String) {
        findElement(xpath).click()
    }
    fun click(by: By) {
        findElement(by).click()
    }
    fun getTitle(): String {
        return driver.title
    }
    fun getImageWidth(by: By): Int {
        return driver.findElement(by).size.getWidth()
    }
    fun getImageWidth(xpath: String): Int {
        return driver.findElement(By.xpath(xpath)).size.getWidth()
    }
    fun getImageHeight(by: By): Int {
        return driver.findElement(by).size.getHeight()
    }
    fun getImageHeight(xpath: String): Int {
        return driver.findElement(By.xpath(xpath)).size.getHeight()
    }
    fun getAttribute(by: By, attribute: String): String {
        return driver.findElement(by).getAttribute(attribute)
    }
    fun getAttribute(xpath: String, attribute: String): String {
        return driver.findElement(By.xpath(xpath)).getAttribute(attribute)
    }
    fun waitForElementToBeClickable(xpath: String) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))
    }
    fun waitForElementToBeVisible(xpath: String) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)))
    }
    fun waitForElementToBeDisappear(xpath: String) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))))
    }
    fun waitForNoOfElements(by: By, noOfElements: Int) {
        webDriverWait.until(ExpectedConditions.numberOfElementsToBe(by, noOfElements))
    }
    fun waitForNoOfElements(xpath: String, noOfElements: Int) {
        webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpath), noOfElements-1))
    }
    fun getText(xpath: String): String {
        return driver.findElement(By.xpath(xpath)).text
    }
    fun getText(by: By): String {
        return driver.findElement(by).text
    }
    fun sendKeys(xpath: String, text: String) {
        driver.findElement(By.xpath(xpath)).sendKeys(text)
    }
    fun sendKeys(by: By, text: String) {
        driver.findElement(by).sendKeys(text)
    }
    fun isDisplayed(by: By): Boolean {
        try {
            return driver.findElement(by).isDisplayed
        } catch (e: Exception) {
            return false
        }

    }
    fun isDisplayed(xpath: String): Boolean {
        return if (driver.findElements(By.xpath(xpath)).size > 0) {
            driver.findElement(By.xpath(xpath)).isDisplayed
        } else {
            false
        }
    }
    /*fun isDisplayed(xpath: String): Boolean {
        try {
            return driver.findElement(By.xpath(xpath)).isDisplayed
        } catch (e: Exception) {
            return false
        }

    }*/
    fun isClickable(xpath: String): Boolean {
        try {
            return driver.findElement(By.xpath(xpath)).isEnabled
        } catch (e: Exception) {
            return false
        }

    }
    fun selectByVisibleText(by: By, visibleText: String) {
        val select = Select(driver.findElement(by))
        select.deselectByVisibleText(visibleText)
    }
    fun selectByVisibleText(xpath: String, visibleText: String) {
        val select = Select(driver.findElement(By.xpath(xpath)))
        select.selectByVisibleText(visibleText)
    }
    fun getDropdownValues(by: By): List<WebElement> {
        val select = Select(driver.findElement(by))
        return select.options
    }
    fun getDropdownValues(xpath: String): List<WebElement> {
        val select = Select(driver.findElement(By.xpath(xpath)))
        return select.options
    }
    fun scrollIntoView(locator: String) {
        val element = findElement(locator)
        (driver as JavascriptExecutor).executeAsyncScript("arguments[0].scrollIntoView(true);", element)
    }
    fun getAvailableWindows(): Set<String> {
        return driver.windowHandles
    }
    fun hoverOnElement(xpath: String) {
        val actions = Actions(driver)
        actions.moveToElement(findElement(By.xpath(xpath))).build().perform()
    }
    fun getTextColorRgba(xpath: String): String {
        val color = driver.findElement(By.xpath(xpath)).getCssValue("color")
        return Color.fromString(color).asRgba()
    }
    fun getTextColorRgb(xpath: String): String {
        val color = driver.findElement(By.xpath(xpath)).getCssValue("color")
        return Color.fromString(color).asRgb()
    }
    fun waitUntilPageLoads() {
        webDriverWait.until { webDriver -> (webDriver as JavascriptExecutor).executeScript("return document.readyState") == "complete" }
    }
}