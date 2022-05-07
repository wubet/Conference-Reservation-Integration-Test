package org.uwb.edu.css533.cucumber.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class RoomTestMethods extends BaseTest{

    JSONObject requestParams = null;

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = BASE_URL;
    }

    public void setUpRoomEndPointPath(){
        RestAssured.basePath = "/api/v1/rooms";
    }

    public void sendRoomGetRequest(int page)
    {
        response = given().log().uri()
                .queryParam("page",page).
                when().
                get().
                then().
                contentType(ContentType.JSON).
                extract().response();
    }

    public void validateRoomData(String rmName)
    {
        String roomName = response.path("content[0].room_name");
        Assert.assertEquals(rmName, roomName);
    }

    public void setupRoomEndpointAndPostData(int rmNumber, String rmName, int rmCapacity, String rmLocation, String rmType, String status)
    {
        setUpRoomEndPointPath();
        requestParams = new JSONObject();
        DateTime dateTime = new DateTime();
        requestParams.put("room_number", rmNumber);
        requestParams.put("room_name", rmName);
        requestParams.put("room_capacity", rmCapacity);
        requestParams.put("room_location", rmLocation);
        requestParams.put("room_type", rmType);
        requestParams.put("status", status);
        requestParams.put("createDateTime", dateTime);
        requestParams.put("updateDateTime", dateTime);
    }

    public void sendRoomPostRequest()
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

    public void validateRoomResponse(int code, String rmName)
    {
        String roomName = response.jsonPath().getString("room_name");
        Assert.assertEquals(rmName, roomName);
        Assert.assertEquals(code, response.statusCode());
    }

    public void setUpValidRoomEndPointUrl(String id){
        RestAssured.basePath = "/api/v1/rooms/" + id;
    }

    public void sendRequestToGetRoomDetails(){
        //RestAssured.basePath = "/api/v1/rooms/" + id;
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .extract().response();
    }

    public void validateRoomDetails(int code, int id, String rmName){
//        ResponseBody body = response.getBody();
//        String str = body.asString();
        JsonPath jsonPathEvaluator = response.jsonPath();
        int room_id = jsonPathEvaluator.get("room_id");
        String roomName = response.jsonPath().getString("room_name");
        Assert.assertEquals(code, response.statusCode());
        Assert.assertEquals(id, room_id);
        Assert.assertEquals(rmName, roomName);
    }

    public void updatedRoomDetailData(int rmNumber, String rmName, int rmCapacity, String rmLocation, String rmType, String status) {
        requestParams = new JSONObject();
        DateTime dateTime = new DateTime();
        requestParams.put("room_number", rmNumber);
        requestParams.put("room_name", rmName);
        requestParams.put("room_capacity", rmCapacity);
        requestParams.put("room_location", rmLocation);
        requestParams.put("room_type", rmType);
        requestParams.put("status", status);
        requestParams.put("createDateTime", dateTime);
        requestParams.put("updateDateTime", dateTime);
    }

    public void sendRoomPutRequest() {
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .body(requestParams.toString(1))
                .when()
                .put()
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .extract().response();
    }

    public void sendRoomDeleteRequest(){

        response = given().log().uri()
                .when()
                .delete()
                .then()
                .statusCode(204)
                .extract().response();
    }

    public void validateRoomResponse(int code)
    {
        Assert.assertEquals(code, response.statusCode());
    }

    public void validateRoomDetail(int code, String rmName){
        JsonPath jsonPathEvaluator = response.jsonPath();
        meetingTime = jsonPathEvaluator.get("reservations.meeting_start_time");
        String roomName = response.jsonPath().getString("room_name");
        Assert.assertEquals(code, response.statusCode());
        Assert.assertEquals(rmName, roomName);
    }

    public void setRoomAvailabilityEndPointUrl(){
        RestAssured.basePath = "/api/v1/rooms/availability";
    }
}
