package org.uwb.edu.css533.cucumber.stepsDefintion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UserStepDefinitions extends BaseStep{


    @Given("a valid endpoint to fetch users")
    public void theValidEndpointToFetchUsers() {
        userStepMethods.setUpUserEndPointPath();
    }

//    @When("^the request is send to server with page number as \"([^\"]*)\"$")
//    public void send_to_server_with_page_number(int pageNumber)
//    {
//        userStepMethods.sendGetRequest(pageNumber);;
//    }
    @When("the request is send to server with page number as {string} to get list of users")
    public void theRequestIsSendToServerWithPageNumberAs(String arg0) {
        int page = Integer.parseInt(arg0);
        userStepMethods.sendUserGetRequest(page);;
    }

//    @Then("^validate the response of first user record having email as \"([^\"]*)\"$")
//    public void validate_the_response(String emailID){
//
//        userStepMethods.validateUserData(emailID);
//    }

    @Then("validate the response of first user record having email as {string}")
    public void validateTheResponseOfFirstUserRecordHavingEmailAs(String arg0) {
        userStepMethods.validateUserData(arg0);
    }

//    @Given("^a valid endpoint with \"(.*?)\" and \"(.*?)\" and \"(.*?)>\" payload to create a user$")
//    public void valid_endpoint_with_payload (String firstName, String lastName, String emailId)
//    {
//           userStepMethods.setupEndpointAndPostData(firstName, lastName, emailId);
//    }

    @Given("a valid endpoint with {string} and {string} and {string} payload to create a user")
    public void aValidEndpointWithAndAndPayloadToCreateAUser(String arg0, String arg1, String arg2) {
        userStepMethods.setupUserEndpointAndPostData(arg0, arg1, arg2);
    }

//    @When("^request is send to the server to create user$")
//    public void user_create_request_send_to_server()
//    {
//        userStepMethods.sendCreateUserPostRequest();
//    }
    @When("request is send to the server to create user")
    public void requestIsSendToTheServerToCreateUser() {

        userStepMethods.sendUserPostRequest();
    }

//    @Then("^the new user must be created with status code of \"(.*?)\" and email as \"(.*?)\"$")
//    public void user_created_with_name(int code, String emailId)
//    {
//        userStepMethods.validateUserResponse(code, emailId);
//    }

    @Then("the new user must be created with status code of {string} and email as {string}")
    public void theNewUserMustBeCreatedWithStatusCodeOfAndEmailAs(String arg0, String arg1) {
        int code = Integer.parseInt(arg0);
        userStepMethods.validateUserResponse(code, arg1);
    }

//    @Given("^a request URL with valid \"(.*?)\" id to get user details$")
//    public void sendRequest(String id){
//        userStepMethods.sendRequestToGetUserDetails(id);
//    }

    @Given("a request URL with valid {string} id to get user details")
    public void aRequestURLWithValidIdToGetUserDetails(String arg0) {
        userStepMethods.setUpValidUserEndPointUrl(arg0);
    }

    @When("request is send to the server to get user details")
    public void requestIsSendToTheServerToGetUserDetails() {
        userStepMethods.sendRequestToGetUserDetails();
    }

//    @Then("^the response will return status \"(.*?)\" and id \"(.*?)\" and email \"(.*?)\" of the user$")
//    public void verifyStatus(int code, int id, String emailId ){
//
//    }

    @Then("the response will return {string} and {string} and {string} of the user")
    public void theResponseWillReturnStatusAndIdAndEmailOfTheUser(String arg0, String arg1, String arg2) {
        int code = Integer.parseInt(arg0);
        int id = Integer.parseInt(arg1);
        userStepMethods.validateUserDetails(code, id, arg2);
    }

//    @Given("a valid endpoint with {string} and {string} and {string} and {string} payload to update a user data")
//    public void aValidEndpointWithAndAndAndPayloadToUpdateAUserData(String arg0, String arg1, String arg2, String arg3) {
//        int id = Integer.parseInt(arg0);
//        userStepMethods.updatedUserDetailData(id, arg1, arg2, arg3);
//    }

    @Given("the valid endpoint with id of {string} to update a users")
    public void theValidEndpointWithIdOfToUpdateAUsers(String arg0) {
        userStepMethods.setUpValidUserEndPointUrl(arg0);
    }

    @And("user detail of {string} and {string} and {string} payload to update a user data")
    public void userDetailOfAndAndPayloadToUpdateAUserData(String arg0, String arg1, String arg2) {
        userStepMethods.updatedUserDetailData(arg0, arg1, arg2);
    }

    @When("request is send to the server to update a user")
    public void requestIsSendToTheServerToUpdateAUser() {
        userStepMethods.sendUserPutRequest();
    }

    @Then("the user must be updated with status code of {string} and new email as {string}")
    public void theUserMustBeUpdatedWithStatusCodeOfAndNewEmailAs(String arg0, String arg1) {
        int code = Integer.parseInt(arg0);
        userStepMethods.validateUserResponse(code, arg1);
    }

    @Given("the valid endpoint with id of {string} to delete a user")
    public void theValidEndpointWithIdOfToDeleteAUsers(String arg0) {
        userStepMethods.setUpValidUserEndPointUrl(arg0);
    }

    @When("request is send to the server to delete a user")
    public void requestIsSendToTheServerToDeleteAUser() {
        userStepMethods.sendUserDeleteRequest();
    }

    @Then("the user must be deleted with status code of {string}")
    public void theUserMustBeUpdatedWithStatusCodeOf(String arg0) {
        int code = Integer.parseInt(arg0);
        userStepMethods.validateUserResponse(code);
    }
}
