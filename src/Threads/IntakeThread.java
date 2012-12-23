package Threads;

import MainWiredcats2012.Joystick2415;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author LillyChin
 */
public class IntakeThread extends Thread2415 {
    
    Victor feed;
    Relay tower;

    public IntakeThread(MainWiredcats2012.JavaWiredcats2012 robot) {
        super(robot);
        feed = new Victor(5);
        tower = new Relay(8);
    }
    
    public void doDisabled() {
        tower.set(Relay.Value.kOff);
        feed.set(0.0);
    }

    public void doAutonomous() {
        
    }

    public void doTeleop() {
        
        if(Joystick2415.secondaryGetButtonB()) {
            feed.set(-1.0);
        } else {
            feed.set(0.0);
        }
        
        if(Joystick2415.secondaryGetButtonY()) {
            tower.set(Relay.Value.kForward);
            feed.set(1.0);
        }
    }
}
