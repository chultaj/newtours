package com.demoaut.newtours.steps;

import com.demoaut.newtours.driver.Browser;
import com.demoaut.newtours.driver.BrowserFactory;
import com.demoaut.newtours.driver.BrowserVendor;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    String URL = "http://newtours.demoaut.com";
    static Browser browser;
    static WebDriver drv;

    @Before
    public void OpenHomePage() {
        browser = BrowserFactory.getDriverFactory(BrowserVendor.FIREFOX);
        drv = browser.getDriver();
        drv.get(URL);
    }

    @After
    public void closeBrowser() {
        drv.close();
    }
}
