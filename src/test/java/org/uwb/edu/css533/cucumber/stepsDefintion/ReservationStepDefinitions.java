package org.uwb.edu.css533.cucumber.stepsDefintion;

import io.cucumber.java.en.And;
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

    @Given("a valid endpoint to create reservations")
    public void aValidEndpointToCreateReservations() {
        reservationTestMethods.setUpReservationEndPointPath();
    }

    @And("a valid payload of {string} and {string} and {string} and {string} reservation")
    public void aValidPayloadOfAndAndAndReservation(String arg0, String arg1, String arg2, String arg3) {
        int roomId = Integer.parseInt(arg0);
        int userId = Integer.parseInt(arg1);
        reservationTestMethods.setupReservationPayloadPostData(roomId, userId, arg2, arg3);
    }

    @When("request is send to the server to create reservation")
    public void requestIsSendToTheServerToCreateReservation() {
        reservationTestMethods.sendReservationPostRequest();
    }

    @Then("the new reservation must be created with status code of {string} and room description as {string}")
    public void theNewReservationMustBeCreatedWithStatusCodeOfAndRoomDescriptionAs(String arg0, String arg1) {
        int code = Integer.parseInt(arg0);
        reservationTestMethods.validateReservationResponse(code, arg1);
    }

    @Given("a request URL with valid {string} id to get reservation details")
    public void aRequestURLWithValidIdToGetReservationDetails(String arg0) {
        reservationTestMethods.setUpValidReservationEndPointUrl(arg0);
    }

    @When("request is send to the server to get reservation details")
    public void requestIsSendToTheServerToGetReservationDetails() {
        reservationTestMethods.sendRequestToGetReservationDetails();
    }

    @Then("the response will return {string} and {string} and {string} of the reservation")
    public void theResponseWillReturnAndAndOfTheReservation(String arg0, String arg1, String arg2) {
        int code = Integer.parseInt(arg0);
        int id = Integer.parseInt(arg1);
        reservationTestMethods.validateReservationDetails(code, id, arg2);
    }

    @Given("the valid endpoint with id of {string} to update reservation")
    public void theValidEndpointWithIdOfToUpdateReservation(String arg0) {
        reservationTestMethods.setUpValidReservationEndPointUrl(arg0);
    }

    @And("reservation detail of {string} and {string} and {string} and {string} payload to update a reservation data")
    public void reservationDetailOfAndAndAndPayloadToUpdateAReservationData(String arg0, String arg1, String arg2, String arg3) {
        int roomId = Integer.parseInt(arg0);
        int userId = Integer.parseInt(arg1);
        reservationTestMethods.prepareReservationUpdateData(roomId, userId, arg2, arg3);
    }

    @When("request is send to the server to update a reservation")
    public void requestIsSendToTheServerToUpdateAReservation() {
        reservationTestMethods.sendReservationPutRequest();
    }

    @Then("the reservation must be updated with status code of {string} and new email as {string}")
    public void theReservationMustBeUpdatedWithStatusCodeOfAndNewEmailAs(String arg0, String arg1) {
        int code = Integer.parseInt(arg0);
        reservationTestMethods.validateReservationResponse(code, arg1);
    }

    @Given("the valid endpoint with id of {string} to delete a reservation")
    public void theValidEndpointWithIdOfToDeleteAReservation(String arg0) {
        reservationTestMethods.setUpValidReservationEndPointUrl(arg0);
    }

    @When("request is send to the server to delete a reservation")
    public void requestIsSendToTheServerToDeleteAReservation() {
        reservationTestMethods.sendReservationDeleteRequest();
    }

    @Then("the reservation must be deleted with status code of {string}")
    public void theReservationMustBeDeletedWithStatusCodeOf(String arg0) {
        int code = Integer.parseInt(arg0);
        reservationTestMethods.validateReservationResponse(code);
    }

    @Given("a valid endpoint to get booked rooms")
    public void aValidEndpointToGetBookedRooms() {
        
    }

    @When("a request is send with page number as {string} and start date as {string} and end date as {string} to fined booked rooms")
    public void aRequestIsSendWithPageNumberAsAndStartDateAsAndEndDateAsToFinedBookedRooms(String arg0, String arg1, String arg2) {
        
    }

    @Then("the response will return {string} and must return room count as {string} number of rooms")
    public void theResponseWillReturnAndMustReturnRoomCountAsNumberOfRooms(String arg0, String arg1) {

    }
}
