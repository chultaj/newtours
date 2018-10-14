package com.demoaut.newtours.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryPurchase {

    WebDriver drv;

    @FindBy(name="passFirst0")
    WebElement passFirst0;

    @FindBy(name="passLast0")
    WebElement passLast0;

    @FindBy(name="buyFlights")
    WebElement buyFlights;


    public MercuryPurchase(WebDriver drv) {
        this.drv = drv;
        PageFactory.initElements(drv, this);
    }

    public MercuryPurchase2 clickContinue() {
        this.buyFlights.click();
        return new MercuryPurchase2(drv);
    }
}
