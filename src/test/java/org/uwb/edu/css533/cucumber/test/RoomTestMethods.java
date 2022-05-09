package org.uwb.edu.css533.cucumber.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONObject;
import org.junit.Assert;
import org.uwb.edu.css533.cucumber.common.Context;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RoomTestMethods extends BaseTest{

    JSONObject requestObject = null;

    /**
     * set up room url path
     */
    public void setUpRoomEndPointPath(){
        RestAssured.basePath = "/api/v1/rooms";
    }

    /**
     * submit room get request
     * @param page - request page index
     */
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

    /**
     * validate room response data
     * @param rmName - expected room name
     */
    public void validateRoomData(String rmName)
    {
        String roomName = response.path("content[0].room_name");
        Assert.assertEquals(rmName, roomName);
    }

    /**
     * prepare room post request payload data
     * @param rmNumber - room number
     * @param rmName - room name
     * @param rmCapacity - room capacity
     * @param rmLocation - room location
     * @param rmType - room type
     * @param status - room status
     */
    public void prepareRoomPayloadPostData(int rmNumber, String rmName, int rmCapacity, String rmLocation, String rmType, String status){
        requestObject = new JSONObject();
        DateTime dateTime = new DateTime();
        requestObject.put("room_number", rmNumber);
        requestObject.put("room_name", rmName);
        requestObject.put("room_capacity", rmCapacity);
        requestObject.put("room_location", rmLocation);
        requestObject.put("room_type", rmType);
        requestObject.put("status", status);
        requestObject.put("createDateTime", dateTime);
        requestObject.put("updateDateTime", dateTime);
    }

    /**
     * submit room post request
     */
    public void sendRoomPostRequest(){
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
     * validate room response
     * @param code expected response status code
     * @param rmName - expected room name
     */
    public void validateRoomResponse(int code, String rmName){
        String roomName = response.jsonPath().getString("room_name");
        Assert.assertEquals(rmName, roomName);
        Assert.assertEquals(code, response.statusCode());
    }

    /**
     * set up room url path with id
     * @param id room id
     */
    public void setUpValidRoomEndPointUrl(String id){
        RestAssured.basePath = "/api/v1/rooms/" + id;
    }

    /**
     * submit room get id request
     */
    public void sendRequestToGetRoomDetails(){
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .extract().response();
    }

    /**
     * validate room response detail
     * @param code expected response status code
     * @param id expected room id
     * @param rmName expected room name
     */
    public void validateRoomDetails(int code, int id, String rmName){
        int room_id = response.jsonPath().get("room_id");
        String roomName = response.jsonPath().getString("room_name");
        int reservation_id = response.jsonPath().get("reservations[0].reservation_id");
        String meetingTime = response.jsonPath().getString("reservations[0].meeting_start_time");

        scenarioContext.setContext(Context.RESERVATION_ID, reservation_id);
        scenarioContext.setContext(Context.ROOM_ID, room_id);
        scenarioContext.setContext(Context.MEETING_START_TIME, meetingTime);
        Assert.assertEquals(code, response.statusCode());
        Assert.assertEquals(id, room_id);
        Assert.assertEquals(rmName, roomName);
    }

    /**
     * prepare room update data
     * @param rmNumber - room number
     * @param rmName - room name
     * @param rmCapacity - room capacity
     * @param rmLocation - room location
     * @param rmType - room type
     * @param status - room status
     */
    public void prepareRoomUpdateData(int rmNumber, String rmName, int rmCapacity, String rmLocation, String rmType, String status) {
        requestObject = new JSONObject();
        DateTime dateTime = new DateTime();
        requestObject.put("room_number", rmNumber);
        requestObject.put("room_name", rmName);
        requestObject.put("room_capacity", rmCapacity);
        requestObject.put("room_location", rmLocation);
        requestObject.put("room_type", rmType);
        requestObject.put("status", status);
        requestObject.put("createDateTime", dateTime);
        requestObject.put("updateDateTime", dateTime);
    }

    /**
     * submit room put request
     */
    public void sendRoomPutRequest() {
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
    public void sendRoomDeleteRequest(){

        response = given().log().uri()
                .when()
                .delete()
                .then()
                .statusCode(204)
                .extract().response();
    }

    /**
     * validate room response
     * @param code expected response status code
     */
    public void validateRoomResponse(int code)
    {
        Assert.assertEquals(code, response.statusCode());
    }

    /**
     * get booked room id and its starting time and ending time from test context
     * @param id booked room id
     */
    public void bookedRoomDetailedData(int id){
        int room_id = id;
        int reservation_id = 2;
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime meetingTime = format.parseDateTime("2022-05-07 07:30:00");
        scenarioContext.setContext(Context.RESERVATION_ID, reservation_id);
        scenarioContext.setContext(Context.ROOM_ID, room_id);
        scenarioContext.setContext(Context.MEETING_START_TIME, meetingTime);

        DateTime meetingDateTime = new DateTime(scenarioContext.getContext(Context.MEETING_START_TIME));
        startDate =  meetingDateTime.minusMinutes(15);
        endDate = startDate.plusHours(1);
    }

    /**
     * set up rooms availability url
     */
    public void setRoomAvailabilityEndPointUrl(){
        RestAssured.basePath = "/api/v1/rooms/availability";
    }

    /**
     * submit room availability get request
     * @param page - request page index
     */
    public void sendRequestToGetRoomAvailability(int page){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("page",page);
        map.put("startTime",startDate);
        map.put("endTime",endDate);

        response = given().log().uri()
                .queryParams(map)
                .when()
                .get()
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
    }

    /**
     * validate a room booked with in a given duration is not returned in the response
     * @param code expected response status code
     * @param id not expected room id
     * @param rmName not expected room name
     */
    public void validateRoomAvailabilityDetail(int code, int id, String rmName){

        JsonPath js = new JsonPath(response.asString());
        int size = js.getInt("content.size()");
        Assert.assertEquals(code, response.statusCode());
        for(int i = 0; i < size; i++)
        {
            int rmId = js.get("content["+i+"].room_id");
            String roomName = js.getString("content["+i+"].room_name");
            Assert.assertNotEquals(id, rmId);
            Assert.assertNotEquals(rmName, roomName);
        }
    }
}
