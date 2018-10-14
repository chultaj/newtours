package com.demoaut.newtours.steps;

import com.demoaut.newtours.driver.Browser;
import com.demoaut.newtours.driver.BrowserFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Hooks {

    String URL = "http://newtours.demoaut.com";
    static Browser browser;
    static WebDriver drv;

    @Before
    public void OpenHomePage() throws IOException {
        Properties prop = new Properties();
        InputStream input = null;
        input = new FileInputStream("drivers/browser.properties");
        prop.load(input);

        String vendor = prop.getProperty("browser");
        String driverPath = prop.getProperty("driver");
        URL = prop.getProperty("url");

        browser = BrowserFactory.getDriverFactory(vendor, driverPath);
        drv = browser.getDriver();
        drv.get(URL);
    }

    @After
    public void closeBrowser() {
        drv.close();
    }


}
