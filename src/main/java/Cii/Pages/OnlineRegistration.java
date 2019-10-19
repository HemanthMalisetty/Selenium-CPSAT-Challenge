package Cii.Pages;

import utilities.DriverHelper;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OnlineRegistration {
    String noOfAttendee_dropdown = "//*[@id = 'drpAttendee']",
            attendees_rows = "//*[contains(@id, 'drpTitle')]";

    DriverHelper dh = new DriverHelper();

    public OnlineRegistration selectNoOfAttendees(int noOfAttendees){
        dh.waitForElementToBeVisible(noOfAttendee_dropdown);
        dh.selectByVisibleText(noOfAttendee_dropdown, String.valueOf(noOfAttendees));
        dh.waitForNoOfElements(attendees_rows, noOfAttendees);
        return this;
    }
    public int getNoOfAttendeesRows(){
        dh.waitForElementToBeClickable(attendees_rows);
        return dh.findElements(attendees_rows).size();
    }
    public OnlineRegistration setTitleOfAttendee(String attendeeNo, String title){
        dh.selectByVisibleText("(" + attendees_rows + ")[" + attendeeNo + "]", title);
        return this;
    }
    public List<WebElement> getAttendeeTitleDropdownValues(){
        return dh.getDropdownValues(attendees_rows);
    }
}
