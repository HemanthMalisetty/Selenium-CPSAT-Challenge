package WoodlandTest.Pages;

import utilities.DriverHelper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Woodland {
    String search_icon = "//*[@id = 'searchForm']//*[contains(@class, 'search-icon searchIcon')]",
            search_textBox = "//*[@id = 'searchkey']",
            search_button = "//*[@id = 'searchBtn']",
            highToLow_sorting = "//*[@class = 'spaceright radioSortBy']",
            prices = "//*[@class = 'offerPrices prize']";

    DriverHelper dh = new DriverHelper();

    public Woodland clickOnSearchIcon() {
        dh.waitForElementToBeClickable(search_icon);
        dh.click(search_icon);
        return this;
    }

    public Woodland enterSearchKeyword(String searchKeyword) {
        dh.waitForElementToBeVisible(search_textBox);
        dh.waitForElementToBeClickable(search_button);
        dh.sendKeys(search_textBox, searchKeyword);
        return this;
    }

    public Woodland clickOnSearchButton() {
        dh.waitForElementToBeClickable(search_button);
        dh.click(search_button);
        return this;
    }
    public Woodland clickOnHighToLowSorting() {
        dh.waitForElementToBeClickable(highToLow_sorting);
        dh.click(highToLow_sorting);
        return this;
    }
    public List<String> getPrices() {
        dh.waitForElementToBeVisible(prices);
        List<WebElement> pricesElementList = dh.findElements(prices);
        List<String> priceIntList = new ArrayList<>();
        for (int i = 0; i< pricesElementList.size(); i++){
            priceIntList.add(pricesElementList.get(i).getText().replace("R", "").trim());
            if (i == 6){
                break;
            }
        }
        return priceIntList;
    }
}
