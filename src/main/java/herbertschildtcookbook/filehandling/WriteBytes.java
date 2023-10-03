package herbertschildtcookbook.filehandling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by sca820 on 20 juni, 2022
 */
public class WriteBytes {
    public static void main(String[] args) {
        // This array contains the ASCII code for the letters A through J.
        byte[] vals = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74};
        FileOutputStream fout;
        try {
            // Open output file.
            fout = new FileOutputStream("Test.dat");
        } catch (FileNotFoundException exc) {
            System.out.println("Error Opening Output File");
            return;
        }
        try {
            // Write every other value in the vals array to the file.
            for (int i = 0; i < vals.length; i += 2)
                fout.write(vals[i]);
        } catch (IOException exc) {
            System.out.println("Error Writing File");
        }
        try {
            fout.close();
        } catch (IOException exc) {
            System.out.println("Error Closing File");
        }
    }
}
