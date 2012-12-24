package Threads;

import Wiredcats2012.Joystick2415;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;

/**
 * Handles purely intake = feed and tower polycord
 *
 * @author LillyChin
 */
public class IntakeThread extends Thread2415 {

    Victor feed;
    Relay tower;

    public IntakeThread(Wiredcats2012.JavaWiredcats2012 robot) {
        super(robot);
        feed = new Victor(5);
        tower = new Relay(8);
    }

    protected void doDisabled() {
        tower.set(Relay.Value.kOff);
        feed.set(0.0);
    }

    protected void doTeleop() {
        if (Joystick2415.secondaryGetButtonB()) {
            feed.set(-1.0);
        } else {
            feed.set(0.0);
        }

        if (Joystick2415.secondaryGetButtonY()) {
            tower.set(Relay.Value.kForward);
            feed.set(1.0);
        }
    }

    protected void doAutonomous() {
    }

    protected void doThreadState() {
        switch (currentState) {
            case ThreadState.WAIT_FOR_INPUT:
                tower.set(Relay.Value.kOff);
                break;
            case ThreadState.SHOOT:
                tower.set(Relay.Value.kReverse);
                feed.set(-1.0);
                break;
            default:
                currentState = ThreadState.WAIT_FOR_INPUT;
                break;
        }
    }
}
