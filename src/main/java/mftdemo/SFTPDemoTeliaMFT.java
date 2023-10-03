package mftdemo;

import com.jcraft.jsch.*;

import java.io.File;
import java.util.Properties;

public class SFTPDemoTeliaMFT {
    private static final String REMOTE_HOST = "mfttestint.han.telia.se";
    private static final String USERNAME = "TUS-SWE-CLI-SAP-01";
    private static final String PASSWORD = ""; //ask for this
    private static final int REMOTE_PORT = 22;
    private static final int SESSION_TIMEOUT = 10000;
    private static final int CHANNEL_TIMEOUT = 5000;

    public static void main(String[] args) {

        String localFile = "cdtempty_file.txt";
        String remoteFile = "SWEIITCLIISCLISAP01/cdtempty_file.txt";

        Session jschSession = null;

        try {

            File f = new File("cdtempty_file.txt");

            Properties properties = new Properties();
            //properties.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
            properties.put("PreferredAuthentications", "publickey,password");

            JSch jsch = new JSch();
            //jsch.setKnownHosts("/home/mkyong/.ssh/known_hosts");
            String host = System.getProperty("user.home") + File.separator + ".ssh" + File.separator + "known_hosts";
            jsch.setKnownHosts(host);
            jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);

            // authenticate using private key
            // jsch.addIdentity("/home/mkyong/.ssh/id_rsa");

            // authenticate using password
            jschSession.setPassword(PASSWORD);

            jschSession.setConfig(properties);

            // 10 seconds session timeout
            jschSession.connect(SESSION_TIMEOUT);

            Channel sftp = jschSession.openChannel("sftp");

            // 5 seconds timeout
            sftp.connect(CHANNEL_TIMEOUT);

            ChannelSftp channelSftp = (ChannelSftp) sftp;

            // transfer file from local to remote server
            channelSftp.put(localFile, remoteFile);

            // download file from remote server to local
            // channelSftp.get(remoteFile, localFile);

            channelSftp.exit();

        } catch (SftpException | JSchException e) {

            e.printStackTrace();

        } finally {
            if (jschSession != null) {
                jschSession.disconnect();
            }
        }

        System.out.println("Done");
    }
}
