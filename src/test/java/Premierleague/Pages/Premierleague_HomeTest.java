package Premierleague.Pages;

import BaseTest.BaseTestTwo;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class Premierleague_HomeTest {
    BaseTestTwo baseTest;
    @Before
    public void navigateToURL(){
        baseTest = new BaseTestTwo();
        baseTest.beforeMethod("chrome", "https://www.premierleague.com/home");
    }
    @Test
    public void onlineRegistration() {
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