package com.demoaut.newtours.driver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends Browser {
    protected Firefox() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        driver = new FirefoxDriver();
    }
}
