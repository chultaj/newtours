package com.demoaut.newtours.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Reservation2 {

    WebDriver drv;

    @FindBy(name="outFlight")
    List<WebElement> outFlights;

    @FindBy(name="inFlight")
    List <WebElement> inFlights;

    @FindBy(name="reserveFlights")
    WebElement reserverFlights;

    public Reservation2(WebDriver drv) {
        this.drv = drv;
        PageFactory.initElements(drv, this);
    }

    public MercuryPurchase clickContinue() {
        this.reserverFlights.click();
        return new MercuryPurchase(drv);
    }

    public List<String> getOutFlights() {
        List<String> listOfFlights = new ArrayList<>();

        for (WebElement elem: this.outFlights) {
            String val = elem.getAttribute("value");
            listOfFlights.add(val);
        }
        return listOfFlights;
    }

    public List<String> getInFlights() {
        List<String> listOfFlights = new ArrayList<>();

        for (WebElement elem: this.inFlights) {
            String val = elem.getAttribute("value");
            listOfFlights.add(val);
        }
        return listOfFlights;
    }

    public void chooseFlight (String flight) {
        //Assume that fligth ids are unique
        for (WebElement radio : this.inFlights)
            if (radio.getAttribute("value").equalsIgnoreCase(flight))
                radio.click();
        for (WebElement radio : this.outFlights)
            if (radio.getAttribute("value").equalsIgnoreCase(flight))
                radio.click();
    }


}
