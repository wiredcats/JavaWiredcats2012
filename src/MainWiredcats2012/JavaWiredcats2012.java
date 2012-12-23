package MainWiredcats2012;

import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Compressor;

/**
 * Main class for the Java version of Team 2415's 2012 C++ code
 *
 * Ugh, the ME edition of Java is really limited:
 * http://www.chiefdelphi.com/forums/showthread.php?t=106739
 * http://www.chiefdelphi.com/forums/showthread.php?t=106520&highlight=java+generics
 * ^^ why we can't have nice things
 * http://docs.oracle.com/javame/config/cldc/ref-impl/cldc1.1/jsr139/index.html
 *
 * Why we use Windriver for C++:
 * http://www.chiefdelphi.com/forums/showthread.php?t=89539&highlight=java+generics
 *
 * @author lillychin
 */
public class JavaWiredcats2012 extends SimpleRobot {

    //List of Threads = important!
    Threads.Thread2415 threads[] = {new Threads.DriveThread(this),
                                    new Threads.IntakeThread(this)};
    
    Compressor compressor;
 
    public JavaWiredcats2012() {
        compressor = new Compressor(6,1);
        compressor.start(); //I think this is ok, might need to move out to the autonomous / teleop functions
    }
    
    public void disabled() {
        while(isDisabled()) {
            getWatchdog().feed();
            Thread.yield();
        }
        
        try {
            for (int i = 0; i < threads.length; i++) { threads[i].join(); }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        while (isAutonomous()) {
            getWatchdog().feed(); //Again, I thought the watchdog was dead? Maybe Java is different
            Thread.yield();
        }
        
        try {
            for (int i = 0; i < threads.length; i++) { threads[i].join(); }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        for (int i = 0; i < threads.length; i++) { threads[i].start(); }

        while (isOperatorControl() && isEnabled()) { //Not sure how necessary this loop is
            getWatchdog().feed();
            Thread.yield();
        }

        try {
            for (int i = 0; i < threads.length; i++) { threads[i].join(); }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
