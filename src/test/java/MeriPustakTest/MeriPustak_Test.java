package MeriPustakTest;

import BaseTest.BaseTest;
import MeriPustakTest.Pages.MeriPustak_HomePage;
import Utilities.ExcelUtil;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class MeriPustak_Test extends BaseTest {

    BaseTest baseTest = new BaseTest();

    @Test
    public void meriPustak_Test() throws IOException {
        baseTest.beforeMethod("chrome", "https://www.meripustak.com/");

        ExcelUtil excelUtil = new ExcelUtil("MeriPustak_TestData");

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
