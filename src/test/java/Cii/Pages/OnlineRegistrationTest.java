package Cii.Pages;

import BaseTest.BaseTestTwo;
import org.junit.Before;
import utilities.ExcelUtil;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OnlineRegistrationTest {
    BaseTestTwo baseTest;
    @Before
    public void navigateToURL(){
        ExcelUtil excelUtil = new ExcelUtil("Cii_TestData");
        baseTest = new BaseTestTwo();
        baseTest.beforeMethod("chrome", "https://www.cii.in/OnlineRegistration.aspx");
    }
    @Test
    public void onlineRegistration(){
        int noOfAttendees = Integer.parseInt(ExcelUtil.getValue("noOfAttendees"));
        String[] titles = {ExcelUtil.getValue("attendeeTitle1"),
                ExcelUtil.getValue("attendeeTitle2"),
                ExcelUtil.getValue("attendeeTitle3")};

        OnlineRegistration or = new OnlineRegistration();

        or.selectNoOfAttendees(noOfAttendees);
        assertEquals("Attendee rows are not matching", noOfAttendees, or.getNoOfAttendeesRows());
        for (int i = 0; i < titles.length; i++) {
            or.setTitleOfAttendee(String.valueOf(i + 1), titles[i]);
        }
        List<WebElement> dropdownValues = or.getAttendeeTitleDropdownValues();
        for (WebElement element : dropdownValues) {
            System.out.println(element.getText());
        }
    }
    @After
    public void afterMethod(){
        baseTest.afterMethod();
    }
}