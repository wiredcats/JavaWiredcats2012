package Threads;

/**
 * Thread superclass. Note that we only have to write the abstract functions for
 * other threads
 *
 * Basing fundamental code architecture after 2012 code and this:
 * http://www.chiefdelphi.com/forums/showpost.php?p=966375&postcount=18
 *
 * @author LillyChin
 */

import Util2415.CSVReader;

public abstract class Thread2415 extends Thread {

    private Wiredcats2012.JavaWiredcats2012 robot2415;
    protected String threadName;
    int currentState; //pseudo-Enum
    // I JUST WANT MY ENUMS DANG IT

    public Thread2415(Wiredcats2012.JavaWiredcats2012 robot) {
        robot2415 = robot;
        threadName = this.getClass().getName(); //This will not spit out "Thread2415" but the extended class, so we're all good
        currentState = ThreadState.WAIT_FOR_INPUT;
    }

    public void run() {
        while (true) {
            doThreadState();
            if (robot2415.isDisabled()) {
                doDisabled();
            }
            
            if (robot2415.isAutonomous() && robot2415.isEnabled()) {
                doAutonomous();
            }
            
            if(robot2415.isOperatorControl() && robot2415.isEnabled()) {
                doTeleop();
            }
            Thread.yield();
        }
    }

    protected abstract void doDisabled();
    protected abstract void doTeleop();
    protected abstract void doAutonomous();
    protected abstract void doThreadState();

    public String toString() {
        return threadName + " is in state " + ThreadState.toString(currentState);
    }
}
