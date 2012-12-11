/**
 * Main class for the Java version of Team 2415's 2012 C++ code
 * 
 * @author lillychin
 */

import edu.wpi.first.wpilibj.*;

public class JavaWiredcats2012 extends SimpleRobot {

    Victor vicLeft, vicRight;

    public JavaWiredcats2012() {
        vicLeft = new Victor(1);
        vicRight = new Victor(2);
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {

    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while(isOperatorControl()){
            vicLeft.set(Joystick2415.primaryGetLeftY());
            vicRight.set(Joystick2415.primaryGetRightY());
        }
    }
}
