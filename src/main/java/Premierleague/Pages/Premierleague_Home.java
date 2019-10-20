package Premierleague.Pages;

import utilities.DriverHelper;
import utilities.LocalDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;


public class Premierleague_Home {
    String tables = "//*[@class = 'subNav']//a[text() = 'Tables']",
            arsenal = "(//*[@class = 'pos button-tooltip']//following-sibling::*[@class = 'team']//a[contains(@href, 'Arsenal')])[1]",
            acceptCookies = "//*[@class = 'btn-primary cookies-notice-accept']",
            close = "//*[@class = 'closeBtn']",
            officialWebsite = "//*[@class = 'website']//*[contains(@href, 'arsenal')]";

    DriverHelper dh = new DriverHelper();

    public Premierleague_Home clickOnTables(){
        dh.click(tables);
        return this;
    }
    public Premierleague_Home clickOnClose(){
        dh.waitForElementToBeClickable(close);
        dh.click(close);
        return this;
    }
    public Premierleague_Home contextClickOnArsenal() throws AWTException, InterruptedException {
        dh.waitForElementToBeClickable(arsenal);
        dh.waitForElementToBeVisible(arsenal);
        Thread.sleep(5000);
        Actions actions = new Actions(LocalDriverManager.getDriver());
        actions.moveToElement(dh.findElement(arsenal)).build().perform();
        actions.contextClick(dh.findElement(arsenal)).build().perform();
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        return this;
    }
    public Premierleague_Home clickOnAcceptCookies(){
        dh.waitForElementToBeClickable(acceptCookies);
        dh.click(acceptCookies);
        return this;
    }
    public Premierleague_Home switchToWindow(String xpath){
        for (String window : dh.getAvailableWindows()){
            dh.getDriver().switchTo().window(window);
            if (dh.isDisplayed(xpath)){
                break;
            }
        }
        return this;
    }
    public Premierleague_Home arsenalWindow(){
        switchToWindow(officialWebsite);
        return this;
    }
    public Premierleague_Home premierleagueTableWindow(){
        switchToWindow(arsenal);
        return this;
    }
    public String getPageTitle(){
        return dh.getTitle();
    }
    public String getOfficialWebsite(){
        dh.waitForElementToBeVisible(officialWebsite);
        return dh.getText(officialWebsite);
    }
}