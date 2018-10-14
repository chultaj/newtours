package com.demoaut.newtours.driver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends Browser {
    protected Firefox(String driverPath) {
        System.setProperty("webdriver.gecko.driver", driverPath);

        driver = new FirefoxDriver();
    }
}
