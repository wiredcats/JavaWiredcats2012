package MainWiredcats2012;

/**
 * Replaces the former "Global" joystick interface with a more descriptive file
 * Works with robot - 12/13/12
 * 
 * @author lillychin
 */

import edu.wpi.first.wpilibj.Joystick;

public class Joystick2415 {
    
    private static final Joystick primaryController = new Joystick(1);
    private static final Joystick secondaryController = new Joystick(2);
    
    //Primary Controller
    public static double primaryGetLeftX() { return primaryController.getRawAxis(1); }
    public static double primaryGetLeftY() { return primaryController.getRawAxis(2); } 
    public static double primaryGetRightX() {return primaryController.getRawAxis(4); }
    public static double primaryGetRightY() { return primaryController.getRawAxis(5); }
    public static double primaryGetDPadX() { return primaryController.getRawAxis(6); }

    public static boolean primaryGetLeftTrigger() { return (primaryController.getRawAxis(3) > 0); }
    public static boolean primaryGetRightTrigger() { return (primaryController.getRawAxis(3) < 0); }

    public static boolean primaryGetButtonA() {return primaryController.getRawButton(1); }
    public static boolean primaryGetButtonB() {return primaryController.getRawButton(2); }
    public static boolean primaryGetButtonX() {return primaryController.getRawButton(3); }
    public static boolean primaryGetButtonY() {return primaryController.getRawButton(4); }
    public static boolean primaryGetLeftBumper() {return (primaryController.getRawButton(5)); }
    public static boolean primaryGetRightBumper() { return(primaryController.getRawButton(6)); }
    public static boolean primaryGetButtonBack() { return primaryController.getRawButton(7); }
    public static boolean primaryGetButtonStart() {return primaryController.getRawButton(8); }
    public static boolean primaryGetLeftPushDown() {return primaryController.getRawButton(9); }
    public static boolean primaryGetRightPushDown() {return primaryController.getRawButton(10); }

    //Secondary Controller
    public static double secondaryGetLeftX() { return secondaryController.getRawAxis(1); }
    public static double secondaryGetLeftY() { return secondaryController.getRawAxis(2); } 
    public static double secondaryGetRightX() {return secondaryController.getRawAxis(4); }
    public static double secondaryGetRightY() { return secondaryController.getRawAxis(5); }
    public static double secondaryGetDPadX() { return secondaryController.getRawAxis(6); }

    public static boolean secondaryGetLeftTrigger() { return (secondaryController.getRawAxis(3) > 0); }
    public static boolean secondaryGetRightTrigger() { return (secondaryController.getRawAxis(3) < 0); }

    public static boolean secondaryGetButtonA() {return secondaryController.getRawButton(1); }
    public static boolean secondaryGetButtonB() {return secondaryController.getRawButton(2); }
    public static boolean secondaryGetButtonX() {return secondaryController.getRawButton(3); }
    public static boolean secondaryGetButtonY() {return secondaryController.getRawButton(4); }
    public static boolean secondaryGetLeftBumper() {return (secondaryController.getRawButton(5)); }
    public static boolean secondaryGetRightBumper() { return(secondaryController.getRawButton(6)); }
    public static boolean secondaryGetButtonBack() { return secondaryController.getRawButton(7); }
    public static boolean secondaryGetButtonStart() {return secondaryController.getRawButton(8); }
    public static boolean secondaryGetLeftPushDown() {return secondaryController.getRawButton(9); }
    public static boolean secondaryGetRightPushDown() {return secondaryController.getRawButton(10); }   
}
