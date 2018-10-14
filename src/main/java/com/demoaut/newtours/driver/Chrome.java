package com.demoaut.newtours.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome extends Browser {
    protected Chrome(String driverPath) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }
}
