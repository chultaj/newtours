package com.demoaut.newtours.driver;

public class BrowserFactory {

    public static Browser getDriverFactory(String browserVewndor, String driverPath) {
        Browser browser = null;

        switch (browserVewndor){
            case "chrome":
                browser = new Chrome(driverPath);
                break;
            case "firefox":
                browser = new Firefox(driverPath);
                break;
            case "safari":break;
        }

        return browser;
    }
}
