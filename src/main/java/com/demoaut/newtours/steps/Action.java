package com.demoaut.newtours.steps;

import com.demoaut.newtours.pageobjects.*;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Action {

    Welcome welcome = new Welcome(Hooks.drv);
    Reservation reservation;
    Reservation2 reservation2;
    MercuryPurchase purchase;
    MercuryPurchase2 purchase2;

    @When("^I provide username and password")
    public void enterCredentials(DataTable creds) {
        welcome.sendUserName(creds.cell(0,0));
        welcome.sendPassword(creds.cell(0,1));
    }

    @When("^click Sign-In button$")
    public void signIn() {
        reservation = welcome.clickSignIn();
    }

    @When("^I click continue button$")
    public void findFlights() {
        reservation2 = reservation.clickContinue();
    }

    @When("^I click continue button2$") // Continue button on the second page(reservation)
    public void reserveFlights() {
        purchase = reservation2.clickContinue();
    }

    @When("^I click Secure Purchase$")
    public void purchase() {
        purchase2 = purchase.clickContinue();

    }

    @When("^I provide flight details$")
    public void provideDetails(DataTable details ) {
        reservation.setDepartureMonth(details.cell(0,0).split(" ")[0]);
        reservation.setDepartureDay(details.cell(0,0).split(" ")[1]);
        reservation.setDestination(details.cell(0,2));
        reservation.setReturnMonth(details.cell(0,1).split(" ")[0]);
        reservation.setReturnDay(details.cell(0,1).split(" ")[1]);
    }

    @When("^I provide flight details: \"(.*?)\" \"(.*?)\" \"(.*?)\"")
    public void provideDetails(String departure, String comeBack, String destination) {
        reservation.setDepartureMonth(departure.split(" ")[0]);
        reservation.setDepartureDay(departure.split(" ")[1]);
        reservation.setDestination(destination);
        reservation.setReturnMonth(comeBack.split(" ")[0]);
        reservation.setReturnDay(comeBack.split(" ")[1]);
    }

    @When("^preferences$")
    public void preferences() {}

    @When("^I choose flight \"(.*?)\"")
    public void chooseFlight(String flight) {
        reservation2.chooseFlight(flight);
    }
}
