package corefundamentals.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sca820 on 30 juni, 2022
 */
public class ReadingTextFile {
    public static void main(String[] args) {
        //String sourceFile = "files/loremipsum.txt";
        //String targetFile = "files/loremipsum-copied.txt";
        String sourceFile = "files/MyStory.txt";
        String targetFile = "files/MyStory-copied.txt";



        try(FileReader fr = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(fr);
        ){
            String line = null;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
