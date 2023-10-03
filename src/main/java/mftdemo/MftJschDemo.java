package mftdemo;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.File;

public class MftJschDemo {
    public static void main(String[] args) throws JSchException {
        MftJschDemo mftJschDemo = new MftJschDemo();
        mftJschDemo.setupJsch();
        //mftJschDemo.uploadFile();
    }

    private void uploadFile() {

    }

    private ChannelSftp setupJsch() throws JSchException {
        JSch jsch = new JSch();
        String host = System.getProperty("user.home") + File.separator + ".ssh" + File.separator + "known_hosts";
        System.out.println("host = " + host);

        //jsch.setKnownHosts("/Users/john/.ssh/known_hosts");
        //jsch.setKnownHosts(host);
        Session jschSession = jsch.getSession("TUS-SWE-CLI-SAP-01", "mfttestint.han.telia.se");
        jschSession.setPassword("");   //ask for this
        jschSession.connect();
        return (ChannelSftp) jschSession.openChannel("sftp");
    }
}
