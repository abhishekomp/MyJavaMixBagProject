package corefundamentals.bufferedreadwrite;

import java.io.*;

public class DemoBufferedReadWrite {
    public static void main(String[] args) {
        doWriteUsingBufferedWriter();
        doReadUsingBufferedReader();
    }

    private static void doWriteUsingBufferedWriter() {
        //String[] numarray = {"one", "two", "three"};
        String[] strArray = new String[]{"one", "two", "three", "four", "five"};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DemoBufferedWriter.txt"))) {
            for (String str : strArray) {
                writer.write(str);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private static void doReadUsingBufferedReader() {
        try (BufferedReader reader = new BufferedReader(new FileReader("DemoBufferedWriter.txt"))){
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
