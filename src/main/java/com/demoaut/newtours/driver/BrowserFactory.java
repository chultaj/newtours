package com.demoaut.newtours.driver;

public class BrowserFactory {

    public static Browser getDriverFactory(BrowserVendor browserVewndor) {
        Browser browser = null;

        switch (browserVewndor){
            case CHROME:
                browser = new Chrome();
                break;
            case FIREFOX:
                browser = new Firefox();
                break;
            case SAFARI:break;
        }

        return browser;
    }
}
