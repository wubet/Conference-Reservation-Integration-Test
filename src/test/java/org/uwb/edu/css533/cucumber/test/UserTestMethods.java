package org.uwb.edu.css533.cucumber.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class UserTestMethods extends BaseTest{

    JSONObject requestObject = null;

    /**
     * set up user url path
     */
    public void setUpUserEndPointPath(){
        RestAssured.basePath = "/api/v1/users";
    }

    /**
     * submit room get list request
     * @param page - request page index
     */
    public void sendUserGetRequest(int page)
    {
        response = given().log().uri()
                .queryParam("page",page).
                when().
                get().
                then().
                contentType(ContentType.JSON).
                extract().response();
    }

    /**
     * validate user response
     * @param emailID - expected user email id
     */
    public void validateUserData(String emailID)
    {
        String userEmail = response.path("content[0].email_id");
        Assert.assertEquals(emailID, userEmail);
    }

    /**
     * prepare user post request payload data
     * @param firstName - user first name
     * @param lastName - user last name
     * @param emailId - user email id
     */
    public void prepareUserPayloadPostData(String firstName, String lastName, String emailId)
    {
        requestObject = new JSONObject();
        DateTime dateTime = new DateTime();
        requestObject.put("first_name",firstName);
        requestObject.put("last_name", lastName);
        requestObject.put("email_id", emailId);
        requestObject.put("createDateTime", dateTime);
        requestObject.put("updateDateTime", dateTime);

    }

    /**
     * submit user post request
     */
    public void sendUserPostRequest()
    {
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(requestObject.toString(1))
                .when()
                .post()
                .then()
                .statusCode(201).contentType(ContentType.JSON)
                .extract().response();
    }

    /**
     * validate user response data
     * @param code - expected response status code
     * @param emailId - expected user email id
     */
    public void validateUserResponse(int code, String emailId)
    {
        String userEmail = response.jsonPath().getString("email_id");
        Assert.assertEquals(emailId, userEmail);
        Assert.assertEquals(code, response.statusCode());
    }

    /**
     * set up user url path with id
     * @param id - user id
     */
    public void setUpValidUserEndPointUrl(String id){
        RestAssured.basePath = "/api/v1/users/" + id;
    }

    /**
     *
     */
    public void sendRequestToGetUserDetails(){
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .extract().response();
    }

    /**
     *
     * @param code - expected response status code
     * @param id
     * @param emailId
     */
    public void validateUserDetails(int code, int id, String emailId){
        int user_id = response.jsonPath().get("user_id");
        String userEmail = response.jsonPath().getString("email_id");
        Assert.assertEquals(code, response.statusCode());
        Assert.assertEquals(id, user_id);
        Assert.assertEquals(emailId, userEmail);
    }

    /**
     * prepare user update data
     * @param firstName - user first name
     * @param lastName - user last name
     * @param emailId - user email id
     */
    public void prepareUserUpdateData(String firstName, String lastName, String emailId) {
        requestObject = new JSONObject();
        DateTime dateTime = new DateTime();
        requestObject.put("first_name",firstName);
        requestObject.put("last_name", lastName);
        requestObject.put("email_id", emailId);
        requestObject.put("createDateTime", dateTime);
        requestObject.put("updateDateTime", dateTime);

    }

    /**
     * submit user put request
     */
    public void sendUserPutRequest() {
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(requestObject.toString(1))
                .when()
                .put()
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .extract().response();
    }

    /**
     * submit room delete request
     */
    public void sendUserDeleteRequest(){

        response = given().log().uri()
                .when()
                .delete()
                .then()
                .statusCode(204)
                .extract().response();
    }

    /**
     * validate user response
     * @param code - expected response status code
     */
    public void validateUserResponse(int code)
    {
        Assert.assertEquals(code, response.statusCode());
    }
}
