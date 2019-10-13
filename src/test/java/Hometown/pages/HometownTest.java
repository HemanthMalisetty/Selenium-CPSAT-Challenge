package Hometown.pages;

import BaseTest.BaseTestTwo;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HometownTest extends BaseTestTwo  {
    BaseTestTwo baseTest = new BaseTestTwo();
    @Test
    public void hometownTest() {

        baseTest.beforeMethod("chrome", "https://www.hometown.in/");

        Hometown ht = new Hometown();
        ht.clickOnElectronics()
                .hoverOnColorFilter()
                .clickOnBlackInColorFilter()
                .hoverOnFirstAvailableProduct();
        assertTrue("Quick view is not displayed", ht.isQuickViewDisplayed());
        ht.clickOnQuickView();
        assertEquals(ht.getProductTextColorFromQuickView(), "rgba(51, 51, 51, 0.85)");
        ht.clickOnCloseQuickView();
        assertEquals(ht.getProductTextColorFromMainPage(), "rgb(81, 81, 81)");
    }
    @After
    public void afterMethod(){
        baseTest.afterMethod();
    }
}