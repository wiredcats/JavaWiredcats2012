package Util2415;

import java.util.Hashtable;
import java.lang.Double;

/**
 * Code to read from CSV file and reupdate constants
 *
 * @author SamCrane
 */
public abstract class CSVReader {

    // They use a sort of pidgin Hashtable which works slightly differently
    // http://docs.oracle.com/javame/config/cldc/ref-impl/cldc1.1/jsr139/index.html
    
    private static Hashtable resources = new Hashtable();

    public static double getValue(String s) {
        OurDouble d = (OurDouble)resources.get(s); 
        return d.d;
    }

    public static void getFromFile(String s) {
        try {
            Scanner sc = new Scanner(s);
            String tempString;
            OurDouble tempDouble;
            while (sc.hasNext()) {
                tempString = sc.next();
                tempDouble = new OurDouble( Double.parseDouble(sc.next()) );
                resources.put(tempString, tempDouble);
            }
            sc.close();
        } catch (Exception ioe) {
            ioe.printStackTrace();
            System.exit(-1);
        }
    }
    
    private static class OurDouble
    {
        public double d;
        
        public OurDouble(double d1)
        {
            this.d = d1;
        }
    }
}
