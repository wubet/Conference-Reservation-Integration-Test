package org.uwb.edu.css533.cucumber.test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

public class BaseTest {

//    private final DesiredCapabilitiesUtil desiredCapabilitiesUtil = new DesiredCapabilitiesUtil();

//    private  static  final  String  BASE_URL  =  "https://www.loginradius.com";
//    String email = "abcxyz@mail7.io";
//    String password = "password";
//    RequestSpecification request;
    protected static Response response;
    protected static  String  jsonString;
    protected static Date meetingTime;

    protected static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
    protected static final String USERNAME = "TOOLSQA-Test";
    protected static final String PASSWORD = "Test@@123";
    protected static final String BASE_URL = "http://localhost:8080";


//    @BeforeMethod
//    @Parameters({ "udid", "platformVersion" })
//    public void setup(String udid, String platformVersion) throws IOException {
//        DesiredCapabilities caps = desiredCapabilitiesUtil.getDesiredCapabilities(udid, platformVersion);
//        ThreadLocalDriver.setTLDriver(new AndroidDriver<>(new URL("http://127.0.0.1:4444/wd/hub"), caps));
//    }
//    @AfterMethod
//    public synchronized void teardown() {
//        ThreadLocalDriver.getTLDriver().quit();
//    }
    public BaseTest(){

    }
}
