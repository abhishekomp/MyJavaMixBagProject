package mftkgmcolt;

import org.apache.commons.vfs2.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class MTFTest {
    public static void main(String[] args) {
        new MTFTest().tst();
    }
    void tst() {

        System.out.println("Trying to copy file");
        FileSystemManager manager;
        try {
            manager = VFS.getManager();
            String username = "abhi";
            String password = "nikon800";
            String remoteHost = "131.116.76.22";
            String remoteDir = "/";


            File f = new File("cdtempty_file.txt");
            System.out.println("f.getAbsolutePath() = " + f.getAbsolutePath());
            Path path = Paths.get(f.getAbsolutePath());
            try {
                long bytes = Files.size(path);
                System.out.println("bytes = " + bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (false) return;

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
