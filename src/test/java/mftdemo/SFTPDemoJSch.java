package mftdemo;

import com.jcraft.jsch.*;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.fail;


import java.io.File;
import java.util.Properties;

@Disabled("Disabled until I have a sftp server to test against")
public class SFTPDemoJSch {
    public static void main(String[] args) {
        SFTPDemoJSch sftpDemoJSch = new SFTPDemoJSch();
        sftpDemoJSch.sendFile();
    }

    private void sendFile() {
        System.out.println("Trying to copy file");
        Session jschSession = null;
        final int SESSION_TIMEOUT = 10000;
        final int CHANNEL_TIMEOUT = 5000;

        try {
            String username = "abhi";
            String password = "nikon800";
            String remoteHost = "131.116.76.22";
            String remoteDir = "/";

            String localFile = "cdtempty_file.txt";
            String remoteFile = remoteDir + "cdtempty_file.txt";

            Properties properties = new Properties();
            properties.put("PreferredAuthentications", "publickey,password");
            properties.put("StrictHostKeyChecking", "no");

            JSch jsch = new JSch();
            String host = System.getProperty("user.home") + File.separator + ".ssh" + File.separator + "known_hosts";
            jsch.setKnownHosts(host);
            jschSession = jsch.getSession(username, remoteHost);
            jschSession.setPassword(password);

            jschSession.setConfig(properties);

            // 10 seconds session timeout
            jschSession.connect(SESSION_TIMEOUT);

            Channel sftp = jschSession.openChannel("sftp");

            // 5 seconds timeout
            sftp.connect(CHANNEL_TIMEOUT);

            ChannelSftp channelSftp = (ChannelSftp) sftp;

            // transfer file from local to remote server
            channelSftp.put(localFile, remoteFile);

            channelSftp.exit();

        } catch (JSchException | SftpException e) {
            e.printStackTrace();
            System.out.println("In Exception");
            fail("Could not send file through MFT");
        }finally {
            System.out.println("In Finally");
            if (jschSession != null) {
                jschSession.disconnect();
            }
        }

        System.out.println("Done");
    }
}
