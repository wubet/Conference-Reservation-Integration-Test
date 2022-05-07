package org.uwb.edu.css533.cucumber.stepsDefintion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReservationStepDefinitions extends BaseStep {

    @Given("a valid endpoint to fetch reservations")
    public void aValidEndpointToFetchReservations() {
        reservationTestMethods.setUpReservationEndPointPath();
    }

    @When("the request is send to server with page number as {string} to get list of reservations")
    public void theRequestIsSendToServerWithPageNumberAsToGetListOfReservations(String arg0) {
        int page = Integer.parseInt(arg0);
        reservationTestMethods.sendReservationGetRequest(page);
    }

    @Then("validate the response of first reservation record having reservation description as {string}")
    public void validateTheResponseOfFirstReservationRecordHavingRoomNumberAs(String arg0) {
        reservationTestMethods.validateReservationData(arg0);
    }
}
