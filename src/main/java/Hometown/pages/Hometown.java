package Hometown.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverHelper;

public class Hometown {
    String electronics = "//*[@title = 'Electronics']",
            color_filter = "//button[starts-with(@class, 'Buttons__Button') and contains(text(), 'Color')]",
            blackValueInDropDown = color_filter + "/following-sibling::*[contains(@class, 'dropDown')]//*[contains(text(), 'Black')]",
            firstAvailableProduct = "(//*[contains(@class, 'Container-wlflw')]//*[contains(@class, 'ProductWrapper')])[1]",
            quickViewForFirstAvailableProduct = firstAvailableProduct + "//*[contains(@class, 'QuickView__QuickViewBtn')]",
            productNameInQuickView = "//*[@class = 'Row-sc-1mdnrs1-0 hNFYKN']//h1",
            close = "//*[contains(@class, 'styles_closeButton')]",
            productNameOnMainPage = firstAvailableProduct + "//h3";

    DriverHelper dh = new DriverHelper();

    public Hometown clickOnElectronics(){
        dh.waitForElementToBeVisible(electronics);
        dh.waitForElementToBeClickable(electronics);
        dh.click(electronics);
        return this;
    }
    public Hometown hoverOnColorFilter(){
        dh.waitUntilPageLoads();
        dh.waitForElementToBeVisible(color_filter);
        dh.hoverOnElement(color_filter);
        return this;
    }
    public Hometown clickOnBlackInColorFilter(){
        dh.waitForElementToBeClickable(blackValueInDropDown);
        dh.click(blackValueInDropDown);
        return this;
    }
    public Hometown hoverOnFirstAvailableProduct(){
        dh.waitForElementToBeVisible(firstAvailableProduct);
        dh.hoverOnElement(firstAvailableProduct);
        return this;
    }
    public boolean isQuickViewDisplayed(){
        return dh.isDisplayed(quickViewForFirstAvailableProduct);
    }
    public Hometown clickOnQuickView(){
        dh.click(quickViewForFirstAvailableProduct);
        return this;
    }
    public String getProductTextColorFromQuickView(){
        dh.waitForElementToBeVisible(productNameInQuickView);
        return dh.getTextColorRgba(productNameInQuickView);
    }
    public Hometown clickOnCloseQuickView(){
        dh.click(close);
        dh.waitForElementToBeDisappear(close);
        return this;
    }
    public String getProductTextColorFromMainPage(){
        return dh.getTextColorRgb(productNameOnMainPage);
    }
    public void waitUntilPageLoads(){
        new WebDriverWait(dh.getDriver(), 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

}
