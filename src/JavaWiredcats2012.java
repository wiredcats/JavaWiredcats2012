/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

import edu.wpi.first.wpilibj.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class JavaWiredcats2012 extends SimpleRobot {

    Victor vicLeft, vicRight;
    Joystick joy1;

    public JavaWiredcats2012() {
        vicLeft = new Victor(1);
        vicRight = new Victor(2);

        joy1 = new Joystick(1);
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
            vicLeft.set(joy1.getRawAxis(2));
            vicRight.set(joy1.getRawAxis(5));
        }
    }
}
