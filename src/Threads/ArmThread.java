package Threads;

/**
 * Split the old IntakeThread into Arm and Intake components Helps because we
 * can't use enums in Java so the old ARM_STATUS won't work Also just better
 * organized
 *
 * @author LillyChin
 */

/*
 * Up: A and D are on
 * To do bridge: Switch Off A and D, turn on C. Turn on B for set amount of time and then turn off. Turn A back on
 * 
 * Ball: A and C are on. D turns off. 
 * 
 * A can not be on while B is on. C can not be on while D is on. Out of these pairs, one must always be on.
 * 
 * Arm down is C
 * arm Up is D
 * Bridge up is A
 * Bridge down is B
 */
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

public class ArmThread extends Thread2415 {

    Solenoid bridgeUp, bridgeDown, ballDown, ballUp;
    Timer pulseTimer;
    boolean hasPulsed;

    public ArmThread(Wiredcats2012.JavaWiredcats2012 robot) {
        super(robot);
        ballUp = new Solenoid(1, 5);
        ballDown = new Solenoid(1, 6);

        bridgeUp = new Solenoid(1, 4);
        bridgeDown = new Solenoid(1, 3);

        pulseTimer = new Timer();
        hasPulsed = false;
        
        currentState = searchStates("ALL_UP");
    }

    protected String[] setThreadStates() {
        String[] output = {"ALL_UP",
                           "BRIDGE_PUSH",
                           "BALL_GRAB"};
        return output;
    }

    protected void doDisabled() {
        pulseTimer.stop();
        pulseTimer.reset();
        hasPulsed = false;
        currentState = searchStates("ALL_UP");
    }

    protected void doTeleop() {
    }

    protected void doAutonomous() {
    }
}
