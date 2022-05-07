package org.uwb.edu.css533.cucumber.stepsDefintion;

import org.uwb.edu.css533.cucumber.test.ReservationTestMethods;
import org.uwb.edu.css533.cucumber.test.RoomTestMethods;
import org.uwb.edu.css533.cucumber.test.UserTestMethods;

public class BaseStep {

    protected UserTestMethods userStepMethods;
    protected RoomTestMethods roomStepMethods;
    protected ReservationTestMethods reservationTestMethods;

    public BaseStep(){
        userStepMethods = new UserTestMethods();
        roomStepMethods = new RoomTestMethods();
        reservationTestMethods = new ReservationTestMethods();
    }
}
