package corefundamentals.multithreading.pluralsight_trial_one;

import java.io.IOException;

public class AdderMain {
    public static void main(String[] args) {
        //String[] inFiles = {"file1.txt", "file2.txt"};
        //String[] outFiles = {"outFile1.txt", "outFile2.txt"};

        String[] inFiles = {"fileOne.txt"};
        String[] outFiles = {"outFileOne.txt"};

        for(int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            try {
                adder.doAdd();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
