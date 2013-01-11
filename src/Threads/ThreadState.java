package Threads;

/**
 * A pseudo enum class for thread states. 
 * Based on the StupidEnum.txt file found in Util2415
 * 
 * There is probably an unbelievably more efficient way to do this.
 *
 * @author LillyChin
 */

import java.util.Hashtable;

public final class ThreadState {
    private static Hashtable names = new Hashtable();

    //Have to do these stupid constants. Otherwise, can not do switching
    protected static final int WAIT_FOR_INPUT = 0;
    protected static final int SHOOT = 1;
    
    //At this point, I should probably pull out a flowchart and think about whether this is the smartest way to reorganize things
    // I.e. while splitting things into subsystems is good
    // I think I need to do some long and hard thinking about whether having states / controllers is the best way to communicate
    // Maybe I should just have lots of functions
    public ThreadState() {
        names.put(new Integer(WAIT_FOR_INPUT), "WAIT_FOR_INPUT");   
        names.put(new Integer(SHOOT), "SHOOT");
    }
    
    public static String toString(int state) {
        return (String)names.get(new Integer(state));
    }
}
