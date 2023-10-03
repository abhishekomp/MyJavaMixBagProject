package mftkgmcolt;

import org.apache.commons.vfs2.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MTFTestDownload {
    public static void main(String[] args) {
        new MTFTestDownload().tst();
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


            File f = new File("empty_file_downloaded.txt");
            System.out.println("f.getAbsolutePath() = " + f.getAbsolutePath());
            Path path = Paths.get(f.getAbsolutePath());
            try {
                long bytes = Files.size(path);
                System.out.println("bytes = " + bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (false) return;

            File remotefile = new File("cdtempty_file.txt");

            //FileObject local = manager.resolveFile(f.getAbsolutePath());
            String localDir = "downloads/";
            FileObject local = manager.resolveFile(
                    System.getProperty("user.dir") + "/" + localDir + "vfsFileDownload.txt");
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir + remotefile.getName());

            local.copyFrom(remote, Selectors.SELECT_SELF);

            local.close();
            remote.close();
            System.out.println("File received through MFT OK");

        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }
}
