package readfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileDemo {

    public void readPath() {
        //https://stackoverflow.com/questions/3844307/how-to-read-file-from-relative-path-in-java-project-java-io-file-cannot-find-th
        File directory = new File("./");
        System.out.println(directory.getAbsolutePath());

        String currentPath = System.getProperty("user.dir");
        System.out.println("currentPath = "+ currentPath);
    }

    public List<String> readTextFile() {
        List<String> readLines = new ArrayList<>();
        //try (FileReader file = new FileReader("readfile/sample.txt");
        try (FileReader file = new FileReader("C:\\MyJava\\AdventOfCode2021\\2-Dec\\input_partone.txt");
             BufferedReader fileStream = new BufferedReader(file);
        ) {
            String temp = null;
            while ((temp = fileStream.readLine()) != null) {
                readLines.add(temp);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return readLines;
    }

    //this worked fine by placing the resource file in the resources directory by creating the same package and then placing the file inside that package
    //Need to try this: https://howtodoinjava.com/java/io/read-file-from-resources-folder/
    public void try_getResource() {
        System.out.println(ReadFileDemo.class.getResource(""));
        System.out.println(ReadFileDemo.class.getResource("/"));

        try (InputStream is = ReadFileDemo.class.getResourceAsStream("/readfile/sample.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(is));){
            final String line = br.readLine();
            System.out.println("line = " + line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadFileDemo readFileDemo = new ReadFileDemo();
        readFileDemo.try_getResource();
//        readFileDemo.readPath();
//        final List<String> strings = readFileDemo.readTextFile();
//        strings.forEach(System.out::println);
//        readFileDemo.readFileFromPackage();
    }
}
