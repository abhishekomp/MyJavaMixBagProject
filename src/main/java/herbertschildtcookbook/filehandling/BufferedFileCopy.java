package herbertschildtcookbook.filehandling;

import java.io.*;

/**
 * Created by sca820 on 20 juni, 2022
 */
//The following example shows both BufferedInputStream and BufferedOutputStream in
//action. It creates a program that copies a file. Because byte streams are used, any type of file
//can be copied, including those that contain text, data, or programs.
public class BufferedFileCopy {
    public static void main(String[] args) {
        BufferedInputStream fin;
        BufferedOutputStream fout;
        // First make sure that both files have been specified.
        if(args.length != 2) {
            System.out.println("Usage: BufferedFileCopy From To");
            return;
        }
        // Open an input file that is wrapped in a BufferedInputStream.
        try {
            fin = new BufferedInputStream(new FileInputStream(args[0]));
        } catch(FileNotFoundException exc) {
            System.out.println("Input File Not Found");
            return;
        }
        // Open an output file that is wrapped in a BufferedOutputStream.
        try {
            fout = new BufferedOutputStream(new FileOutputStream(args[1]));
        } catch(FileNotFoundException exc) {
            System.out.println("Error Opening Output File");
            // Close the open input file.
            try {
                fin.close();
            } catch(IOException exc2) {
                System.out.println("Error Closing Input File");
            }
            return;
        }
        // Copy the file.
        // Because buffered streams are used, the
        // read and write operations are automatically
        // buffered, which results in higher performance.
        try {
            int i;
            do {
                i = fin.read();
                if(i != -1) fout.write(i);
            } while(i != -1);
        } catch(IOException exc) {
            System.out.println("File Error");
        }
        try {
            fin.close();
        } catch(IOException exc) {
            System.out.println("Error Closing Input File");
        }
        try {
            fout.close();
        } catch(IOException exc) {
            System.out.println("Error Closing Output File");
        }
    }
}
