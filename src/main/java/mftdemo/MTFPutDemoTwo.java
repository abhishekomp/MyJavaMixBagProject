package mftdemo;

import com.jcraft.jsch.*;

import java.util.Properties;


public class MTFPutDemoTwo {
    public static void main(String[] args) throws JSchException, SftpException {

        new MTFPutDemoTwo().setupJsch();
        //new MTFPutDemoTwo().uploadFile();
    }

    private ChannelSftp setupJsch() {

        JSch jSch;
        ChannelSftp channelSftp = null;
        Session session = null;
        try {
            Properties properties = new Properties();
            properties.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
            //properties.put("PreferredAuthentications", "password");
            properties.put("StrictHostKeyChecking", "no");
            //properties.put("UseDNS", "no");

            jSch = new JSch();
            //session = jSch.getSession("TUS-SWE-CLI-SAP-01", "mfttestint.han.telia.se", 22);
            session = jSch.getSession("abhi", "131.116.76.22");
            session.setConfig(properties);
            session.setTimeout(10 * 1_000);
            session.setPassword("nikon800");
            session.connect();
            channelSftp = (ChannelSftp)session.openChannel("sftp");
            channelSftp.connect();

            String localFile = "src/main/resources/sample.txt";
            String remoteDir = "/";

            channelSftp.put(localFile, remoteDir + "jschFile.txt");

            channelSftp.exit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channelSftp.disconnect();
            channelSftp.disconnect();
        }

        return channelSftp;
    }

    public void uploadFile() throws JSchException, SftpException {
        ChannelSftp channelSftp = setupJsch();
        channelSftp.connect();

        String localFile = "src/main/resources/sample.txt";
        String remoteDir = "/";

        channelSftp.put(localFile, remoteDir + "jschFile.txt");

        channelSftp.exit();
    }
}
