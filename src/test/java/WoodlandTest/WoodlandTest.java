package WoodlandTest;

import BaseTest.BaseTestTwo;
import org.testng.annotations.BeforeTest;
import utilities.ExcelUtil;
import WoodlandTest.Pages.Woodland;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WoodlandTest {
    BaseTestTwo baseTest;
    @BeforeTest
    public void navigateToURL(){
        ExcelUtil excelUtil = new ExcelUtil("woodland_TestData");
        baseTest = new BaseTestTwo();
        baseTest.beforeMethod("chrome", "https://www.woodlandworldwide.com/");
    }

    @Test
    public void woodlandTest() throws IOException {
        Woodland wl = new Woodland();

        Set<String> searchItems = ExcelUtil.getKeySet();
        Iterator<String> it = searchItems.iterator();
        while (it.hasNext()) {
            wl.clickOnSearchIcon()
                    .enterSearchKeyword(it.next())
                    .clickOnSearchButton()
                    .clickOnHighToLowSorting();
            List<String> prices = wl.getPrices();
            int integerOne, integerTwo;
            for (int i = 0; i < 7; i++) {
                integerOne = Integer.valueOf(prices.get(i));
                for (int j = i + 1; j < 7; j++) {
                    integerTwo = Integer.valueOf(prices.get(j));
                    if (integerOne >= integerTwo) {
                        assertTrue(true);
                    } else {
                        assertTrue(false);
                    }
                }
            }
        }
    }

    @AfterTest
    public void afterMethod(){
        baseTest.afterMethod();
    }
}