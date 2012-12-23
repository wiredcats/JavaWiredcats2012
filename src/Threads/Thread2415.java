package Threads;

/**
 * Thread superclass. Note that we only have to write the abstract functions for other threads
 * 
 * Basing fundamental code architecture after 2012 code and this:
 * http://www.chiefdelphi.com/forums/showpost.php?p=966375&postcount=18
 * 
 * @author LillyChin
 */
public abstract class Thread2415 extends Thread {

    private Wiredcats2012.JavaWiredcats2012 robot2415;
    protected String threadName;
    protected String[] threadStates;
    int currentState;
//    private THREAD_STATE threadState; DANG YOUR LACK OF ENUMS 

    public Thread2415(Wiredcats2012.JavaWiredcats2012 robot) {
        robot2415 = robot;
        threadName = this.getClass().getName(); //This will not spit out "Thread2415" but the extended class, so we're all good
        threadStates = setThreadStates();
        currentState = 0;
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
    
    protected abstract String[] setThreadStates();
    protected abstract void doDisabled();
    protected abstract void doTeleop();
    protected abstract void doAutonomous();
    
    public String toString() {
        return threadName + " is in state " + threadStates[currentState];
    }
    
    public int searchStates(String str) {
        for(int i = 0; i < threadStates.length; i++) {
            if(threadStates[i].equals(str)) {
                return(i);
            }
        }
        return(0);
    }
}
