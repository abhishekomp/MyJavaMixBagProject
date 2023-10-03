package corefundamentals.multithreading.pluralsight_trial_two.without_multithreading;

public class AdderMain {
    public static void main(String[] args) {

        String[] inFiles = {"file1.txt", "file2.txt"};
        String[] outFiles = {"outFile1.txt", "outFile2.txt"};

        for(int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            adder.doAdd();
        }
    }
}
