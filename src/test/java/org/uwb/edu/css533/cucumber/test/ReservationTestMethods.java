package org.uwb.edu.css533.cucumber.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

public class ReservationTestMethods extends BaseTest {

    JSONObject requestParams = null;

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = BASE_URL;
    }

    public void setUpReservationEndPointPath(){
        RestAssured.basePath = "/api/v1/reservations";
    }

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

    public void validateReservationData(String rsDescription)
    {
        String reservationDescription = response.path("content[0].reservation_description");
        Assert.assertEquals(rsDescription, reservationDescription);
    }
}
