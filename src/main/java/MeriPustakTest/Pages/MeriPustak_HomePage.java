package MeriPustakTest.Pages;

import Utilities.DriverHelper;

public class MeriPustak_HomePage {
    String logo = "//*[@id = 'mpstkLogo']/img",
            twitter_icon = "//*[@class = 'social links_right']//a[contains(@href, 'twitter.com')]",
            cart_icon = "//*[@class = 'shopping_cart']/a",
            cartEmptyMessage = "//*[@id = 'ContentPlaceHolder1_gvCartTable']",
            search_textBox = "//*[@id = 'txtsearch']",
            search_icon = "//*[@id = 'btnsearch']",
            addToCart_icon = "//*[@id = 'ContentPlaceHolder1_AddtoCart']";

    DriverHelper dh = new DriverHelper();

    public int getLogoWidth(){
        return dh.getImageWidth(logo);
    }
    public int getLogoHeight(){
        return dh.getImageHeight(logo);
    }
    public String getAttribute(String xpath){
        return dh.getAttribute(xpath, "href");
    }
    public String getTwitterHref(){
        return getAttribute(twitter_icon);
    }
    public MeriPustak_HomePage clickOnCartIcon(){
        dh.waitForElementToBeClickable(cart_icon);
        dh.click(cart_icon);
        return this;
    }
    public String getCartEmptyMessage(){
        return dh.getText(cartEmptyMessage).trim();
    }
    public MeriPustak_HomePage searchForBook(String bookName){
        dh.sendKeys(search_textBox, bookName);
        return this;
    }
    public MeriPustak_HomePage clickOnSearchIcon(){
        dh.waitForElementToBeClickable(search_icon);
        dh.click(search_icon);
        return this;
    }
    public MeriPustak_HomePage selectBook(String bookName){
        String book = "//a[contains(text(), '" + bookName + "')]";
        dh.waitForElementToBeClickable(book);
        dh.click(book);
        return this;
    }
    public MeriPustak_HomePage clickOnAddToCart(){
        dh.waitForElementToBeClickable(addToCart_icon);
        dh.click(addToCart_icon);
        return this;
    }
}