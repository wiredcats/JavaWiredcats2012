package Util2415;

import java.io.InputStream;
import javax.microedition.io.InputConnection;
import javax.microedition.io.Connector;

/**
 * Homebrew Scanner class
 *
 * @author SamCrane
 */
public class Scanner {

    public static final char END_CHARACTER = '#';
    private boolean endOfFile = false;
    InputStream input;

    public Scanner(String fileName) {
        try {
            InputConnection connection = (InputConnection) Connector.open("file:///" + fileName, Connector.READ);
            input = connection.openDataInputStream();
        } catch (Exception e) {
            //s was not declared, so I changed it to fileName
            System.out.println("File could not be opened. Most likely file " + fileName + " was misplaced."
            );
			e.printStackTrace();
            System.exit(-1);
        }
    }

    /* returns the next word in
     * the stream of data. A quirk to this
     * method is that if it finds the specified
     * "halt" value, '#'
     */
    public String next() {
        String s = "";
        //Unhappy with having input.read() return an int but then have "read" being a char
        //Tried casting it but then it was unhappy with uncaught IOExceptions
        char read = input.read();
        while (read == ' ') {
            read = input.read();
            if (read == END_CHARACTER) {
                endOfFile = true;
                return s; //if the final character is found, then return this.
            }
        }
        while (read != ' ') {
            s += read;
            read = input.read();
            if (read == END_CHARACTER) {
                endOfFile = true;
                return s; //if the final character is found, then return this.
            }
        }
        return s;
    }

    public boolean hasNext() {
        return !endOfFile; //they are logical opposites
                           //the last piece of information will end
                           //end in '#', to notify end of file.
    }

    public void close() {
        //Uncaught IO exception
        input.close();
    }
}
