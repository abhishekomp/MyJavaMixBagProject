package mftdemo;

import org.apache.commons.vfs2.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MTFPutDemo {
    public static void main(String[] args) {
        new MTFPutDemo().tst();
    }
    void tst() {

        System.out.println("Trying to copy file");
        FileSystemManager manager;
        try {
            manager = VFS.getManager();
            String username = "TUS-SWE-CLI-SAP-01";
            String password = "";  //ask for this
            String remoteHost = "mfttestint.han.telia.se";
            String remoteDir = "SWEIITCLIISCLISAP01/";


            File f = new File("cdtempty_file.txt");
            System.out.println("f.getAbsolutePath() = " + f.getAbsolutePath());
            Path path = Paths.get(f.getAbsolutePath());
            try {
                long bytes = Files.size(path);
                System.out.println("bytes = " + bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //if (false) return;

            FileObject local = manager.resolveFile(f.getAbsolutePath());
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir + "/" + f.getName());

            remote.copyFrom(local, Selectors.SELECT_SELF);

            local.close();
            remote.close();
            System.out.println("File sent through MFT OK");

        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }
}
