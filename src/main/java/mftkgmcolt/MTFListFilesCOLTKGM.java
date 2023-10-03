package mftkgmcolt;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MTFListFilesCOLTKGM {
    public static void main(String[] args) {
        new MTFListFilesCOLTKGM().tst();
    }
    void tst() {

        System.out.println("Trying to list files");
        FileSystemManager manager;
        try {
            manager = VFS.getManager();
            String username = "TUS-SWE-TRS-COL-01";
            String password = "";   //ask for this
            String remoteHost = "mfttestint.han.telia.se";
            String remoteDir = "SWEIITCOLISCOLTRS04_DWN";


            File f = new File("empty_file.txt");
            System.out.println("f.getAbsolutePath() = " + f.getAbsolutePath());
            Path path = Paths.get(f.getAbsolutePath());
            try {
                long bytes = Files.size(path);
                System.out.println("bytes = " + bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (false) return;

            File remotefile = new File("empty_file.txt");

            //FileObject local = manager.resolveFile(f.getAbsolutePath());
            String localDir = "downloads/";
            FileObject local = manager.resolveFile(
                    System.getProperty("user.dir") + "/" + localDir + "vfsFileDownload.txt");
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir + "/");
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
