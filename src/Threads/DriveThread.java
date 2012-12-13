package Threads;

import MainWiredcats2012.Joystick2415;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Victor;
import java.util.TimerTask;

/**
 * Test to getting multithreading working
 * http://www.chiefdelphi.com/forums/showpost.php?p=966375&postcount=18
 *
 * @author LillyChin
 */

public class DriveThread extends Thread {
    private MainWiredcats2012.JavaWiredcats2012 robot2415;
    
    private Victor vicLeft;
    private Victor vicRight;
    
    public DriveThread(MainWiredcats2012.JavaWiredcats2012 robot) {
        robot2415 = robot;
        vicLeft = new Victor(1);
        vicRight = new Victor(2);
    }

    public void run() {
        while (robot2415.isOperatorControl() && robot2415.isEnabled()) {
            vicLeft.set(Joystick2415.primaryGetLeftY());
            vicRight.set(Joystick2415.primaryGetRightY());
            
            Thread.yield();
        }
    }
}