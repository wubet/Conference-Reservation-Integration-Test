package org.uwb.edu.css533.cucumber.stepsDefintion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RoomStepDefinitions extends BaseStep{

    @Given("a valid endpoint to fetch rooms")
    public void theValidEndpointToFetchRooms() {
        roomStepMethods.setUpRoomEndPointPath();
    }

    @When("the request is send to server with page number as {string} to get list of rooms")
    public void theRequestIsSendToServerWithPageNumberAsToGetListOfRooms(String arg0) {
        int page = Integer.parseInt(arg0);
        roomStepMethods.sendRoomGetRequest(page);
    }

    @Then("validate the response of first room record having room number as {string}")
    public void validateTheResponseOfFirstRoomRecordHavingRoomNumberAs(String arg0) {
        roomStepMethods.validateRoomData(arg0);
    }

    @Given("a valid endpoint with {string} and {string} and {string} and {string} and {string} and {string} payload to create a room")
    public void aValidEndpointWithAndAndAndAndAndPayloadToCreateARoom(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        int rmNumber = Integer.parseInt(arg0);
        int rmCapacity = Integer.parseInt(arg2);
        roomStepMethods.setupRoomEndpointAndPostData(rmNumber, arg1, rmCapacity, arg3, arg4, arg5);
    }

    @When("request is send to the server to create room")
    public void requestIsSendToTheServerToCreateRoom() {
        roomStepMethods.sendRoomPostRequest();;
    }

    @Then("the new user must be created with status code of {string} and room number as {string}")
    public void theNewUserMustBeCreatedWithStatusCodeOfAndRoomNumberAs(String arg0, String arg1) {
        int code = Integer.parseInt(arg0);
        roomStepMethods.validateRoomResponse(code, arg1);
    }

    @Given("a request URL with valid {string} id to get room details")
    public void aRequestURLWithValidIdToGetRoomDetails(String arg0) {
        roomStepMethods.setUpValidRoomEndPointUrl(arg0);
    }

    @When("request is send to the server to get room details")
    public void requestIsSendToTheServerToGetRoomDetails() {
        roomStepMethods.sendRequestToGetRoomDetails();
    }

    @Then("the response will return {string} and {string} and {string} of the room")
    public void theResponseWillReturnStatusAndIdAndEmailOfTheRoom(String arg0, String arg1, String arg2) {
        int code = Integer.parseInt(arg0);
        int id = Integer.parseInt(arg1);
        //int rmNumber = Integer.parseInt(arg2);
        roomStepMethods.validateRoomDetails(code, id, arg2);
    }

    @Given("the valid endpoint with id of {string} to update rooms")
    public void theValidEndpointWithIdOfToUpdateRooms(String arg0) {
        roomStepMethods.setUpValidRoomEndPointUrl(arg0);
    }

    @And("user detail of {string} and {string} and {string} and {string} and {string} and {string} payload to update a room data")
    public void userDetailOfAndAndAndAndAndPayloadToUpdateARoomData(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        int rmNumber = Integer.parseInt(arg0);
        int rmCapacity = Integer.parseInt(arg2);
        roomStepMethods.updatedRoomDetailData(rmNumber, arg1, rmCapacity, arg3, arg4, arg5);
    }

    @When("request is send to the server to update a room")
    public void requestIsSendToTheServerToUpdateARoom() {
        roomStepMethods.sendRoomPutRequest();
    }

    @Then("the room must be updated with status code of {string} and new email as {string}")
    public void theRoomMustBeUpdatedWithStatusCodeOfAndNewEmailAs(String arg0, String arg1) {
        int code = Integer.parseInt(arg0);
        roomStepMethods.validateRoomResponse(code, arg1);
    }

    @Given("the valid endpoint with id of {string} to delete a room")
    public void theValidEndpointWithIdOfToDeleteARoom(String arg0) {
        roomStepMethods.setUpValidRoomEndPointUrl(arg0);
    }

    @When("request is send to the server to delete a room")
    public void requestIsSendToTheServerToDeleteARoom() {
        roomStepMethods.sendRoomDeleteRequest();
    }

    @Then("the room must be deleted with status code of {string}")
    public void theRoomMustBeDeletedWithStatusCodeOf(String arg0) {
        int code = Integer.parseInt(arg0);
        roomStepMethods.validateRoomResponse(code);
    }

    @Then("the response will return {string} and {string} and room reservation time")
    public void theResponseWillReturnAndAndRoomReservationTime(String arg0, String arg1) {
        int code = Integer.parseInt(arg0);
        roomStepMethods.validateRoomDetail(code, arg1);
    }

    @Given("a valid url to get room availability")
    public void aValidUrlToGetRoomAvailability() {
        roomStepMethods.setRoomAvailabilityEndPointUrl();
    }

    @When("a request is send to fined room availability")
    public void aRequestIsSendToFinedRoomAvailability() {

    }

    @Then("the response will return {string} and must not return room with {string} and {string}")
    public void theResponseWillReturnAndMustNotReturnRoomWithAnd(String arg0, String arg1, String arg2) {
    }
}
