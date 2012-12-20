package MainWiredcats2012;

import edu.wpi.first.wpilibj.SimpleRobot;

/**
 * Main class for the Java version of Team 2415's 2012 C++ code
 *
 * @author lillychin
 */

public class JavaWiredcats2012 extends SimpleRobot {
    
    Threads.DriveThread driveTask;
    
    public JavaWiredcats2012() {
        driveTask = new Threads.DriveThread(this);
        
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
        driveTask.start();
        while (isOperatorControl() && isEnabled()) { //Not sure how necessary this loop is
            getWatchdog().feed(); 
            Thread.yield();
        }
        
        try {
            driveTask.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
