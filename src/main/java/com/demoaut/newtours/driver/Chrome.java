package com.demoaut.newtours.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome extends Browser {
    protected Chrome() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
    }
}
