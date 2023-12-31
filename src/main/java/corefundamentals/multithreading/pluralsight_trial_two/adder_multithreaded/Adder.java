package corefundamentals.multithreading.pluralsight_trial_two.adder_multithreaded;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Adder implements Runnable {
    private final String inFile, outFile;

    public Adder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    private void doAdd() throws IOException {
        int total = 0;
        String line = null;
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while((line = reader.readLine()) != null) {
                total += Integer.parseInt(line);
            }
        }
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))) {
            writer.write(String.valueOf(total));
        }
    }
    @Override
    public void run() {
        try {
            doAdd();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " finished");
        }
    }
}
