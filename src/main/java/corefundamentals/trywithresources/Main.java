package corefundamentals.trywithresources;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Main {
    public static void main(String[] args) {
        //doTryCatchFinally();
        //doTryWithResources();
        doTryWithResourcesMulti_CopyFile();
    }

    private static void doTryCatchFinally() {
        char[] buff = new char[8];
        int length;
        Reader reader = null;

        try {
            reader = Helper.openReader("file.txt");
            while((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength = " + length);
                for(int i = 0; i < length; i++) {
                    System.out.print(buff[i]);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
            }
        }
    }

    public static void doTryWithResources() {
        char[] buff = new char[8];
        int length = 8;

        try (Reader reader = Helper.openReader("file.txt")){
            while((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength = " + length);
                for(int i = 0; i < length; i++) {
                    System.out.print(buff[i]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    public static void doTryWithResourcesMulti_CopyFile() {
        char[] buff = new char[8];
        int length;

        try(Reader reader = Helper.openReader("file.txt");
            Writer writer = Helper.openWriter("file2.txt")) {
            while((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength = " + length);
                writer.write(buff, 0, length);
            }
        } catch(Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
