package herbertschildtcookbook.filehandling.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sca820 on 20 juni, 2022
 */
// Use a FileReader to display a text file.
//
// To use this program, specify the name
// of the file that you want to see.
// For example, to see a file called Test.txt,
// use the following command line.
//
// java DisplayTextFile Test.txt
//
public class DisplayTextFile {
    public static void main(String[] args) {
        FileReader fr;

        // First make sure that a file has been specified.
        if(args.length != 1) {
            System.out.println("Usage: DisplayTextFile file");
            return;
        }

        try{
            //open the file
            fr = new FileReader(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " not found");
            return;
        }

        // At this point, the file is open and
        // its contents can be read.
        try{
            int ch;
            do{
                ch = fr.read();
                if(ch != -1) System.out.print((char)ch);
            } while(ch != -1);
        } catch(IOException exc) {
            System.out.println("Error Reading File");
        }
        try {
            fr.close();
        } catch(IOException exc) {
            System.out.println("Error closing File");
        }
    }
}
