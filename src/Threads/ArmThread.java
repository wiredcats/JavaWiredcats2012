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

        currentState = ThreadState.WAIT_FOR_INPUT;
    }

    protected void doDisabled() {
        pulseTimer.stop();
        pulseTimer.reset();
        hasPulsed = false;
        currentState = ThreadState.WAIT_FOR_INPUT;
    }

    protected void doTeleop() {
        if (Wiredcats2012.Joystick2415.primaryGetLeftBumper()) {
            ballGrab();
        } else {
            armUp();
            if (Wiredcats2012.Joystick2415.primaryGetRightBumper()) {
                bridgeDown();
            }
        }
    }

    protected void doAutonomous() {
    }

    protected void doThreadState() {
        switch (currentState) {
            case ThreadState.WAIT_FOR_INPUT:
                armUp();
                break;
            case ThreadState.SHOOT:
                ballGrab();
                break;
            default:
                currentState = ThreadState.WAIT_FOR_INPUT;
                break;
        }
    }

    protected void armUp() {
        bridgeUp.set(true);
        ballUp.set(true);
        bridgeDown.set(false);
        ballDown.set(false);
        
        hasPulsed = false;
        pulseTimer.stop();
        pulseTimer.reset();
    }

    protected void ballGrab() {
//        if (!hasPulsed) {
//            hasPulsed = true;
//            bridgeUp.set(false);
//            ballUp.set(false);
//            ballDown.set(true);
//            pulseTimer.start();
//            bridgeDown.set(true);
//        }
//        if (hasPulsed && pulseTimer - > Get() >= global - > ReadCSV("PULSE_TIME")) {
//            pulseTimer.stop();
//            bridgeDown.set(false);
//            bridgeUp.set(true);
//        }

    }

    protected void bridgeDown() {
        bridgeDown.set(true);
        ballDown.set(true);
        ballUp.set(false);
        bridgeUp.set(false);
        
        hasPulsed = false;
        pulseTimer.stop();
        pulseTimer.reset();
    }
}
