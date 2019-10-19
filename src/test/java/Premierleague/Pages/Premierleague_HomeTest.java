package Premierleague.Pages;

import BaseTest.BaseTest;
import BaseTest.BaseTestTwo;
import utilities.ExcelUtil;
import org.junit.After;
import org.junit.Test;

import java.awt.*;
import java.util.logging.LogManager;

public class Premierleague_HomeTest extends BaseTestTwo {
    BaseTestTwo baseTest = new BaseTestTwo();
    @Test
    public void onlineRegistration() throws AWTException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil("Cii_TestData");

        baseTest.beforeMethod("chrome", "https://www.premierleague.com/home");


        Premierleague_Home pl = new Premierleague_Home()
                .clickOnTables()
                .contextClickOnArsenal()
                .arsenalWindow();
        String website = pl.getOfficialWebsite();
        pl.premierleagueTableWindow();
        System.out.println(website);
        System.out.println(pl.getPageTitle());
    }

    @After
    public void afterMethod(){
        baseTest.afterMethod();
    }
}