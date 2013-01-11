package Util2415;

import java.io.InputStream;
import javax.microedition.io.InputConnection;
import javax.microedition.io.Connector;
import java.io.IOException;

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
            System.out.println("Lilly wuz here");
            input = connection.openDataInputStream();
            System.out.println("Maybe not here");
        } catch (IOException e) {
            //s was not declared, so I changed it to fileName
            System.out.println("Hi, this is Sam Crane with the error report:");
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

        try {
        //Unhappy with having input.read() return an int but then have "read" being a char
        //Tried casting it but then it was unhappy with uncaught IOExceptions
            char read = (char) input.read();
            System.out.println(read);
            while (read == ' ' || read == '\n') {
                read = (char) input.read();
                System.out.println(read + "~~~");
                if (read == END_CHARACTER) {
                    endOfFile = true;
                    System.out.println(s);
                    System.out.println("0---");
                    return s; //if the final character is found, then return this.
                }
            }
            while (read != ' ' && read != ',' && read != '\n') {
                s += read;
                System.out.println(s + "...");
                read = (char) input.read();
                System.out.println(read);
                if (read == END_CHARACTER) {
                    endOfFile = true;
                    System.out.println(s);
                    System.out.println("1---");
                    return s; //if the final character is found, then return this.
                }
            }
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("IOException: the file is not found");
            System.exit(-1);
        }
        System.out.println(s);
        System.out.println("2---");
        return s;
    }

    public boolean hasNext() {
        return !endOfFile; //they are logical opposites
        //the last piece of information will end
        //end in '#', to notify end of file.
    }

    public void close() {
        //Uncaught IO exception
        try {
            input.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("IOException: It couldn't close the file, which I personally do not understand");
        }
    }
}
