package sftpoperations;

import java.net.*;
import java.io.*;

public class ReadFileFromSFTP {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://domain.com/file.txt");
        //URL url = new URL();
        BufferedReader read = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String i;
        while ((i = read.readLine()) != null)
            System.out.println(i);
        read.close();
    }


}
