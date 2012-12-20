/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
        while (robot2415.isEnabled()) {
            while (robot2415.isAutonomous()) {
                doAutonomous();
                Thread.yield();
            }

            while (robot2415.isOperatorControl()) {
                doTeleop();
                Thread.yield();
            }
            Thread.yield();
        }
    }
    
    public abstract void doAutonomous();
    public abstract void doTeleop();
}
