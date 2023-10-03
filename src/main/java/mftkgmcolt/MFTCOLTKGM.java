package mftkgmcolt;

import org.apache.commons.vfs2.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MFTCOLTKGM {

    String username;
    String password;
    String remoteHost;
    String remoteDir_UPL;
    String remoteDir_DWN;
    FileSystemManager manager;

    public MFTCOLTKGM() {

        this.username = "TUS-SWE-COL-TRS-01";
        this.password = ""; //ask for this
        this.remoteHost = "mfttestint.han.telia.se";
        this.remoteDir_UPL = "SWEIITCOLISCOLTRS01_UPL";
        this.remoteDir_DWN = "SWEIITCOLISCOLTRS02_DWN";
    }

    public void uploadFile(String filename) {
        try {
            manager = VFS.getManager();
            File f = new File(filename);
            System.out.println("File to upload = " + filename);
            String localDir = "upload/";
            FileObject local = manager.resolveFile(
                    System.getProperty("user.dir") + "/" + localDir + "/" + f.getName());
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir_UPL + "/" + f.getName());
            remote.copyFrom(local, Selectors.SELECT_SELF);

            local.close();
            remote.close();
            System.out.println("File sent through MFT OK");

        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    //COLT reads the download folder and downloads the file (files sent by KGM)
    public void downloadFile(String filename) {
        try {
            manager = VFS.getManager();
            File remotefile = new File(filename);
            System.out.println("File to download = " + remotefile.getAbsolutePath());
            String localDir = "downloads/";
            FileObject local = manager.resolveFile(
                    System.getProperty("user.dir") + "/" + localDir + "FileFromKGM.txt");
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir_DWN + "/" + remotefile.getName());

            local.copyFrom(remote, Selectors.SELECT_SELF);

            local.close();
            remote.close();
            System.out.println("File received through MFT OK");
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    //COLT reads the download folder (files sent by KGM)
    public void coltReadsDownloadFolder() {
        try {
            manager = VFS.getManager();

            System.out.println("Reading Download folder: " + remoteDir_DWN);
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir_DWN + "/");
            FileObject[] children = remote.getChildren();
            System.out.println("Number of files in " + remoteDir_DWN + " = " + children.length);
            for ( int i = 0; i < children.length; i++ ){
                System.out.println( children[ i ].getName().getBaseName() );
            }
            remote.close();
            System.out.println("Files read from the " + remoteDir_DWN);
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    public void coltDeleteFileFromDownloadFolder(String folderName, String fileToDelete) {
        try {
            manager = VFS.getManager();

            File f = new File(fileToDelete);
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + folderName + "/" + f.getName());
            int delete = remote.delete(Selectors.SELECT_SELF);
            System.out.println("delete=" + delete);
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }
}
