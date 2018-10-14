package com.demoaut.newtours.steps;

import com.demoaut.newtours.pageobjects.MercuryPurchase2;
import com.demoaut.newtours.pageobjects.Reservation2;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class Validation {

    Reservation2 reservation2 = new Reservation2(Hooks.drv);
    MercuryPurchase2 purchase2 = new MercuryPurchase2(Hooks.drv);

    @Given("^\"(.*?)\" page is open$")
    @Then("^\"(.*?)\" page opens$")
    public void page_is_open(String pageTitle) {
        String actualTitle =Hooks.drv.getTitle();
        if (actualTitle.endsWith(":"))
            Assert.assertEquals(actualTitle,pageTitle + ": Mercury Tours:");
        else
            Assert.assertEquals(actualTitle,pageTitle + ": Mercury Tours");
    }

    @Then("the result page contains \"(.*?)\" flights")
    public void the_result_page_contains_flights(String type, List<String> flightsList) {
        List<String> fligtsOnPage;
        switch (type) {
            case("in") :
                fligtsOnPage = reservation2.getInFlights();
                break;
            default:
            case("out") :
                fligtsOnPage = reservation2.getOutFlights();
               break;
        }
        boolean equalLists = fligtsOnPage.size() == flightsList.size() && fligtsOnPage.containsAll(flightsList);
        Assert.assertTrue(equalLists, "Listed flights don't match expected results!");
    }

    @Then("\"(.*?)\" is on the (out|in) flights list")
    public void flight_is_on_the_flights_list(String flight, String type) {
        List<String> fligtsOnPage;
        switch (type) {
            case("in") :
                fligtsOnPage = reservation2.getInFlights();
                break;
            default:
            case("out") :
                fligtsOnPage = reservation2.getOutFlights();
                break;
        }
        boolean isPresent = fligtsOnPage.contains(flight);
        Assert.assertTrue(isPresent, "Flight not found!");
    }

    @Then("\"(.*?)\" message is displayed$")
    public void message_is_displayed(String text) {
        Assert.assertTrue(purchase2.checkConfirmation(text));
    }

    @Then("Only Departure flighs are displayed")
    public void only_Departure_flighs_are_displayed() {
        Assert.assertTrue(reservation2.getInFlights().isEmpty(), "There should be no return flights!");
    }


}
