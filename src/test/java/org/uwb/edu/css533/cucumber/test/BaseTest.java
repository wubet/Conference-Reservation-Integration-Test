package org.uwb.edu.css533.cucumber.test;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.joda.time.DateTime;
import org.uwb.edu.css533.cucumber.TestContext.ScenarioContext;

public class BaseTest {

    protected static Response response;
    protected static DateTime startDate;
    protected static DateTime endDate;
//    protected static final String BASE_URL = "http://localhost:5000";
    protected static final String BASE_URL = "http://conferencereservation-env-2.eba-pjmr2epd.us-west-2.elasticbeanstalk.com";
    protected ScenarioContext scenarioContext;


    public BaseTest(){
        scenarioContext = new ScenarioContext();

        RestAssured.config=RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout",2000)
                        .setParam("http.connection.timeout", 2000));

        RestAssured.baseURI = BASE_URL;
    }
}
