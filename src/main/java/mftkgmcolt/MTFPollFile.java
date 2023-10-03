package mftkgmcolt;

import org.apache.commons.vfs2.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MTFPollFile {
    public static void main(String[] args) {
        new MTFPollFile().tst();
    }
    void tst() {

        System.out.println("Polling for file");
        FileSystemManager manager;
        FileObject remote = null;
        try {
            manager = VFS.getManager();
            String username = "abhi";
            String password = "nikon800";
            String remoteHost = "131.116.76.22";
            String remoteDir = "/";

            remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/");
            boolean foundColtFile = false;

            int maxWaitSeconds = 60;
            LocalDateTime end = LocalDateTime.now().plusSeconds(maxWaitSeconds);
            long start = System.currentTimeMillis();
            String endFormatted = end.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.println("About to wait for the file or a maximum of " + maxWaitSeconds + " seconds until " + endFormatted);

            do {
                FileObject[] children = remote.getChildren();
                for ( int i = 0; i < children.length; i++ ) {

                    String fileName = children[i].getName().getBaseName();
                    System.out.println(fileName);
                    if (fileName.startsWith("cdt")) {
                        foundColtFile = true;
                        break;
                    }

                }
                    if(!foundColtFile) {
                        int secondsLeft = Math.toIntExact(Math.max(0, (maxWaitSeconds - (System.currentTimeMillis() - start) / 1000)));
                        System.out.println("nothing, " + secondsLeft + " seconds left.");
                        sleep(5000);

                    }

            } while(((System.currentTimeMillis() - start) < (maxWaitSeconds * 1000L)) && !foundColtFile);

            System.out.println("foundColtFile: " + foundColtFile);
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
        finally {
            try {
                remote.close();
            } catch (FileSystemException e) {
                e.printStackTrace();
            }
        }
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
