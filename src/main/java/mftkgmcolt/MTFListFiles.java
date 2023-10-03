package mftkgmcolt;

import org.apache.commons.vfs2.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MTFListFiles {
    public static void main(String[] args) {
        new MTFListFiles().tst();
    }
    void tst() {

        System.out.println("Trying to list files");
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

            File remotefile = new File("cdtempty_file.txt");

            //FileObject local = manager.resolveFile(f.getAbsolutePath());
            String localDir = "downloads/";
            FileObject local = manager.resolveFile(
                    System.getProperty("user.dir") + "/" + localDir + "vfsFileDownload.txt");
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/");
            //FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir + f.getName());
            //int delete = remote.delete(Selectors.SELECT_SELF);
            //System.out.println("delete=" + delete);

            FileObject[] children = remote.getChildren();
            for ( int i = 0; i < children.length; i++ ){
                System.out.println( children[ i ].getName().getBaseName() );
            }
            //local.copyFrom(remote, Selectors.SELECT_SELF);

            local.close();
            remote.close();
            System.out.println("File Listing OK");

        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }
}
