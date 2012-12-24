package Threads;

import Wiredcats2012.Joystick2415;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;

/**

 *
 * @author LillyChin
 */
public class DriveThread extends Thread2415 {

    private Victor vicLeft, vicRight;
    private Solenoid brakeOff, brakeNow;
    private Timer brakeTimer; //The timer formerly known as stupidTimer
    private boolean isBraked, firstTime, prevBState;

    public DriveThread(Wiredcats2012.JavaWiredcats2012 robot) {
        super(robot);
        vicLeft = new Victor(1);
        vicRight = new Victor(2);

        brakeOff = new Solenoid(1, 8);
        brakeNow = new Solenoid(1, 7);

        brakeTimer = new Timer();
    }

    protected void doDisabled() {
        vicLeft.set(0.0);
        vicRight.set(0.0);
        
        brakeTimer.stop();
        brakeTimer.reset();
        isBraked = false;
        
        prevBState = false;
        firstTime = true;
        
        currentState = ThreadState.WAIT_FOR_INPUT;
    }

    protected void doTeleop() {
        vicLeft.set(Joystick2415.primaryGetLeftY());
        vicRight.set(Joystick2415.primaryGetRightY());
    }

    protected void doAutonomous() {
        vicLeft.set(0.0);
        vicRight.set(0.0);
    }
    
    protected void doThreadState() {
        switch(currentState) {
            default:
                currentState = ThreadState.WAIT_FOR_INPUT;
                break;
        }
    }
}