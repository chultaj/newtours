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
    public void i_provide_username_and_password(DataTable creds) {
        welcome.sendUserName(creds.cell(0,0));
        welcome.sendPassword(creds.cell(0,1));
    }

    @When("^click Sign-In button$")
    public void click_sign_in_button() {
        reservation = welcome.clickSignIn();
    }

    @When("^I click continue button$")
    public void i_click_continue_button() {
        reservation2 = reservation.clickContinue();
    }

    @When("^I click continue button2$") // Continue button on the second page(reservation)
    public void i_click_continue_button2() {
        purchase = reservation2.clickContinue();
    }

    @When("^I click Secure Purchase$")
    public void i_click_secure_purchase() {
        purchase2 = purchase.clickContinue();

    }

    @When("^I provide flight details$")
    public void i_provide_flight_details(DataTable details ) {
        reservation.setDepartureMonth(details.cell(0,0).split(" ")[0]);
        reservation.setDepartureDay(details.cell(0,0).split(" ")[1]);
        reservation.setDestination(details.cell(0,2));
        reservation.setReturnMonth(details.cell(0,1).split(" ")[0]);
        reservation.setReturnDay(details.cell(0,1).split(" ")[1]);
    }

    @When("^I provide flight details: \"(.*?)\" \"(.*?)\" \"(.*?)\"")
    public void i_provide_flight_details(String departure, String comeBack, String destination) {
        reservation.setDepartureMonth(departure.split(" ")[0]);
        reservation.setDepartureDay(departure.split(" ")[1]);
        reservation.setDestination(destination);
        reservation.setReturnMonth(comeBack.split(" ")[0]);
        reservation.setReturnDay(comeBack.split(" ")[1]);
    }

    @When("^I choose flight \"(.*?)\"")
    public void i_choose_flight(String flight) {
        reservation2.chooseFlight(flight);
    }

    @When("I provide flight details: (oneway|roundtrip)")
    public void i_provide_flight_details(String type) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
