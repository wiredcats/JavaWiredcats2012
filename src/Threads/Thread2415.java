package Threads;

/**
 *
 * @author LillyChin
 */
public abstract class Thread2415 extends Thread {

    private MainWiredcats2012.JavaWiredcats2012 robot2415;

    public Thread2415(MainWiredcats2012.JavaWiredcats2012 robot) {
        robot2415 = robot;
    }

    public void run() {
        while (true) {
            while (robot2415.isDisabled()) {
                doDisabled();
            }

            while (robot2415.isAutonomous() && robot2415.isEnabled()) {
                doAutonomous();
                Thread.yield();
            }

            while (robot2415.isOperatorControl() && robot2415.isEnabled()) {
                doTeleop();
                Thread.yield();
            }
            Thread.yield();
        }
    }

    public abstract void doDisabled();
    public abstract void doAutonomous();
    public abstract void doTeleop();
}
