package corefundamentals.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class DemoPropertiesAsXML {
    public static void main(String[] args) {
        doStorePropsAsXML();
        doReadPropsFromXML();
    }

    private static void doReadPropsFromXML() {
        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(Paths.get("props.xml"))) {
            props.loadFromXML(in);

            String displayName = props.getProperty("displayName");
            System.out.println("displayName = " + displayName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void doStorePropsAsXML() {
        Properties props = new Properties();
        props.setProperty("displayName", "Abhishek");
        props.setProperty("accountNumber", "123-45-6789");

        try (OutputStream out = Files.newOutputStream(Paths.get("props.xml"))) {
            props.storeToXML(out, "MyComment");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
