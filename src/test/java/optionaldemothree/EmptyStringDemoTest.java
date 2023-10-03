package optionaldemothree;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class EmptyStringDemoTest {

    @Test
    public void testOptionalWithBlankString() {
        EmptyStringDemo demo = new EmptyStringDemo();
        //String aName = demo.getAName(7);
        Optional<String> aName = Optional.ofNullable(demo.getAName(7));

        //System.out.println("got name = " + aName);

        String fetch_name = aName.filter(name -> name.length()>0).map(name -> "Fetched name = " + name).orElse("Could not fetch name");
        System.out.println(fetch_name);
    }

    @Test
    public void test_orElse() {
        String defaultStr = "DEFAULT";
        String status = "";
        Optional<String> status1 = Optional.ofNullable(status);
        System.out.println("Result=" + status1.orElse(defaultStr));
    }

}
