package MainWiredcats2012;

import edu.wpi.first.wpilibj.SimpleRobot;

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

    public JavaWiredcats2012() {
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        while (isAutonomous()) {

            getWatchdog().feed(); //Again, I thought the watchdog was dead? Maybe Java is different
            Thread.yield();
        }
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        while (isDisabled()) {
            getWatchdog().feed();
            Thread.yield();
        }

        while (isAutonomous() && isEnabled()) {
            getWatchdog().feed();
            Thread.yield();
        }

        while (isOperatorControl() && isEnabled()) { //Not sure how necessary this loop is
            getWatchdog().feed();
            Thread.yield();
        }

        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
