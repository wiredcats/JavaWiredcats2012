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
    
    public ThreadState() {
        names.put(new Integer(WAIT_FOR_INPUT), "WAIT_FOR_INPUT");   
        names.put(new Integer(SHOOT), "SHOOT");
    }
    
    public static String toString(int state) {
        return (String)names.get(new Integer(state));
    }
}
