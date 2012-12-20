package Threads;

import MainWiredcats2012.Joystick2415;
import edu.wpi.first.wpilibj.Victor;

/**
 * Test to getting multithreading working
 * http://www.chiefdelphi.com/forums/showpost.php?p=966375&postcount=18
 *
 * @author LillyChin
 */

public class DriveThread extends Thread2415 {
    
    private Victor vicLeft;
    private Victor vicRight;
    
    public DriveThread(MainWiredcats2012.JavaWiredcats2012 robot) {
        super(robot);
        vicLeft = new Victor(1);
        vicRight = new Victor(2);
    }
    
    public void doDisabled() {
        vicLeft.set(0.0);
        vicRight.set(0.0);
    }
    
    public void doAutonomous() {
        vicLeft.set(0.0);
        vicRight.set(0.0);
    }
    
    public void doTeleop(){
        vicLeft.set(Joystick2415.primaryGetLeftY());
        vicRight.set(Joystick2415.primaryGetRightY());
    }
}