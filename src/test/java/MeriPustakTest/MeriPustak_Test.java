package MeriPustakTest;

import BaseTest.BaseTestTwo;
import MeriPustakTest.Pages.MeriPustak_HomePage;
import org.testng.annotations.BeforeTest;
import utilities.ExcelUtil;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class MeriPustak_Test {
    BaseTestTwo baseTest;
    @BeforeTest
    public void navigateToURL(){
        ExcelUtil excelUtil = new ExcelUtil("MeriPustak_TestData");
        baseTest = new BaseTestTwo();
        baseTest.beforeMethod("chrome", "https://www.meripustak.com/");
    }
    @Test
    public void meriPustak_Test(){
        String cartEmptyMessage = ExcelUtil.getValue("cartEmptyMessage"),
                bookName = ExcelUtil.getValue("bookName");

        MeriPustak_HomePage meriPustak = new MeriPustak_HomePage();

        System.out.println("Logo width : " + meriPustak.getLogoWidth());
        System.out.println("Logo Height : " + meriPustak.getLogoHeight());
        System.out.println("Twitter Logo 'href' : " + meriPustak.getTwitterHref());
        meriPustak.clickOnCartIcon();
        assertEquals(meriPustak.getCartEmptyMessage(), cartEmptyMessage, "Cart empty message is not matching");
        meriPustak.searchForBook(bookName)
                .clickOnSearchIcon()
                .selectBook(bookName)
                .clickOnAddToCart();
        assertNotEquals(meriPustak.getCartEmptyMessage(), cartEmptyMessage, "Cart empty message is displaying");
    }

    @AfterTest
    public void afterTest(){
        baseTest.afterMethod();
    }
}
