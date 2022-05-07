package org.uwb.edu.css533.cucumber.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

public class UserTestMethods extends BaseTest{

    JSONObject requestParams = null;

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = BASE_URL;
    }

    public void setUpUserEndPointPath(){
        RestAssured.basePath = "/api/v1/users";
    }

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

    public void validateUserData(String emailID)
    {
        String userEmail = response.path("content[0].email_id");
        Assert.assertEquals(emailID, userEmail);
    }

    public void setupUserEndpointAndPostData(String firstName, String lastName, String emailId)
    {
        setUpUserEndPointPath();
        requestParams = new JSONObject();
        DateTime dateTime = new DateTime();
        requestParams.put("first_name",firstName);
        requestParams.put("last_name", lastName);
        requestParams.put("email_id", emailId);
        requestParams.put("createDateTime", dateTime);
        requestParams.put("updateDateTime", dateTime);

    }

    public void sendUserPostRequest()
    {
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(requestParams.toString(1))
                .when()
                .post()
                .then()
                .statusCode(201).contentType(ContentType.JSON)
                .extract().response();
    }

    public void validateUserResponse(int code, String emailId)
    {
        String userEmail = response.jsonPath().getString("email_id");
        Assert.assertEquals(emailId, userEmail);
        Assert.assertEquals(code, response.statusCode());
    }

    public void setUpValidUserEndPointUrl(String id){
        RestAssured.basePath = "/api/v1/users/" + id;
    }

    public void sendRequestToGetUserDetails(){
        //setUpUserEndPointPath();
        //RestAssured.basePath = "/api/v1/users/" + id;
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .extract().response();
    }

    public void validateUserDetails(int code, int id, String emailId){
//        ResponseBody body = response.getBody();
//        String str = body.asString();
        JsonPath jsonPathEvaluator = response.jsonPath();
        int user_id = jsonPathEvaluator.get("user_id");
        String userEmail = response.jsonPath().getString("email_id");
        Assert.assertEquals(code, response.statusCode());
        Assert.assertEquals(id, user_id);
        Assert.assertEquals(emailId, userEmail);
    }

    public void updatedUserDetailData(String firstName, String lastName, String emailId) {
        //RestAssured.basePath = "/api/v1/users/" + id;
        requestParams = new JSONObject();
        DateTime dateTime = new DateTime();
        requestParams.put("first_name",firstName);
        requestParams.put("last_name", lastName);
        requestParams.put("email_id", emailId);
        requestParams.put("createDateTime", dateTime);
        requestParams.put("updateDateTime", dateTime);

    }

    public void sendUserPutRequest() {
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(requestParams.toString(1))
                .when()
                .put()
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .extract().response();
    }

    public void sendUserDeleteRequest(){

        response = given().log().uri()
                .when()
                .delete()
                .then()
                .statusCode(204)
                .extract().response();
    }

    public void validateUserResponse(int code)
    {
        Assert.assertEquals(code, response.statusCode());
    }
}
