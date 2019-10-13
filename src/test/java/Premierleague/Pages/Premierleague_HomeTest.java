package Premierleague.Pages;

import BaseTest.BaseTest;
import Utilities.ExcelUtil;
import org.junit.After;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Premierleague_HomeTest extends BaseTest {
    BaseTest baseTest = new BaseTest();
    @Test
    public void onlineRegistration() throws AWTException, InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil("Cii_TestData");

        baseTest.beforeMethod("chrome", "https://www.premierleague.com/");

        Premierleague_Home pl = new Premierleague_Home()
                .clickOnClose()
                .clickOnAcceptCookies()
                .clickOnTables()
                .clickOnClose()
                .contextClickOnArsenal()
                .arsenalWindow();
        System.out.println(pl.getOfficialWebsite());
        pl.premierleagueTableWindow();
        System.out.println(pl.getPageTitle());
    }

    @After
    public void afterMethod(){
        baseTest.afterMethod();
    }
}