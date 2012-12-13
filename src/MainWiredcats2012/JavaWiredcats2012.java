package MainWiredcats2012;

import edu.wpi.first.wpilibj.SimpleRobot;

/**
 * Main class for the Java version of Team 2415's 2012 C++ code
 *
 * @author lillychin
 */

public class JavaWiredcats2012 extends SimpleRobot {
    
    public JavaWiredcats2012() {
        
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        while (isAutonomous()) {
        }
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
       
        Threads.DriveThread driveTask = new Threads.DriveThread(this);
        driveTask.start();
        while (isOperatorControl() && isEnabled()) {
            
            Thread.yield();
        }
        
        try {
            driveTask.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
