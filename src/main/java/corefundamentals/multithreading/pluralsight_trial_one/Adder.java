package corefundamentals.multithreading.pluralsight_trial_one;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Adder {
    private String inFile, outFile;
    public Adder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }
    public void doAdd() throws IOException {
        int total = 0;
        String line = null;
        //try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile), Charset.forName("windows-1252"))) {
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while((line = reader.readLine()) != null) {
                //System.out.println("line = " + line);
                total = total + Integer.parseInt(line);
            }
            //System.out.println("total = " + total);
        }
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))) {
            //System.out.println("total = " + total);
            writer.write(String.valueOf(total));
            //writer.write("Total = " + total);
        }

        //        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
//            writer.write("Total = " + total);
//        }
    }
}
