package org.uwb.edu.css533.cucumber.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.junit.Assert;


import static io.restassured.RestAssured.given;

public class ReservationTestMethods extends BaseTest {

    JSONObject requestObject = null;
    JSONObject roomChildObject = null;
    JSONObject userChildObject = null;

    /**
     * set up reservation url path
     */
    public void setUpReservationEndPointPath(){
        RestAssured.basePath = "/api/v1/reservations";
    }

    /**
     * submit reservation get list request
     * @param page - request page index
     */
    public void sendReservationGetRequest(int page)
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
     * validate reservation response data
     * @param rsDescription - expected room description
     */
    public void validateReservationData(String rsDescription)
    {
        String reservationDescription = response.path("content[0].reservation_description");
        Assert.assertEquals(rsDescription, reservationDescription);
    }

    /**
     * prepare reservation post request payload data
     * @param roomId - reserved room id
     * @param userId - person who reserve the room
     * @param rsDescription -room description
     * @param status - set reservation status is active or not
     */
    public void setupReservationPayloadPostData(int roomId, int userId, String rsDescription, String status)
    {
        requestObject = new JSONObject();
        roomChildObject = new JSONObject();
        userChildObject = new JSONObject();
        DateTime dateTime = new DateTime();
        roomChildObject.put("room_id", roomId);
        userChildObject.put("user_id", userId);
        requestObject.put("meeting_start_time", dateTime.plusHours(1));
        requestObject.put("meeting_end_time", dateTime.plusHours(2));
        requestObject.put("reservation_description", rsDescription);
        requestObject.put("status", status);
        requestObject.put("createDateTime", dateTime);
        requestObject.put("updateDateTime", dateTime);
        requestObject.put("room", roomChildObject);
        requestObject.put("user", userChildObject);
    }

    /**
     * submit reservation put request
     */
    public void sendReservationPostRequest()
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
     * validate reservation response data
     * @param code - expected response status code
     * @param rsDescription - expected reservation description
     */
    public void validateReservationResponse(int code, String rsDescription)
    {
        String reservationDescription = response.jsonPath().getString("reservation_description");
        Assert.assertEquals(rsDescription, reservationDescription);
        Assert.assertEquals(code, response.statusCode());
    }

    /**
     * set up reservation url path with id
     * @param id - reservation id
     */
    public void setUpValidReservationEndPointUrl(String id){
        RestAssured.basePath = "/api/v1/reservations/" + id;
    }

    /**
     * submit reservation get id request
     */
    public void sendRequestToGetReservationDetails(){
        response = given().log().uri()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .extract().response();
    }

    /**
     * validate reservation response data
     * @param code - expected response status code
     * @param id - expected reservation id
     * @param rsDescription - expected reservation description
     */
    public void validateReservationDetails(int code, int id, String rsDescription){
        int reservation_id = response.jsonPath().get("reservation_id");
        String reservationDescription = response.jsonPath().getString("reservation_description");
        Assert.assertEquals(code, response.statusCode());
        Assert.assertEquals(id, reservation_id);
        Assert.assertEquals(rsDescription, reservationDescription);
    }

    /**
     * prepare reservation update data
     * @param roomId - reservation room id
     * @param userId - user id requested for reservation
     * @param rsDescription - reservation description
     * @param status - reservation status
     */
    public void prepareReservationUpdateData(int roomId, int userId, String rsDescription, String status) {
        requestObject = new JSONObject();
        roomChildObject = new JSONObject();
        userChildObject = new JSONObject();
        DateTime dateTime = new DateTime();
        roomChildObject.put("room_id", roomId);
        userChildObject.put("user_id", userId);
        requestObject.put("meeting_start_time", dateTime.plusHours(1));
        requestObject.put("meeting_end_time", dateTime.plusHours(2));
        requestObject.put("reservation_description", rsDescription);
        requestObject.put("status", status);
        requestObject.put("createDateTime", dateTime);
        requestObject.put("updateDateTime", dateTime);
        requestObject.put("room", roomChildObject);
        requestObject.put("user", userChildObject);
    }

    /**
     * submit reservation put request
     */
    public void sendReservationPutRequest() {
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
     * submit reservation delete request
     */
    public void sendReservationDeleteRequest(){

        response = given().log().uri()
                .when()
                .delete()
                .then()
                .statusCode(204)
                .extract().response();
    }

    /**
     * validate reservation response data
     * @param code - expected response status code
     */
    public void validateReservationResponse(int code)
    {
        Assert.assertEquals(code, response.statusCode());
    }

    /**
     * set up reservation booked url path with id
     */
    public void setReservationBookedEndPointUrl(){
        RestAssured.basePath = "/api/v1/reservations/booked";
    }

}
